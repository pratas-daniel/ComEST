package menus;

import java.util.List;

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

		int pidx = 0;
		do {
			consola.clear();
			// TODO atribuir os valores adequados às variáveis 
			String nomeRest = "nome do restaurante";
			consola.println( nomeRest + "\n\nPratos já pedidos" );
			
			// TODO passar aqui a lista de escolhas 
			printEscolhas( null );
			
			// TODO apresentar a informação pedida
			float preco = 2.5f;
			float taxaEntrega = 2.5f;
			float pesoTotal = 1000;
			float precoTotal = 5.0f;
			consola.println( String.format("\nCusto pedido:  %6.2f€", preco ) );
			consola.println( String.format(  "Custo entrega: %6.2f€  por  %4dg", taxaEntrega, pesoTotal ) );
			consola.println( String.format(  "Total:         %6.2f€\n", precoTotal ) ); 
			consola.println( "Escolha um prato\n0 para confirmar o pedido\n-1 para cancelar\n" + 
					         "Pratos disponibilizados");
			
			// TODO listar os pratos disponibilizados pelos restaurante
			printPratos( null );
			consola.print("\nPrato: ");
			pidx = consola.readInt() ;
			// TODO se o índice escolhido for válido, apresentar o prato
			if( Math.abs(2 ) == 2 ) {
				// TODO se o índice é válido, apresentar o prato e respetivas opções 
				escolherOpcoesPrato( null, null );
			}
		} while( pidx != 0 && pidx != -1 );

		consola.clear();
		if( pidx == 0 ) {
			// TODO ver se o pedido tem pratos incluídos (substituir a condição, claro)
			if( Math.abs( 2 ) == 2 ) {
				// TODO adicionar o pedido ao sistema e ver o código
				String codigo = "Um código gerado pelo sistema";
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
	private void printEscolhas(List<Escolha> escolhas) {
		if( escolhas.size() == 0 )
			consola.println( "<Ainda sem pratos no pedido>" );
		// TODO para cada escolha imprimir
		String nomePrato ="Nome do prato";
		float precoPrato = 2.5f;
		consola.println( String.format("%-40s %6.2f€", nomePrato, precoPrato ) );
		// TODO para cada opção do prato imprimir
		String nomeOpcao = "nome da opção";
		float custoOpcao = 0.3f;
		consola.println( String.format("     %-35s %6.2f€", nomeOpcao, custoOpcao ) );
	}
	
	/** apresenta, na consola, uma lista de pratos
	 * @param pratos a lista de pratos a apresentar
	 */
	private void printPratos(List<Prato> pratos) {
		if( pratos.size() == 0 )
			consola.println( "<Sem pratos>" );
		// TODO para cada prato imprimir a informação solicitada
		for( int i = 0; i < pratos.size(); i++ ) {
			String nome = "nome prato";
			float preco = 2.5f;
			consola.println( String.format("%2d:%-40s %6.2f€", i+1, nome, preco ) );
		}
	}

	/** apresenta os restaurantes associados e pede ao utilizador para escolher um
	 * @return o restaurante selecionado ou null, caso não haja seleção
	 */
	private Restaurante escolherRestaurante() {
		// TODO listar os restaurantes do sistema  
		for( int i = 0; i < 1; i++  ) {
			String nomeRest = "Nome restaurante";
			consola.println( (i+1) + ": " + nomeRest );
		}
		consola.print( "\nRestaurante: " );
		int ridx = consola.readInt() - 1;
		// TODO ver se o escolhido é válido
		if( Math.abs( 2 ) == -2 ) {
			consola.println( "Restaurante inválido!" );
			consola.readLine();
			return null;
		}		
	
		// TODO selecionar o restaurante escolhido
		String nome = "Nome restaurante escolhido";
		String desc = "Descrição do restaurante ewscolhido";
		consola.println( "\n\n" + nome + "\n" + desc + "\n\nOferta:");
		// TODO apresentar os pratos do restaurante
		printPratos( null );
		
		// TODO se confirmar é preciso retornar o restaurante
		consola.println( "Escolher o restaurante? (0: confirmar)" );
		int sim = consola.readInt();
		return sim == 0? null: null;
	}
	
	/** Apresenta as opções do prato selecionado e pede para confirmar o prato como 
	 * sendo escolhido
	 * @param pedido o pedido em processamento
	 * @param prato o prato a ser observado e eventualemente escolhido
	 */
	private void escolherOpcoesPrato(Pedido pedido, Prato prato) {
		// TODO usar este array booleano (que deve ter o mesmo tamanho da lista de opções)
		//      para saber quais as opções que estão selecionadas
		int numOpcoes = 1;
		boolean select[] = new boolean[ numOpcoes ];
		
		// TODO apresentar info do prato
		String nomePrato = "Nome do prato";
		String descPrato = "Descrição do prato";
		float precoPrato = 2.5f;
		String infoPrato = nomePrato + "\n" + descPrato +
				           "\nPreço base: "+ String.format("%6.2f€",precoPrato) + "\n\n" +
		                   "Selecione (desselecione) as opções pretendidas\n" +
				           "0 para confirmar\n-1 para cancelar\n";

		int oidx = 0;
		do {
			consola.clear();
			consola.println( infoPrato );
			float precoTotal = 2.8f;
			consola.println( String.format("Custo: %6.2f €", precoTotal ) );
			for( int i = 0; i < numOpcoes; i++  ) {
				consola.print( select[i]? "(o) ": "( ) " );
				String nomeOpcao = "Uma opção";
				float custoOpcao = 0.3f;
				consola.println( String.format("%2d: %-35s %6.2f€", i+1, nomeOpcao, custoOpcao ) );
			}
			consola.println( "Opção: ");
			oidx = consola.readInt();
			if( oidx > 0 && oidx <= numOpcoes ) {
				int idx = oidx-1;
				select[idx] = !select[idx];
				if( select[idx] )
					;// TODO adicionar opção à seleção
				else
					;// TODO remover opção à seleção
			}
		} while( oidx != 0 && oidx != -1 );
		if( oidx == 0 ) {
			// TODO se confirmar, adicionar o rato e respetivas opções selecionadas ao pedido			
		}
			
	}

	/** Apresenta informação sucinta sobre um dado pedido
	 */
	private void verPedido() {
		consola.clear();
		consola.println( "Código? " );
		String code = consola.readLine();
		
		// TODO ver qual o pedido associado ao código, se algum
		Pedido p = null;
		if( Math.abs( 2 ) == -2 ) {
			consola.println("Pedido inexistente!");
			consola.readLine();
			return;			
		}
		
		consola.clear();
		// TODO apresentar informação do pedido e restaurante
		String codigo = "Código do pedido a ver";
		String nomeRestaurante = "Nome do restaurante onde o pedido foi feito";
		float precoTotal = 2.8f;
		consola.println( "Pedido " + codigo +
				         "\nRestaurante:" + nomeRestaurante +
				         "\nPreço: " + precoTotal + "€\n\n");

		// TODO apresentar sumário das escolhas do pedido
		for( int i=0; i < 1; i++ ) {
			String nomePrato = "Nome dum prato escolhido";
			consola.println( nomePrato );
			for( int k=0; k < 1; k++  ) {
				String nomeOpcao = "Opção escolhida";
				consola.println("    " + nomeOpcao );
			}
		}
		consola.readLine();
	}

}
