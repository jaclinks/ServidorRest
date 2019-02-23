package br.com.senior.treinamento.spring.treinamentospring.service;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senior.treinamento.spring.treinamentospring.dto.ClienteDTO;
import br.com.senior.treinamento.spring.treinamentospring.entity.ClienteEntity;
import br.com.senior.treinamento.spring.treinamentospring.repository.ClienteRepository;
import br.com.senior.treinamento.spring.treinamentospring.util.Validator;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private Validator validator;
	
	@Autowired
	private ModelMapper modelMapper;

	public ClienteDTO cadastrarCliente(ClienteDTO dto) throws Exception {
		
		
		ClienteEntity clienteEntity = modelMapper.map(dto, ClienteEntity.class);
		ClienteEntity clienteCriado = clienteRepository.save(clienteEntity);
		return modelMapper.map(clienteCriado, ClienteDTO.class);
	}

	public ClienteDTO atualizarCliente(ClienteDTO dto) {
		ClienteEntity clienteEntity = modelMapper.map(dto, ClienteEntity.class);
		ClienteEntity clienteCriado = clienteRepository.save(clienteEntity);
		return modelMapper.map(clienteCriado, ClienteDTO.class);
	}

	public List<ClienteDTO> listarClientes() {
		return clienteRepository.findAll().stream().map(entity -> modelMapper.map(entity, ClienteDTO.class))
				.collect(Collectors.toList());
	}

	public void deletarCliente(Long clienteId) {
		Optional<ClienteEntity> optionalCliente = clienteRepository.findById(clienteId);
		if (!optionalCliente.isPresent()) {
			throw new EntityNotFoundException("Cliente " + clienteId + " não encontrado");
		}
		clienteRepository.deleteById(clienteId);
	}

	public List<ClienteDTO> buscarClientesPeloNome(String nome) {
		return clienteRepository.findByNomeIgnoreCase(nome).stream()
				.map(entity -> modelMapper.map(entity, ClienteDTO.class)).collect(Collectors.toList());
	}

	public ClienteDTO criarCliente(ClienteDTO dto) throws Exception {
		if (validator.validaStringVazia(dto.getNome())) {
			throw new Exception("Nome esta vazio");
		}
		ClienteEntity clienteEntity = modelMapper.map(dto, ClienteEntity.class);
		ClienteEntity clienteCriado = clienteRepository.save(clienteEntity);
		return modelMapper.map(clienteCriado, ClienteDTO.class);
	}

	public ClienteDTO buscarClientePeloId(Long clienteId) {
		Optional<ClienteEntity> optionalCliente = clienteRepository.findById(clienteId);
		if (optionalCliente.isPresent()) {
			return modelMapper.map(optionalCliente.get(), ClienteDTO.class);
		}
		throw new EntityNotFoundException("Cliente " + clienteId + " não encontrado");
	}
}
