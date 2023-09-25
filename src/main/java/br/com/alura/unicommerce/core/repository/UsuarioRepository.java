package br.com.alura.unicommerce.core.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.alura.unicommerce.core.entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    
	UserDetails findByLogin(String login);
	
}
