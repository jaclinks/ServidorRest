package br.com.senior.treinamento.spring.treinamentospring.util;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

@Component
public class Validator {

	public boolean validaStringVazia(String valor) {
		return Strings.isEmpty(valor);
	}
	
	public boolean validaTamanhoMinimo(String valor , int tamanhoMinimo) {
		if (!Strings.isEmpty(valor)) {
			if (valor.length() >= tamanhoMinimo) {
				return true;
			}
		}
		return false;
	}
	
	public boolean validaTamanhoMaximo(String valor , int tamanhoMaximo) {
		if (!Strings.isEmpty(valor)) {
			if (valor.length() <= tamanhoMaximo) {
				return true;
			}
			
		}
		
		return false;
	}
}
