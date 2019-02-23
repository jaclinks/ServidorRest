package br.com.senior.treinamento.spring.treinamentospring.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.aspectj.lang.annotation.Before;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.senior.treinamento.spring.treinamentospring.TreinamentoSpringApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TreinamentoSpringApplication.class})

public class ValidatorTest {
	@Autowired
		private Validator validator;
	
	@BeforeClass
	public static void  beforeClass() {
		System.out.println("##############################Executa antes da classe");
	}
	
	@AfterClass
		public static void afterClass(){
			System.out.println("######################################Depois da classe");
	}
	
	@org.junit.Before
	public void before() {
		System.out.println("#################################Executa antes do teste");
	}
	
	@After
	public void after() {
		System.out.println("#############################Executa depois do teste");
	}
	
	
	
	
	@Test
		public void validaStringVaziaTest(){
			assertTrue("O valor devia estar vazio" , validator.validaStringVazia(null));
			assertTrue("O valor devia estar vazio" ,validator.validaStringVazia(""));
			assertFalse("O valor não devia estar vazio" ,validator.validaStringVazia(" "));
			assertFalse("O valor não devia estar vazio" ,validator.validaStringVazia("fsfsdf"));
	}
	
	@Test
		public void validaTamanhoMinimoTest() {
			assertTrue("Tamanho minimo" ,validator.validaTamanhoMinimo("aa", 2));
			assertTrue("Tamanho minimo" ,validator.validaTamanhoMinimo(" ", 1));
			assertFalse("Tamanho minimo", validator.validaTamanhoMinimo("aa", 5));
			assertFalse("Tamanho minimo",validator.validaTamanhoMinimo(null,2));
	}
	
	@Test
		public void validaTamanhoMaximoTest() {
			assertTrue(validator.validaTamanhoMaximo("aa", 2));
			assertTrue(validator.validaTamanhoMaximo(" ", 1));
			assertFalse(validator.validaTamanhoMaximo("aaaaaaaa", 5));
			assertFalse(validator.validaTamanhoMaximo(null, 2));
			
		}
			
		
}
