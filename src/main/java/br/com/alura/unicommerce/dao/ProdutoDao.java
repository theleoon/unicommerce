package br.com.alura.unicommerce.dao;

import javax.persistence.EntityManager;

import br.com.alura.unicommerce.modelo.Produto;

public class ProdutoDao implements Dao<Produto>{
	
	private EntityManager em;

	public ProdutoDao(EntityManager em) {
		this.em = em;
	}

	@Override
	public void save(Produto t) {
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
	}

	@Override
	public void delete(Produto t) {
		em.getTransaction().begin();
		em.remove(t);
		em.getTransaction().commit();
	}

	@Override
	public void update(Produto t) {
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
	}

	@Override
	public Produto get(Long id) {
		if (id == null) throw new IllegalArgumentException();
		Produto encontrado = em.find(Produto.class, id);
		return encontrado;
	}

}
