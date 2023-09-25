package br.com.alura.unicommerce.api.infra.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class FieldValidationHandler {
	
	@ExceptionHandler(value = { MethodArgumentNotValidException.class })
	public ResponseEntity<?> erro400(MethodArgumentNotValidException ex){
		
		var erros = ex.getFieldErrors();
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erros.stream().map(DadosErroValidacao::new).toList());
	}
	
	private record DadosErroValidacao(String campo, String mensagem) {
		public DadosErroValidacao (FieldError erro) {
			this(erro.getField(), erro.getDefaultMessage());
		}
	}
	
}
