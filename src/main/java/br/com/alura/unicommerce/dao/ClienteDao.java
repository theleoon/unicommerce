package br.com.alura.unicommerce.dao;

import javax.persistence.EntityManager;

import br.com.alura.unicommerce.modelo.Cliente;

public class ClienteDao implements Dao<Cliente>{
	
	private EntityManager em;

	public ClienteDao(EntityManager em) {
		this.em = em;
	}

	@Override
	public void save(Cliente t) {
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
	}

	@Override
	public void delete(Cliente t) {
		em.getTransaction().begin();
		em.remove(t);
		em.getTransaction().commit();
	}

	@Override
	public void update(Cliente t) {
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
	}

	@Override
	public Cliente get(Long id) {
		if (id == null) throw new IllegalArgumentException();
		Cliente encontrado = em.find(Cliente.class, id);
		return encontrado;
	}

}
