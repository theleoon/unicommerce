package br.com.alura.unicommerce.api.cliente;

import br.com.alura.unicommerce.core.entity.Cliente;

public class ClienteRequestDto {

	private String nome;

	private String cpf;

	private String telefone;

	private EnderecoRequestDto endereco;

	public Cliente toEntity() {
		return new Cliente(nome, cpf, telefone, endereco.toEntity());
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setEndereco(EnderecoRequestDto endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public EnderecoRequestDto getEndereco() {
		return endereco;
	}

	@Override
	public String toString() {
		return "ClienteForm [nome=" + nome + ", cpf=" + cpf + ", telefone=" + telefone + ", endereco=" + endereco + "]";
	}

}
