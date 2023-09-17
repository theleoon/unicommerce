package br.com.alura.unicommerce.api.cliente;

import br.com.alura.unicommerce.core.entity.Cliente;

public class ClienteDto {
	
	private Long id;
	
    private String nome;
    
    private String cpf;
    
    private String telefone;
	
    private EnderecoDto endereco;

	public ClienteDto(Cliente obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.telefone = obj.getTelefone();
		this.endereco = new EnderecoDto(obj.getEndereco());
	}

	public Long getId() {
		return id;
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

	public EnderecoDto getEndereco() {
		return endereco;
	}

}
