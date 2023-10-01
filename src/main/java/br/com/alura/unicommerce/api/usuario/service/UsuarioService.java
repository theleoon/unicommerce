package br.com.alura.unicommerce.api.usuario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.unicommerce.api.usuario.exception.UsuarioException;
import br.com.alura.unicommerce.core.entity.Usuario;
import br.com.alura.unicommerce.core.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public Optional<Usuario> cadastrar(Usuario usuario) throws UsuarioException {

		if (usuario == null)
			throw new UsuarioException("Cadastro inválido para usuario nulo");
		
		return Optional.ofNullable(repository.save(usuario));
	}

	public Optional<Usuario> buscaPorId(Long usuarioId) {
		return repository.findById(usuarioId);
	}

	public Optional<List<Usuario>> listaTodos() {
		return Optional.ofNullable(repository.findAll());
	}

}
