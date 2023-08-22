package br.com.alura.unicommerce.modelo;

import javax.persistence.*;

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

	public Categoria(String nome) {
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
		this.nome = nome;
	}

}
