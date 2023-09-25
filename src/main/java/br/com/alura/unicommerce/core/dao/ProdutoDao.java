package br.com.alura.unicommerce.core.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Component;

import br.com.alura.unicommerce.core.entity.ItemDePedido;
import br.com.alura.unicommerce.core.entity.Produto;
import br.com.alura.unicommerce.core.util.JPAUtil;

@Component
public class ProdutoDao implements Dao<Produto>{
	
	private EntityManager em;

	public ProdutoDao() {
		this.em = JPAUtil.getEntityManager();
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
		return em.find(Produto.class, id);
	}

    public List<Produto> listaTodos(){
        String jpql = "SELECT p FROM " + Produto.class.getName() + " p";
        return em.createQuery(jpql, Produto.class).getResultList();
    }

    public List<Produto> listaIndisponiveis(){
        String query = "SELECT p FROM "+ Produto.class.getName() + " p WHERE p.quantidadeEmEstoque = 0" ;
        return em.createQuery(query, Produto.class).getResultList();
    }

    public List<Produto> produtosMaisVendidos(){
        String query = "SELECT p FROM " + Produto.class.getName() + " p " +
                "JOIN " + ItemDePedido.class.getName() + " ip on ip.produto = p " +
                "GROUP BY p.id HAVING SUM(ip.quantidade) > 3";
        return em.createQuery(query, Produto.class).getResultList();
    }
}
