package br.com.alura.unicommerce.core.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.unicommerce.core.entity.Pedido;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Long>  {
	
	List<Pedido> findAll();


}
