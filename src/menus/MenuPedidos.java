package menus;

import java.util.ArrayList;

import consola.SConsola;
import restaurante.*;
import sistema.*;

/**
 * Classe que trata dos menus que simula a "aplicação movel"
 */
public class MenuPedidos {
	
	private SConsola consola = new SConsola("Menu ComEST", 630, 30, 500, 600);
	private ComEST server;    // servidor ao qual o simulador está ligado 
	
	/** Cria o menu da aplicação móvel
	 * @param s o servidor a que vai ligar
	 * @param u o utilizador a simular inicialmente 
	 */
	public MenuPedidos( ComEST s ){
		server = s;
	}

	/**
	 * menu que simula o telemóvel da aplicação
	 */
	public void menuPrincipal(){

		char opcao = 0;
		do {
			String menu = "Menu de consumidor\n" +  
					"1- Fazer pedido\n"+
					"2- Ver pedido\n"; 
			consola.clear();
			consola.println( menu );
			opcao = consola.readChar();
			switch( opcao ){
			case '1':
				fazerPedido();
				break;
			case '2':
				verPedido();
				break;
			default:
				consola.println( "opção inválida");
				consola.readLine();
			}
		} while( true );
	}


	/**
	 * Regista um código na aplicação 
	 */
	private void fazerPedido( ) {
		consola.clear();
		Restaurante r = escolherRestaurante();
		if( r == null )
			return;
		Pedido p = new Pedido(r);
		int pidx = 0;
		do {
			consola.clear();
			String nomeRest = r.getNome();
			consola.println( nomeRest + "\n\nPratos já pedidos" );
			printEscolhas( p.getEscolhas() );
			float preco = p.getPreco();
			float taxaEntrega = p.getTaxa();
			int pesoTotal = p.getPeso();
			float precoTotal = p.getPreco() + p.getTaxa();
			consola.println( String.format("\nCusto pedido:  %6.2f€", preco ) );
			consola.println( String.format(  "Custo entrega: %6.2f€  por  %4dg", taxaEntrega, pesoTotal ) );
			consola.println( String.format(  "Total:         %6.2f€\n", precoTotal ) ); 
			consola.println( "Escolha um prato\n0 para confirmar o pedido\n-1 para cancelar\n" + 
					         "Pratos disponibilizados");
			
			printPratos(r.getPratos());
			consola.print("\nPrato: ");
			pidx = consola.readInt();
			if(pidx > 0 && pidx <= r.getPratos().size()) { 
				escolherOpcoesPrato( p, r.getPratos().get(pidx - 1) );
			}
		} while( pidx != 0 && pidx != -1 );

		consola.clear();
		if( pidx == 0 ) {
			if( p.getEscolhas() != null ) {
				String codigo = GeradorCodigos.gerarCodigo(6);
				p.setId(codigo);
				server.addPedido(p);
				r.addPedido(p);
				consola.println( "O seu pedido foi aceite!\n\nPara saber informações use o código " + codigo );
			} else {
				consola.println( "O seu pedido não for confirmado porque não tinha nenhum prato escolhido!" );
			}
		} else {
			consola.println( "O seu pedido foi cancelado a seu pedido!" );
		}
		consola.readLine();
	}

	/** apresenta, na consola, uma lista de escolhas
	 * @param escolhas a lista de escolhas a apresentar
	 */
	private void printEscolhas(ArrayList<Escolha> escolhas) {
		if( escolhas == null ) {
			consola.println( "<Ainda sem pratos no pedido>" );
			return;
		}
		for (Escolha e : escolhas) {
			String nomePrato = e.getPrato().getNome();
			float precoPrato = e.getPrato().getPreco();
			consola.println( String.format("%-40s %6.2f€", nomePrato, precoPrato ) );
			for (Opcao o : e.getOpcoes()) {
				String nomeOpcao = o.getNome();
				float custoOpcao = o.getPreco();
				consola.println( String.format("     %-35s %6.2f€", nomeOpcao, custoOpcao ) );
			}
		}
	}
	
	/** apresenta, na consola, uma lista de pratos
	 * @param pratos a lista de pratos a apresentar
	 */
	private void printPratos(ArrayList<Prato> pratos) {
		if( pratos.size() == 0 )
			consola.println( "<Sem pratos>" );
		for( int i = 0; i < pratos.size(); i++ ) {
			Prato prato = pratos.get(i);
			String nome = prato.getNome();
			float preco = prato.getPreco();
			consola.println( String.format("%2d:%-40s %6.2f€", i+1, nome, preco ) );
		}
	}

