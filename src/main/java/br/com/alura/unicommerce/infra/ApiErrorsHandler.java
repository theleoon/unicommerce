package br.com.alura.unicommerce.infra;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.alura.unicommerce.api.categoria.exception.CategoriaException;
import br.com.alura.unicommerce.api.produto.exception.ProdutoException;

@RestControllerAdvice
public class ApiErrorsHandler {
	
	@ExceptionHandler(value = { CategoriaException.class, ProdutoException.class })
	public ResponseEntity<?> erro404(){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	@ExceptionHandler(value = { MethodArgumentNotValidException.class })
	public ResponseEntity<?> erro400(MethodArgumentNotValidException ex){
		
		var erros = ex.getFieldErrors();
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erros.stream().map(DadosErroValidacao::new).toList());
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> erro500(){
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}
	
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<?> erro204(){
//		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
//	}
	
	private record DadosErroValidacao(String campo, String mensagem) {
		public DadosErroValidacao (FieldError erro) {
			this(erro.getField(), erro.getDefaultMessage());
		}
	}
	
}
