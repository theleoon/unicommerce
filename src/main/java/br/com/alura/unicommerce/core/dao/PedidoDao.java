package br.com.alura.unicommerce.core.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.alura.unicommerce.core.entity.Pedido;
import br.com.alura.unicommerce.core.util.JPAUtil;
import br.com.alura.unicommerce.core.vo.RelatorioDeVendasCategoriaVo;
import br.com.alura.unicommerce.core.vo.RelatorioDeVendasPorClienteVo;
import br.com.alura.unicommerce.core.vo.RelatorioDeVendasVo;
import br.com.alura.unicommerce.core.vo.RelatorioProdutoVendidosMaisTresVezesVo;
import jakarta.persistence.EntityManager;

@Component
public class PedidoDao implements Dao<Pedido>{
	
	private EntityManager em;

	public PedidoDao() {
		this.em = JPAUtil.getEntityManager();
	}

	@Override
	public void save(Pedido t) {
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
	}

	@Override
	public void delete(Pedido t) {
		em.getTransaction().begin();
		em.remove(t);
		em.getTransaction().commit();
	}

	@Override
	public void update(Pedido t) {
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
	}

	@Override
	public Pedido get(Long id) {
		if (id == null) throw new IllegalArgumentException();
		Pedido encontrado = em.find(Pedido.class, id);
		return encontrado;
	}
	
	public List<Pedido> listaTodos(){
        String jpql = "SELECT p FROM " + Pedido.class.getName() + " p";
        return em.createQuery(jpql, Pedido.class).getResultList();
    }
	
	 public BigDecimal valorTotalVendido() {
		 String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p";
	        return em.createQuery(jpql, BigDecimal.class)
	                .getSingleResult();
	 }
	 
	 public List<RelatorioDeVendasVo> relatorioDeVendas() {
		 String jpql = "SELECT new br.com.alura.unicommerce.vo.RelatorioDeVendasVo("
		 		+ "produto.nome, "
		 		+ "SUM(item.quantidade) AS quantidade, "
		 		+ "MAX(pedido.data)) "
		 		+ "FROM Pedido pedido "
		 		+ "JOIN pedido.itens item "
		 		+ "JOIN item.produto produto "
		 		+ "GROUP BY produto.nome "
		 		+ "ORDER BY quantidade DESC ";
		 return em.createQuery(jpql, RelatorioDeVendasVo.class)
				 .getResultList();
	 }
	 
	 public Pedido buscaPedidoComCliente(Long id) {
			String jpql = "SELECT p FROM Pedido p JOIN FETCH p.cliente WHERE p.id = :id ";
			return em.createQuery(jpql, Pedido.class)
					.setParameter("id", id)
					.getSingleResult();
	}
	 
	 public List<RelatorioDeVendasPorClienteVo> relatorioDeVendasClientesFieis() {
		 String jpql = "SELECT new br.com.alura.unicommerce.vo.RelatorioDeVendasClienteVo("
		 		+ "cliente.nome, "
		 		+ "SUM(item.quantidade) AS quantidade, "
		 		+ "SUM(item.quantidade * (item.precoUnitario - item.desconto)) as montante) "
		 		+ "FROM Pedido pedido "
		 		+ "JOIN pedido.itens item "
		 		+ "JOIN item.produto produto "
		 		+ "JOIN pedido.cliente cliente "
		 		+ "GROUP BY cliente.nome "
		 		+ "ORDER BY quantidade DESC ";
		 return em.createQuery(jpql, RelatorioDeVendasPorClienteVo.class)
				 .setMaxResults(3)
				 .getResultList();
	 } 
	 
	 public List<RelatorioDeVendasCategoriaVo> relatorioDeVendasPorCategoria() {
		 String jpql = "SELECT new br.com.alura.unicommerce.vo.RelatorioDeVendasCategoriaVo("
		 		+ "categoria.nome, "
		 		+ "SUM(item.quantidade) as quantidade, "
		 		+ "SUM(item.quantidade * (item.precoUnitario - item.desconto)) as montante) "
		 		+ "FROM Pedido pedido "
		 		+ "JOIN pedido.itens item "
		 		+ "JOIN item.produto produto "
		 		+ "JOIN produto.categoria categoria "
		 		+ "GROUP BY categoria.nome "
		 		+ "ORDER BY montante DESC ";
		 return em.createQuery(jpql, RelatorioDeVendasCategoriaVo.class)
				 .getResultList();
	 }
	 
	 public List<RelatorioProdutoVendidosMaisTresVezesVo> buscarProdutosVendidosMaisTresVezes() {
			String jpql = "SELECT new br.com.alura.unicommerce.vo.RelatorioProdutoVendidosMaisTresVezesVo( "
					+ "produto.nome, COUNT(item.quantidade) AS quantidade) "
					+ " FROM Pedido pedido "
					+ " JOIN pedido.itens item "
					+ "	JOIN item.produto produto "
					+ "	GROUP BY produto.nome "
					+ " HAVING COUNT(item.quantidade) > 3";
			return em.createQuery(jpql, RelatorioProdutoVendidosMaisTresVezesVo.class)
					.getResultList();
	}

}
