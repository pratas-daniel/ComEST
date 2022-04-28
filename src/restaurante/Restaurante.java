package restaurante;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import sistema.Pedido;

/** Representa um restaurante
 * Cada restaurante deve ter um nome e uma descrição. A descrição deve ser uma apresentação
 * do restaurante indicando o seu tipo e filosofia.
 * Deve ainda ter uma lista com os pratos que disponibiliza. 
 * O restaurante deve ainda ter uma lista dos pedidos que os clientes já colocaram.
 */
public class Restaurante {
	private String nome;
	private String descricao;
	private List<Prato> pratos;
	private List<Pedido> pedidos;
	
	public Restaurante(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
		pedidos = new ArrayList<Pedido>();
		pratos = new ArrayList<Prato>();
	}

	/** indica se um dado prato pertence a este restaurante
	 * @param p o prato a verificar
	 * @return true, se o prato faz parte da lista do restaurante
	 */
	public boolean temPrato( Prato p ) {
		if (pratos.contains(p))
			return true;
		else
			return false;
	}
	
	public void addPrato(Prato p) {
		pratos.add(p);
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public List<Prato> getPratos() {
		return Collections.unmodifiableList(pratos);
	}

	public List<Pedido> getPedidos() {
		return Collections.unmodifiableList(pedidos);
	}

	public void addPedido(Pedido p) {
		pedidos.add(p);
	}
	
}
