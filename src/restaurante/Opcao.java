package restaurante;

/** Classe que representa uma opção de um prato.
 * Uma opção deve ter um nome, que indica o que ela é.
 * Deve ainda ter um custo (que pode ser negativo) e um peso (que pode ser negativo). 
 */
public class Opcao {
	private String nome;
	private float preco;
	private int peso;

	public Opcao(String nome, float preco, int peso) {
		setNome(nome);
		setPreco(preco);
		setPeso(peso);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}
	
}
