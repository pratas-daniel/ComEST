package sistema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import restaurante.*;

/** Representa um prato escolhido pelo cliente e respetivas opções selecionadas
 * Deve ter a indicação de qual o prato escolhido e uma lista com as opções selecionadas.
 * Ao adicionar uma opção dever verificar se a mesma faz parte das opções suportadas pelo prato. 
 */
public class Escolha {
	private Prato prato;
	private List<Opcao> opcoes;
	
	public Escolha(Prato prato) {
		this.prato = prato;
		opcoes = new ArrayList<Opcao>();
	}

	public Prato getPrato() {
		return prato;
	}

	public List<Opcao> getOpcoes () {
		return Collections.unmodifiableList(opcoes);
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
	
	public void addOpcao(Opcao o) {
		if (prato.temOpcao(o))
			opcoes.add(o);
	}
	
	public void removeOpcao(Opcao o) {
		opcoes.remove(o);
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
