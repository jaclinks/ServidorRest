package br.com.senior.treinamento.spring.treinamentospring.rest;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

public abstract class AbstractController {

	@ExceptionHandler(EntityNotFoundException.class)
	public final ResponseEntity<Error> handleValidationException(EntityNotFoundException ex, WebRequest request) {
		return new ResponseEntity<>(new Error(ex.getMessage()), HttpStatus.NOT_FOUND);
	}
}
