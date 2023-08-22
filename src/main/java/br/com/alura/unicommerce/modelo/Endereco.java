package br.com.alura.unicommerce.modelo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Endereco {

	@Column(name = "rua", nullable = false, length = 50)
	private String rua;

	@Column(name = "numero", nullable = false)
	private Integer numero;

	@Column(name = "complemento", length = 50)
	private String complemento;

	@Column(name = "bairro", nullable = false, length = 30)
	private String bairro;

	@Column(name = "cidade", nullable = false, length = 30)
	private String cidade;

	@Column(name = "estado", nullable = false, length = 2)
	private String estadoUF;

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstadoUF() {
		return estadoUF;
	}

	public void setEstadoUF(String estadoUF) {
		this.estadoUF = estadoUF;
	}

}
