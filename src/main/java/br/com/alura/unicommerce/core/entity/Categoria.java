package br.com.alura.unicommerce.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 60, unique = true)
	private String nome;
	
	private boolean status = true;

	public Categoria() {
	}

	public Categoria(String nome) throws IllegalArgumentException {
		this.setNome(nome);
		this.status = Boolean.TRUE;
	}
	
	public Categoria(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public boolean isStatus() {
		return status;
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
		
		if (nome == null) 
			throw new IllegalArgumentException("Nome da categoria não pode ser nulo");
		
		if(nome.isEmpty())
			throw new IllegalArgumentException("Nome da categoria não pode ser vazio");
		
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Categoria [nome=" + nome + "]";
	}
	
	

}