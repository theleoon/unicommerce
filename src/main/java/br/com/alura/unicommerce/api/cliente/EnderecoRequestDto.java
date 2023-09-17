package br.com.alura.unicommerce.api.cliente;

import br.com.alura.unicommerce.core.entity.Endereco;

public class EnderecoRequestDto {
	
	private String rua;

	private Integer numero;

	private String complemento;

	private String bairro;

	private String cidade;

	private String estado;
	
	public EnderecoRequestDto(String rua, Integer numero, String complemento, String bairro, String cidade, String estado) {
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
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

	public Endereco toEntity() {
		return new Endereco(rua, numero, complemento, bairro, cidade, estado);
	}

	@Override
	public String toString() {
		return "EnderecoForm [rua=" + rua + ", numero=" + numero + ", complemento=" + complemento + ", bairro=" + bairro
				+ ", cidade=" + cidade + ", estado=" + estado + "]";
	}
	
}
