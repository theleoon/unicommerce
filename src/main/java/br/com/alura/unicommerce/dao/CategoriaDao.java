package br.com.alura.unicommerce.dao;

import javax.persistence.EntityManager;

import br.com.alura.unicommerce.modelo.Categoria;

public class CategoriaDao {

	private EntityManager em;

	public CategoriaDao(EntityManager em) {
		this.em = em;
	}

	public Categoria buscaPorId(Long id) {
		return em.find(Categoria.class, id);
	}

	public void cadastra(Categoria obj) {
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
	}

}
