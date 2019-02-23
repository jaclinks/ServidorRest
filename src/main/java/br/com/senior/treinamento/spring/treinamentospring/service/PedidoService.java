package br.com.senior.treinamento.spring.treinamentospring.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senior.treinamento.spring.treinamentospring.dto.PedidoDTO;
import br.com.senior.treinamento.spring.treinamentospring.entity.PedidoEntity;
import br.com.senior.treinamento.spring.treinamentospring.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private ModelMapper modelMapper;

	public PedidoDTO cadastrarPedido(PedidoDTO dto) {
		PedidoEntity pedidoEntity = modelMapper.map(dto, PedidoEntity.class);
		PedidoEntity pedidoCriado = pedidoRepository.save(pedidoEntity);
		return modelMapper.map(pedidoCriado, PedidoDTO.class);
	}

	public List<PedidoDTO> listarPedidos() {
		return pedidoRepository.findAll().stream().map(entity -> modelMapper.map(entity, PedidoDTO.class))
				.collect(Collectors.toList());
	}

	public void deletarPedido(Long id) {
		Optional<PedidoEntity> optionalPedido = pedidoRepository.findById(id);
		if (!optionalPedido.isPresent()) {
			throw new EntityNotFoundException("Pedido " + id + " não encontrado");
		}
		pedidoRepository.deleteById(id);
	}

	public PedidoDTO buscarPedidoPeloId(Long id) {
		Optional<PedidoEntity> optionalPedido = pedidoRepository.findById(id);
		if (optionalPedido.isPresent()) {
			return modelMapper.map(optionalPedido.get(), PedidoDTO.class);
		}
		throw new EntityNotFoundException("Pedido " + id + " não encontrado");
	}

	public PedidoDTO atualizarPedido(PedidoDTO dto) {
		PedidoEntity pedidoEntity = modelMapper.map(dto, PedidoEntity.class);
		PedidoEntity pedidoCriado = pedidoRepository.save(pedidoEntity);
		return modelMapper.map(pedidoCriado, PedidoDTO.class);
	}
}