	/** apresenta os restaurantes associados e pede ao utilizador para escolher um
	 * @return o restaurante selecionado ou null, caso não haja seleção
	 */
	private Restaurante escolherRestaurante() {
		ArrayList<Restaurante> restaurantes = server.getRestaurantes(); 
		for( int i = 0; i < restaurantes.size(); i++  ) {
			String nomeRest = restaurantes.get(i).getNome();
			consola.println( (i+1) + ": " + nomeRest );
		}
		consola.print( "\nRestaurante: " );
		int ridx = consola.readInt() - 1;
		if(ridx < 0 || ridx >= restaurantes.size()) {
			consola.println( "Restaurante inválido!" );
			consola.readLine();
			return null;
		}		
		Restaurante restaurante = restaurantes.get(ridx);

		String nome = restaurante.getNome();
		String desc = restaurante.getDescricao();
		consola.println( "\n\n" + nome + "\n" + desc + "\n\nOferta:");
		printPratos( restaurante.getPratos() );
		
		consola.println( "Escolher o restaurante? (0: confirmar)" );
		int sim = consola.readInt();
		return sim == 0? restaurante: null;
	}
	
	/** Apresenta as opções do prato selecionado e pede para confirmar o prato como 
	 * sendo escolhido
	 * @param pedido o pedido em processamento
	 * @param prato o prato a ser observado e eventualemente escolhido
	 */
	private void escolherOpcoesPrato(Pedido pedido, Prato prato) {
		int numOpcoes = prato.getOpcoes().size();
		boolean select[] = new boolean[ numOpcoes ];
		
		String nomePrato = prato.getNome();
		String descPrato = prato.getDescricao();
		float precoPrato = prato.getPreco();
		String infoPrato = nomePrato + "\n" + descPrato +
				           "\nPreço base: "+ String.format("%6.2f€",precoPrato) + "\n\n" +
		                   "Selecione (desselecione) as opções pretendidas\n" +
				           "0 para confirmar\n-1 para cancelar\n";

		int oidx = 0;
		Escolha e = new Escolha(prato);
		do {
			consola.clear();
			consola.println( infoPrato );
			float precoTotal = e.getPreco();
			consola.println( String.format("Custo: %6.2f €", precoTotal ) );
			for( int i = 0; i < numOpcoes; i++  ) {
				consola.print( select[i]? "(o) ": "( ) " );
				String nomeOpcao = prato.getOpcoes().get(i).getNome();
				float custoOpcao = prato.getOpcoes().get(i).getPreco();
				consola.println( String.format("%2d: %-35s %6.2f€", i+1, nomeOpcao, custoOpcao ) );
			}
			consola.println( "Opção: ");
			oidx = consola.readInt();
			if( oidx > 0 && oidx <= numOpcoes ) {
				int idx = oidx-1;
				select[idx] = !select[idx];
				if( select[idx] )
					e.addOpcao(prato.getOpcoes().get(idx));
				else
					e.removeOpcao(prato.getOpcoes().get(idx));
			}
		} while( oidx != 0 && oidx != -1 );
		if( oidx == 0 ) {
			pedido.addEscolha(e);
			pedido.setTaxa(pedido.getPeso());
		}
			
	}

	/** Apresenta informação sucinta sobre um dado pedido
	 */
	private void verPedido() {
		consola.clear();
		consola.println( "Código? " );
		String code = consola.readLine();
		for (Pedido p : server.getPedidos()) {
			if (p.getId().equals(code)) {
				consola.clear();
				String codigo = p.getId();
				String nomeRestaurante = p.getRestaurante().getNome();
				float precoTotal = p.getPreco();
				consola.println( "Pedido " + codigo +
						         "\nRestaurante:" + nomeRestaurante +
						         "\nPreço: " + precoTotal + "€\n\n");
				for( Escolha e : p.getEscolhas() ) {
					String nomePrato = e.getPrato().getNome();
					consola.println( nomePrato );
					for( Opcao o : e.getOpcoes() ) {
						String nomeOpcao = o.getNome();
						consola.println("    " + nomeOpcao );
					}
				}
				consola.readLine();
				return;
			}	
		}
		consola.println("Pedido inexistente!");
		consola.readLine();	
	}
}
