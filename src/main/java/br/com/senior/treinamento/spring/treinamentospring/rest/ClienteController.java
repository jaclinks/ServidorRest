package br.com.senior.treinamento.spring.treinamentospring.rest;

import java.util.List;

import javax.websocket.server.PathParam;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.senior.treinamento.spring.treinamentospring.dto.ClienteDTO;
import br.com.senior.treinamento.spring.treinamentospring.service.ClienteService;

@CrossOrigin
@RestController
@RequestMapping(value = "/api" )
public class ClienteController extends AbstractController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping("/clientes")
	public ResponseEntity<List<ClienteDTO>> listarClientes() {
		List<ClienteDTO> list = clienteService.listarClientes();
		return new ResponseEntity<List<ClienteDTO>>(list, HttpStatus.OK);
	}

	@GetMapping("/cliente/buscar")
	public ResponseEntity<List<ClienteDTO>> buscarClientesPeloNome(@PathParam(value = "nome") String nome) {
		List<ClienteDTO> list = clienteService.buscarClientesPeloNome(nome);
		return new ResponseEntity<List<ClienteDTO>>(list, HttpStatus.OK);
	}

	@PostMapping("/cliente")
	public ResponseEntity<ClienteDTO> cadastrarCliente(@RequestBody ClienteDTO dto) throws Exception {
		ClienteDTO clienteCadastrado = clienteService.criarCliente(dto);
		return new ResponseEntity<ClienteDTO>(clienteCadastrado, HttpStatus.OK);
	}

	@DeleteMapping("/cliente/{id}")
	public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
		clienteService.deletarCliente(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@GetMapping("/cliente/{id}")
	public ResponseEntity<ClienteDTO> buscarClientePeloId(@PathVariable Long id) {
		ClienteDTO cliente = clienteService.buscarClientePeloId(id);
		return new ResponseEntity<ClienteDTO>(cliente, HttpStatus.OK);
	}

	@PutMapping("/cliente")
	public ResponseEntity<ClienteDTO> atualizarCliente(@RequestBody ClienteDTO dto) {
		ClienteDTO clienteAtualizado = clienteService.atualizarCliente(dto);
		return new ResponseEntity<ClienteDTO>(clienteAtualizado, HttpStatus.OK);
	}
}
