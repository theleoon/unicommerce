package br.com.alura.unicommerce.api;

import java.util.List;

import org.springframework.validation.ObjectError;

public record DadosMensagem(String mensagem, List<ObjectError> erros) {
	
	public DadosMensagem(String mensagem) {
		this(mensagem, null);
	}
	
	public DadosMensagem(List<ObjectError> erros) {
		this(null, erros);
	}

}
