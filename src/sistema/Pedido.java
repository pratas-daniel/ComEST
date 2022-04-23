package sistema;

import java.util.ArrayList;

import restaurante.*;

/** Representa um pedido de comida. 
 * Um pedido deve indicar qual o restaurante selecionado e ter uma lista de escolhas.
 * Quando se adiciona uma escolha ao pedido este deve verificar se o prato é do restaurante 
 * ao qual o pedido está associado.
 */
public class Pedido {
	private String id;
	private Restaurante restaurante;
	private ArrayList<Escolha> escolhas;


	public Pedido(String id, Restaurante restaurante, ArrayList<Escolha> escolhas) {
		this.id = id;
		this.restaurante = restaurante;
		this.escolhas = escolhas;
	}


	/** indica se o pedido não tem escolhas associadas
	 * @return true, se o pedido não tiver qualquer escolha
	 */
	public boolean estaVazio() {
		return false;
	}
}
