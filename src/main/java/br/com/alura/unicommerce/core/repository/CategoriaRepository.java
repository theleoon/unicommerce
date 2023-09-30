package br.com.alura.unicommerce.core.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.unicommerce.core.entity.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long>  {
	
	List<Categoria> findAll();
	
	Categoria findByNome(String nome);
	
}
