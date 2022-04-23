package menus;

import java.util.HashMap;

import sistema.ComEST;

public class AppMain {

	/**
	 * despoleta a aplicação
	 */
	public static void main( String []args ){
		ComEST come = new ComEST();
		
		 HashMap<String, String> restaurantes = new HashMap<String, String>();
		 HashMap<String, String> pratos = new HashMap<String, String>();
		 HashMap<String, String> opcoes = new HashMap<String, String>();
	
		 	restaurantes.put("1", "CantinaEST");
	 		restaurantes.put("2", "SoSushi");
	 		restaurantes.put("3", "Churrasqueira da EST");
	 		
	 		
	 	/**
	 	 * Criar aqui os restaurantes/pratos/opções
		 * Criar aqui os restaurantes/pratos/opções
		 */
		// Restaurante CantinaEST
		// Comida caseira, elaborada com um toque de requinte.
		// Pratos:
		//    Rissois     descrição: 3 Rissois de bacalhau acompanhados de arroz   preço base: 2.6€  peso base: 300g
		//       opção 1: Acompanhado com arroz de tomate  custo: 0.3€  peso: 20g
		//       opção 2: 1 Rissol extra  0.2€  30g
		//       opção 3: 2 Rissois extra  0.4€  60g
		//    Peixe à Brás  desc:Peixe à Brás    2.6€   400g 
		//       opção 1: 5 Azeitonas   0.2€  30g
		//       opção 2: 8 Azeitonas   0.3€  50g
		//       opção 3: Queijo gratinado  0.4€  100g
		//    Frango assado   desc: Perna de frango assado com arroz     2.6€    450g 
		//       opção 1: Pickles   0.2€   40g
		//       opção 2: Picante   0.0€   5g
		
		// Restaurante SoSushi
		// Comida japonesa de qualidade.
		// Pratos:
		//     Sushi + Sashimi mix   desc: Seleção de sushi e sashimi, caixa média com 18 peças   8.5€   600g 
		//       opção 1: Caixa grande, com 42 peças  9.5€ 600g
		//       opção 2: Wasabi   0.3€    5g
		//       opção 3: Soja     0.3€    5g
		//     Sushi + Nigiri mix    desc: Seleção de sushi e nigiri, caixa média com 18 peças    10.5€  700g 
		//       opção 1: Caixa grande, com 42 peças   14.5€   750g
		//       opção 2: Wasabi   0.3€    5g
		//       opção 3: Soja     0.3€    5g
		//     Huramaki + Hosomaki mix   desc: Seleção de huramaki e hosomaki, caixa média com 24 peças  8.5£   500g 
		//       opção 1: Caixa grande, com 50 peças   11.2€   600g
		//       opção 2: Wasabi   0.3€    5g
		//       opção 3: Soja     0.3€    5g

		// Restaurante Churrasqueira da EST
		// Churrascos na brasa (de carvão) como nunca comeu
		// Pratos:
		//     Frango Assado     desc: Frango assado inteiro (1 unidade)     8.5€   800g
		//       opção 1: Só 1/2 Frango    -2.5€   -350g
		//       opção 2: Molho especial      0€     10g
		//       opção 3: Molho picante       0€     10g
		//       opção 4: Arroz             1.3€    200g
		//       opção 5: Batata frita		1.3€    200g
		//     Picanha           desc: Picanha do Brasil (dose de 600g)     13.5€   600g
		//       opção 1: Dose de 1kg       3.5€    400g
		//       opção 2: Arroz             1.3€    200g
		//       opção 3: Feijão preto      2.2€    300g
		//     Secretos    desc: Secretos de porto preto (dose de 500g)     10.5€   500g
		//       opção 1: Arroz             1.3€    200g
		//       opção 2: Feijão preto      2.2€    300g
		
		// criar o menu principal do servidor
		Thread t1 = new Thread() {
			public void run() {
				MenuServidor app = new MenuServidor( come );
				app.menuPrincipal();
			};
		};
		t1.start();

		// criar o menu da aplicação móvel
		Thread t2 = new Thread() {
			public void run() {
				MenuPedidos appMovel = new MenuPedidos( come );
				appMovel.menuPrincipal();
			};
		};
		t2.start();
	}
}
