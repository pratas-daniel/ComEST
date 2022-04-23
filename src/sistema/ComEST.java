package sistema;

import java.util.ArrayList;

import restaurante.*;

/** Classe que representa todo o sistema
 * Deve ter uma lista de restaurantes suportados e outra dos pedidos efetuados
 * Deve ser a responsável por atribuir o código a um pedido, quando este é adicionado ao sistema 
 */
public class ComEST {
	 private ArrayList<Restaurante> restaurantes;
	 private ArrayList<Pedido> pedidos;
	 private Escolha escolha;
	 
	 public void addRestaurante(Restaurante r) {
		 restaurantes.add(r);
	 }
	 
	 public void addPedido(Pedido p) {
		 pedidos.add(p);
	 }
}
