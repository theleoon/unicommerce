package br.com.alura.unicommerce.core.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Component;

import br.com.alura.unicommerce.core.entity.Categoria;
import br.com.alura.unicommerce.core.jpa.JPAUtil;

@Component
public class CategoriaDao implements Dao<Categoria>{

	private EntityManager em;

	public CategoriaDao() {
		this.em = JPAUtil.getEntityManager();
	}

	@Override
	public void save(Categoria t) {
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
	}

	@Override
	public void delete(Categoria t) {
		em.getTransaction().begin();
		em.remove(t);
		em.getTransaction().commit();
	}

	@Override
	public void update(Categoria t) {
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
	}

	@Override
	public Categoria get(Long id) {
		if (id == null) throw new IllegalArgumentException();
		Categoria encontrado = em.find(Categoria.class, id);
		return encontrado;
	}
	
	public List<Categoria> buscarPorNome(String nome) {
		String jpql = "SELECT c FROM Categoria c WHERE c.nome = :nome";
		return em.createQuery(jpql, Categoria.class)
				.setParameter("nome", nome)
				.getResultList();
	}
	
	public List<Categoria> listaTodos(){
        String jpql = "SELECT p FROM " + Categoria.class.getName() + " p";
        return em.createQuery(jpql, Categoria.class).getResultList();
    }

}
