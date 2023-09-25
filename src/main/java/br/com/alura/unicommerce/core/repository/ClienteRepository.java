package br.com.alura.unicommerce.core.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.unicommerce.core.entity.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long>  {
	
	List<Cliente> findAll();
	
	Cliente findByNome(String nome);
	
	Cliente findByCpf(String cpf);

}
