package menus;

import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import consola.SConsola;
import restaurante.*;
import sistema.*;

/**
 * Classe que trata dos menus do servidor
 */
public class MenuServidor {
	
	private SConsola consola = new SConsola("Menu do ComEST", 30, 30, 500, 600);
	private ComEST server;

	/** Cria a interface para o menu principal
	 * @param s o servidor para o qual se está a cria a interface
	 */
	public MenuServidor( ComEST s ){
		server = s;
	}

	/**
	 * menu principal da aplicação
	 */
	public void menuPrincipal(){
		char opcao = 0;
			
		do {
			String menu = "Menu Administrador\n\n" + 
					"1- Ver Pedidos totais\n"+
					"2- Ver pedidos por restaurante\n" + 
					"\n0- Sair";
			consola.clear();
			consola.println( menu );
			opcao = consola.readChar();
			switch( opcao ){
			case '1':
				verTodosPedidos();
				break;
			case '2':
				verPedidosRestaurante();
				break;
			case '0': break;
			default:
				consola.println( "opção inválida");
				consola.readLine();
			}
		} while( opcao != '0' );

		consola.close();					// desligar o menu da central	
		System.exit( 0 );
	}

	/** Apresenta todos os pedidos existentes no sistema
	 * 
	 */
	private void verTodosPedidos() {
		verPedidos( server.getPedidos() );		
	}

	/** Apresenta todos os pedidos presentes na lista
	 * 
	 */
	private void verPedidos( Collection<Pedido> pedidos ) {
		consola.clear();
		for( Pedido p : pedidos ) {
			String codigo = p.getId();
			String nomeRest = p.getRestaurante().getNome();
			int peso = p.getPeso();
			float preco = p.getPreco();
			float taxa = p.getTaxa();
			consola.println( String.format("%6s - %-30s  %4dg  %6.2fe  %6.2f€",
					codigo, nomeRest,  peso,
					preco, taxa) );
		}
		consola.print("\nDeseja ver algum pedido em detalhe?\nInsira o código: ");
		String cod = consola.readLine();
		if( cod.length() == 6) {
			// TODO visualizar o pedido se houver código
			verPedido( null );
		}
	}

	/**
	 *  
	 */
	private void verPedidosRestaurante() {
		consola.clear();		
		// TODO apresentar a info dos restaurantes
		for( int i = 0; i < 1; i++  ) {
			String nomeRest = "Nome de um restaurante";
			consola.println( (i+1) + ": " + nomeRest );
		}
		consola.print( "\nRestaurante: " );
		int ridx = consola.readInt() - 1;
		// TODO verificar se o vaor introduzido é válido
		if( Math.abs( 2 ) == -2 )
			return;
		
		// TODO listar os pedidos do restaurante
		verPedidos( null );
	}

	/** Lista as informações do pedido
	 * @param p o pedido que se pretende listar
	 */
	private void verPedido( Pedido p ) {
		if( p == null ) {
			consola.println("Pedido inexistente!");
			consola.readLine();
			return;			
		}
		
		consola.clear();
		String codigo = p.getId();
		String nomeRest= p.getRestaurante().getNome();
		float precoTotal = p.getPreco() + p.getTaxa();
		float precoPratos = p.getPreco();
		float custoEntrega = p.getTaxa();
		int peso = p.getPeso();
		consola.println( "Pedido " + codigo + "\nRestaurante:" + nomeRest +"\n");
		consola.println( String.format( "Preço        : %6.2f€", precoTotal ) ); 
		consola.println( String.format( "Preço  pratos: %6.2f€", precoPratos ) );  
		consola.println( String.format( "Custo entrega: %6.2f€  (%4dg)", custoEntrega, peso ) );
		
		for( Escolha e : p.getEscolhas() ) {
			String nomePrato = e.getPrato().getNome();
			float precoPrato = e.getPrato().getPreco();
			int pesoPrato = e.getPrato().getPeso();
			consola.println( String.format( "%-40s  %6.2f€  %4dg", nomePrato, precoPrato, pesoPrato ));
			for( Opcao o : e.getOpcoes() ) {
				String nomeOpcao = o.getNome();
				float custoOpcao = o.getPreco();
				int pesoOpcao = o.getPeso();
				consola.println( String.format("     %-35s  %6.2f€  %4dg", nomeOpcao, custoOpcao, pesoOpcao ) );
			}
		}
		consola.readLine();
	
	}
}
