package sistema;

import java.util.ArrayList;

import restaurante.*;

/** Representa um prato escolhido pelo cliente e respetivas opções selecionadas
 * Deve ter a indicação de qual o prato escolhido e uma lista com as opções selecionadas.
 * Ao adicionar uma opção dever verificar se a mesma faz parte das opções suportadas pelo prato. 
 */
public class Escolha {
	private Prato prato;
	private ArrayList<Opcao> opcoes;
	
	public Escolha(Prato prato, ArrayList<Opcao> opcoes) {
		this.prato = prato;
		this.opcoes = opcoes;
	}

	public Prato getPrato() {
		return prato;
	}

	public ArrayList<Opcao> getOpcoes () {
		return opcoes;
	}
	
	/** Retorna o peso total da escolha, ou seja,
	 * o peso do prato mais o peso de cada uma das opções selecionadas.
	 * @return o peso total da escolha
	 */
	public int getPeso() {
		int peso = prato.getPeso();
		for (Opcao o : opcoes){
			peso += o.getPeso();
		}
		return peso;
	}
	
	/** Retorna o preço total da escolha, ou seja,
	 * o preço do prato mais o preço de cada uma das opções selecionadas.
	 * @return o preço total da escolha
	 */
	public float getPreco( ) {
		float preco = prato.getPreco();
		for (Opcao o : opcoes){
			preco += o.getPreco();
		}
		return preco;
	}
}
