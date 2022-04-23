package restaurante;

import java.util.ArrayList;


/** Classe que representa um prato do sistema.
 * O prato deve ter um nome que o identifica. Deve ter ainda uma descrição, que é uma
 * explicação do que o prato contém ou o que é.
 * Cada prato deve ter um preço (sempre positivo) e um peso (sempre positivo).
 * Um prato pode ainda ter uma lista de opções.
 */
public class Prato {
	private String nome;
	private String descricao;
	private float preco;
	private int peso;
	private ArrayList<Opcao> opcoes = new ArrayList<Opcao>();
	
	public Prato(String nome, String descricao, float preco, int peso) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.peso = peso;
		opcoes.clear();
	}

	/** Indica se a opção indicada é válida para este prato
	 * @param o a opção a verificar
	 * @return true, se a opção é válida para o prato.
	 */
	public boolean temOpcao( Opcao o ) {
		return true;
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

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = Math.abs(preco);
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = Math.abs(peso);
	}
	public void addOpcao (Opcao o) {
		opcoes.add(o);
	}
	public ArrayList<Opcao> getOpcoes() {
		return opcoes;
	}
}
