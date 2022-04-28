package sistema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import restaurante.*;

/** Classe que representa todo o sistema
 * Deve ter uma lista de restaurantes suportados e outra dos pedidos efetuados
 * Deve ser a responsável por atribuir o código a um pedido, quando este é adicionado ao sistema 
 */
public class ComEST {
	private List<Restaurante> restaurantes;
	private List<Pedido> pedidos;
	
	public ComEST() {
		setRestaurantes(new ArrayList<Restaurante>());
		setPedidos(new ArrayList<Pedido>());
	}
	 
	public List<Restaurante> getRestaurantes() {
		return Collections.unmodifiableList(restaurantes);
	}

	public List<Pedido> getPedidos() {
		return Collections.unmodifiableList(pedidos);
	}
	 
	public void setRestaurantes(List<Restaurante> restaurantes) {
		this.restaurantes = restaurantes;
	}
	
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	 
	public void addRestaurante(Restaurante r) {
		restaurantes.add(r);
	}
	 
	public void addPedido(Pedido p) {
		pedidos.add(p);
	}
}
