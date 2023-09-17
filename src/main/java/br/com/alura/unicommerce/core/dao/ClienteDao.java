package br.com.alura.unicommerce.core.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Component;

import br.com.alura.unicommerce.core.entity.Cliente;
import br.com.alura.unicommerce.core.jpa.JPAUtil;

@Component
public class ClienteDao implements Dao<Cliente>{
	
	private EntityManager em;

	public ClienteDao() {
		this.em = JPAUtil.getEntityManager();
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
	
	public List<Cliente> buscarTodos() {
		String jpql = "SELECT p FROM Cliente p";
		return em.createQuery(jpql, Cliente.class).getResultList();
	}
	
	public List<Cliente> buscarPorNome(String nome) {
		String jpql = "SELECT p FROM Cliente p WHERE P.nome = :nome";
		return em.createQuery(jpql, Cliente.class)
				.setParameter("nome", nome)
				.getResultList();
	}

}
