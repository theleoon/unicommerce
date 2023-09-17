package br.com.alura.unicommerce.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.unicommerce.core.entity.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>  {

}
