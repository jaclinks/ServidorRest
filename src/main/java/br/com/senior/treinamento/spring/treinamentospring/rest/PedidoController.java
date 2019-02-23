package br.com.senior.treinamento.spring.treinamentospring.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senior.treinamento.spring.treinamentospring.dto.PedidoDTO;
import br.com.senior.treinamento.spring.treinamentospring.service.PedidoService;

@RestController
@RequestMapping(value = "/api")
public class PedidoController extends AbstractController {

	@Autowired
	private PedidoService pedidoService;

	@GetMapping("/pedidos")
	public ResponseEntity<List<PedidoDTO>> listarItens() {
		List<PedidoDTO> list = pedidoService.listarPedidos();
		return new ResponseEntity<List<PedidoDTO>>(list, HttpStatus.OK);
	}

	@PostMapping("/pedido")
	public ResponseEntity<PedidoDTO> cadastrarPedido(@RequestBody PedidoDTO dto) {
		PedidoDTO pedidoCadastrado = pedidoService.cadastrarPedido(dto);
		return new ResponseEntity<PedidoDTO>(pedidoCadastrado, HttpStatus.OK);
	}

	@DeleteMapping("/pedido/{id}")
	public ResponseEntity<Void> deletarPedido(@PathVariable Long id) {
		pedidoService.deletarPedido(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@GetMapping("/pedido/{id}")
	public ResponseEntity<PedidoDTO> buscarPedidoPeloId(@PathVariable Long id) {
		PedidoDTO pedido = pedidoService.buscarPedidoPeloId(id);
		return new ResponseEntity<PedidoDTO>(pedido, HttpStatus.OK);
	}

	@PutMapping("/pedido")
	public ResponseEntity<PedidoDTO> atualizarItem(@RequestBody PedidoDTO dto) {
		PedidoDTO pedidoAtualizado = pedidoService.atualizarPedido(dto);
		return new ResponseEntity<PedidoDTO>(pedidoAtualizado, HttpStatus.OK);
	}
}
