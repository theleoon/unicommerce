package br.com.alura.unicommerce.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "cliente")
public class Cliente {
	
	@Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	@Column(name = "nome", nullable = false)
    private String nome;
    
	@Column(name = "cpf", nullable = false, columnDefinition = "CHAR(11)", unique = true)
    private String cpf;
    
	@Column(name = "telefone", nullable = false, length = 20)
    private String telefone;
    
	@Embedded
    private Endereco endereco;
    
//	@OneToMany(mappedBy = "cliente")
//    private List<Pedido> pedidos = new ArrayList<>();	

	public Cliente() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


}
