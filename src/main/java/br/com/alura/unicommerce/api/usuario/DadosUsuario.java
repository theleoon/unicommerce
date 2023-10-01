package br.com.alura.unicommerce.api.usuario;

import br.com.alura.unicommerce.core.entity.Usuario;

public record DadosUsuario (Long id, String login) {

	public DadosUsuario(Usuario usuario) {
		this(usuario.getId(), usuario.getLogin());
	}

}
