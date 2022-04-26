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
	private float taxa;
	private Restaurante restaurante;
	private ArrayList<Escolha> escolhas;


	public Pedido(Restaurante restaurante) {
		this.restaurante = restaurante;
		taxa = 0;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public float getTaxa() {
		return taxa;
	}

	public void setTaxa(int peso) {
		if (peso <= 1500)
			taxa = 2.5f;
		else if (peso <= 3000)
			taxa = 4.5f;
		else if (peso <= 4000)
			taxa = 5.0f;
		else {
			int taxaExtra = peso / 1000 - 4;
			taxa = 6.0f + taxaExtra;
		}
			
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}


	public ArrayList<Escolha> getEscolhas() {
		return escolhas;
	}

	public int getPeso() {
		int peso = 0;
		if (escolhas != null) {
			for (Escolha e : escolhas){
				peso += e.getPeso();
			}
		}
		return peso;
	}

	public float getPreco() {
		float preco = 0;
		if (escolhas != null) {
			for (Escolha e : escolhas){
				preco += e.getPreco();
			}
		}
		return preco;
		
	}

	public void addEscolha (Escolha e) {
		if (escolhas == null)
			escolhas = new ArrayList<Escolha>();
		escolhas.add(e);
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
