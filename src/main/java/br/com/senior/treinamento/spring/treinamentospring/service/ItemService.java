package br.com.senior.treinamento.spring.treinamentospring.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senior.treinamento.spring.treinamentospring.dto.ItemDTO;
import br.com.senior.treinamento.spring.treinamentospring.entity.ItemEntity;
import br.com.senior.treinamento.spring.treinamentospring.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private ModelMapper modelMapper;

	public List<ItemDTO> listarItens() {
		return itemRepository.findAll().stream().map(entity -> modelMapper.map(entity, ItemDTO.class))
				.collect(Collectors.toList());
	}

	public ItemDTO cadastrarItem(ItemDTO dto) {
		ItemEntity itemEntity = modelMapper.map(dto, ItemEntity.class);
		ItemEntity itemCriado = itemRepository.save(itemEntity);
		return modelMapper.map(itemCriado, ItemDTO.class);
	}

	public void deletarItem(Long id) {
		Optional<ItemEntity> optionalItem = itemRepository.findById(id);
		if (!optionalItem.isPresent()) {
			throw new EntityNotFoundException("Item " + id + " não encontrado");
		}
		itemRepository.deleteById(id);
	}

	public ItemDTO buscarItemPeloId(Long id) {
		Optional<ItemEntity> optionalItem = itemRepository.findById(id);
		if (optionalItem.isPresent()) {
			return modelMapper.map(optionalItem.get(), ItemDTO.class);
		}
		throw new EntityNotFoundException("Item " + id + " não encontrado");
	}

	public ItemDTO atualizarItem(ItemDTO dto) {
		ItemEntity itemEntity = modelMapper.map(dto, ItemEntity.class);
		ItemEntity itemCriado = itemRepository.save(itemEntity);
		return modelMapper.map(itemCriado, ItemDTO.class);
	}
}
