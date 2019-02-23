package br.com.senior.treinamento.spring.treinamentospring.rest;

import static org.hamcrest.Matchers.hasItem;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import br.com.senior.treinamento.spring.treinamentospring.dto.ClienteDTO;
import br.com.senior.treinamento.spring.treinamentospring.service.ClienteService;
import br.com.senior.treinamento.spring.treinamentospring.util.TestUtil;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ClienteController.class, secure = false)
public class ClienteControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private ClienteService clienteService;

	@Test
	public void listarClientesTest() throws Exception {
		List<ClienteDTO> clientes = new ArrayList<>();
		ClienteDTO cliente = new ClienteDTO();
		cliente.setId(1L);
		cliente.setNome("Silvano");
		clientes.add(cliente);
		when(clienteService.listarClientes()).thenReturn(clientes);

		mvc.perform(get("/api/clientes")).andExpect(status().isOk()).andDo(MockMvcResultHandlers.print())
				.andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.[*].id").value(hasItem(1)))
				.andExpect(jsonPath("$.[*].nome").value(hasItem("Silvano")));
	}

	@Test
	public void buscarClientePeloIdTest() throws Exception {
		ClienteDTO cliente = new ClienteDTO();
		cliente.setId(1L);
		cliente.setNome("Silvano");
		when(clienteService.buscarClientePeloId(1L)).thenReturn(cliente);

		mvc.perform(get("/api/cliente/{id}", 1L)).andExpect(status().isOk()).andDo(MockMvcResultHandlers.print())
				.andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8)).andExpect(jsonPath("$.id").value(1L))
				.andExpect(jsonPath("$.nome").value("Silvano"));
	}
}
