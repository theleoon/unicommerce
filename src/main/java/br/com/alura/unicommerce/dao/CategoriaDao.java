package br.com.alura.unicommerce.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.unicommerce.modelo.Categoria;

public class CategoriaDao {

	private EntityManager em;

	public CategoriaDao(EntityManager em) {
		this.em = em;
	}

	public Categoria buscaPorId(Long id) {
		return null;
	}

	public void cadastra(Categoria obj) {
		em.persist(obj);
	}

	public List<Categoria> listaTodos() {
		return null;
	}

}
