package br.com.senior.treinamento.spring.treinamentospring.dto;

import java.time.LocalDateTime;
import java.util.List;

public class PedidoDTO {

	private Long id;
	private ClienteDTO cliente;
	private List<ItemDTO> itens;
	private LocalDateTime dataPedido;

	public PedidoDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	public List<ItemDTO> getItens() {
		return itens;
	}

	public void setItens(List<ItemDTO> itens) {
		this.itens = itens;
	}

	public LocalDateTime getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDateTime dataPedido) {
		this.dataPedido = dataPedido;
	}
}
