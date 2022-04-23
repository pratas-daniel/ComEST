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
	private int pesoTotal;
	private float precoTotal;


	public Pedido(String id, Restaurante restaurante) {
		this.id = id;
		this.restaurante = restaurante;
		this.escolhas = new ArrayList<Escolha>();
		pesoTotal = 0;
		precoTotal = 0;
	}

	public String getId() {
		return id;
	}


	public Restaurante getRestaurante() {
		return restaurante;
	}


	public ArrayList<Escolha> getEscolhas() {
		return escolhas;
	}

	public int getPesoTotal() {
		return pesoTotal;
	}

	public float getPrecoTotal() {
		return precoTotal;
	}

	public void addEscolha (Escolha e) {
		escolhas.add(e);
		pesoTotal += e.getPeso();
		precoTotal += e.getPreco();
	}


	/** indica se o pedido não tem escolhas associadas
	 * @return true, se o pedido não tiver qualquer escolha
	 */
	public boolean estaVazio() {
		if (escolhas.isEmpty())
			return true;
		else
			return false;
	}
}
