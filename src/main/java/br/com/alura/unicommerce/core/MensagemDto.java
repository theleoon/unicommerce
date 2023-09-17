package br.com.alura.unicommerce.core;

import java.util.List;

import org.springframework.validation.ObjectError;

public class MensagemDto {
	
	private String mensagem;
	private List<ObjectError> erros;
	
	public MensagemDto(String mensagem) {
		this.mensagem = mensagem;
	}

	public MensagemDto(List<ObjectError> allErrors) {
		this.erros = allErrors;
	}

	public List<ObjectError> getErros() {
		return erros;
	}

	public String getMensagem() {
		return mensagem;
	}
}
