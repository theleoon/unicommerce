package br.com.alura.unicommerce.api.cliente;

import br.com.alura.unicommerce.core.entity.Endereco;

public class EnderecoDto {
	
	private String rua;
	
	private String longradouro;

	private Integer numero;

	private String complemento;

	private String bairro;

	private String cidade;

	private String estado;
	
	public EnderecoDto(Endereco obj) {
		this.rua = obj.getRua();
		this.longradouro = obj.getRua();
		this.numero = obj.getNumero();
		this.complemento = obj.getComplemento();
		this.bairro = obj.getBairro();
		this.cidade = obj.getCidade();
		this.estado = obj.getEstadoUF();
	}

	public String getLongradouro() {
		return longradouro;
	}

	public String getRua() {
		return rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}

}
