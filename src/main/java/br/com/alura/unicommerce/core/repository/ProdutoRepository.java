package br.com.alura.unicommerce.core.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.unicommerce.core.entity.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long>  {
	
	List<Produto> findAll();
	
	Produto findByNome(String nome);

}
