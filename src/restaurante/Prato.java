package restaurante;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


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
	private List<Opcao> opcoes;
	
	public Prato(String nome, String descricao, float preco, int peso) {
		this.nome = nome;
		this.descricao = descricao;
		setPreco(preco);
		setPeso(peso);
		opcoes = new ArrayList<Opcao>();
	}

	/** Indica se a opção indicada é válida para este prato
	 * @param o a opção a verificar
	 * @return true, se a opção é válida para o prato.
	 */
	public boolean temOpcao( Opcao o ) {
		if (opcoes.contains(o))
			return true;
		else
			return false;
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
		// Se for menor que 0 fica a 0
		if (preco < 0)
			this.preco = 0;
		// senão fica com o valor do parametro
		else
			this.preco = preco;
	}

	public int getPeso() {
		return peso;
	}
	
	public void setOpcoes(ArrayList<Opcao> opcoes) {
		this.opcoes = opcoes;
	}

	public void setPeso(int peso) {
		// Se for menor que 0 fica a 0
		if (peso < 0)
			this.peso = 0;
		else
		// Senão fica com o valor do parametro
			this.peso = peso;
	}
	
	public void addOpcao (Opcao o) {
		opcoes.add(o);
	}
	
	public List<Opcao> getOpcoes() {
		return Collections.unmodifiableList(opcoes);
	}
}
