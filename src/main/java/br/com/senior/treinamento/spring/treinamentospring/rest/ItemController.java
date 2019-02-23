package br.com.senior.treinamento.spring.treinamentospring.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senior.treinamento.spring.treinamentospring.dto.ItemDTO;
import br.com.senior.treinamento.spring.treinamentospring.service.ItemService;
@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class ItemController extends AbstractController {

	@Autowired
	private ItemService itemService;

	@GetMapping("/itens")
	public ResponseEntity<List<ItemDTO>> listarItens() {
		List<ItemDTO> list = itemService.listarItens();
		return new ResponseEntity<List<ItemDTO>>(list, HttpStatus.OK);
	}

	@PostMapping("/item")
	public ResponseEntity<ItemDTO> cadastrarItem(@RequestBody ItemDTO dto) {
		ItemDTO itemCadastrado = itemService.cadastrarItem(dto);
		return new ResponseEntity<ItemDTO>(itemCadastrado, HttpStatus.OK);
	}

	@DeleteMapping("/item/{id}")
	public ResponseEntity<Void> deletarItem(@PathVariable Long id) {
		itemService.deletarItem(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@GetMapping("/item/{id}")
	public ResponseEntity<ItemDTO> buscarItemPeloId(@PathVariable Long id) {
		ItemDTO cliente = itemService.buscarItemPeloId(id);
		return new ResponseEntity<ItemDTO>(cliente, HttpStatus.OK);
	}

	@PutMapping("/item")
	public ResponseEntity<ItemDTO> atualizarItem(@RequestBody ItemDTO dto) {
		ItemDTO clienteAtualizado = itemService.atualizarItem(dto);
		return new ResponseEntity<ItemDTO>(clienteAtualizado, HttpStatus.OK);
	}
}
