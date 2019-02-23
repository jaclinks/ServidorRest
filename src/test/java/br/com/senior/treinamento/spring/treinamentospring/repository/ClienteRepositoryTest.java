package br.com.senior.treinamento.spring.treinamentospring.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.senior.treinamento.spring.treinamentospring.TreinamentoSpringApplication;
import br.com.senior.treinamento.spring.treinamentospring.entity.ClienteEntity;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TreinamentoSpringApplication.class})
public class ClienteRepositoryTest {

	@Autowired
		private ClienteRepository clienteRepository;
	
	@Before
		public void before() {
			ClienteEntity clienteEntity = new ClienteEntity();
			clienteEntity.setNome("Joao vitor");
			clienteRepository.save(clienteEntity);
			System.out.println("####################### criando nome");
	}
	
	@After
		public void after() {
			clienteRepository.deleteAll();
			System.out.println("########################## deletando");
	}
	
	@Test
		public void findByNomeIgnoreCaseTest() {
			List<ClienteEntity> list = clienteRepository.findByNomeIgnoreCase("Joao vitor");
			assertEquals("Deveria existir um cliente", 1 , list.size());
			ClienteEntity cliente = list.get(0);
			assertEquals("Nome incorreto", "Joao" , cliente.getNome());
	}
	
	@Test
		public void findByNomeIgnoreCaseNotExistTest() {
			List<ClienteEntity> list = clienteRepository.findByNomeIgnoreCase("Nome não existe");
			assertEquals("Não deveria existir nome na lista", 0 , list.size());
	}
	
	@Test
		public void findByNomeUpperCaseTest() {
			List<ClienteEntity> list = clienteRepository.findByNomeIgnoreCase("JOAO vitor");
			assertEquals("Deveria existir uma pessoa na lista", 1 , list.size());
			ClienteEntity cliente = list.get(0);
			assertEquals("Nome incorreto", "Joao vitor", cliente.getNome());
	}
	
	
}
