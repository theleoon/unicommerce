package br.com.alura.unicommerce.api.infra;

import java.util.List;

import org.springframework.validation.ObjectError;

public record DadosMensagem(String mensagem, List<ObjectError> erros, String exceptionMessage) {
	
	public DadosMensagem(String mensagem) {
		this(mensagem, null);
	}
	
	public DadosMensagem(String mensagem, Exception e) {
		this(mensagem, null, e.getMessage());
	}
	
	public DadosMensagem(List<ObjectError> erros) {
		this(null, erros, null);
	}

}
