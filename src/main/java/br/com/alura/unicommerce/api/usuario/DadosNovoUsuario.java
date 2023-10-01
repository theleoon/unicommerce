package br.com.alura.unicommerce.api.usuario;

import br.com.alura.unicommerce.core.entity.Usuario;

public record DadosNovoUsuario(String login, String senha) {

	public Usuario converter() {
		return new Usuario(this.login, this.senha);
	}

}
