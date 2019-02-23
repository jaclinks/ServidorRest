package br.com.senior.treinamento.spring.treinamentospring.repository;

import java.util.List;

import br.com.senior.treinamento.spring.treinamentospring.entity.ClienteEntity;

public interface ClienteRepositoryCustom {

	public List<ClienteEntity> buscarClientesComPedido();
}
