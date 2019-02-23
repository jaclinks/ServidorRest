package br.com.senior.treinamento.spring.treinamentospring.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.querydsl.jpa.impl.JPAQuery;

import br.com.senior.treinamento.spring.treinamentospring.entity.ClienteEntity;
import br.com.senior.treinamento.spring.treinamentospring.entity.QClienteEntity;
import br.com.senior.treinamento.spring.treinamentospring.entity.QPedidoEntity;

public class ClienteRepositoryCustomImpl implements ClienteRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	private QClienteEntity cliente = QClienteEntity.clienteEntity;
	private QPedidoEntity pedido = QPedidoEntity.pedidoEntity;

	@Override
	public List<ClienteEntity> buscarClientesComPedido() {
		JPAQuery<ClienteEntity> query = new JPAQuery<ClienteEntity>(entityManager);
		return query.select(cliente).from(cliente).innerJoin(pedido).on(pedido.cliente.id.eq(cliente.id)).fetch();
	}
}
