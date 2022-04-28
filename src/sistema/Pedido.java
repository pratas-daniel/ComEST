package sistema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
	private List<Escolha> escolhas;

	public Pedido(Restaurante restaurante) {
		this.restaurante = restaurante;
		taxa = 0;
		escolhas = new ArrayList<Escolha>();
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


	public List<Escolha> getEscolhas() {
		return Collections.unmodifiableList(escolhas);
	}

	public int getPeso() {
		int peso = 0;
		for (Escolha e : escolhas){
				peso += e.getPeso();
		}
		return peso;
	}

	// 
	public float getPreco() {
		float preco = 0;
		for (Escolha e : escolhas){
			preco += e.getPreco();
		}
		return preco;
		
	}

	// adicionar escolha à lista
	public void addEscolha (Escolha e) {
		if (restaurante.temPrato(e.getPrato()))
			escolhas.add(e);
	}


	/** indica se o pedido não tem escolhas associadas
	 * @return true, se o pedido não tiver qualquer escolha
	 */
	public boolean estaVazio() {
		return escolhas.isEmpty();
	}
}
