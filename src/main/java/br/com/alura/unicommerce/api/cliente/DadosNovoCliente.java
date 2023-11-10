package br.com.alura.unicommerce.api.cliente;

import br.com.alura.unicommerce.api.usuario.service.UsuarioService;
import br.com.alura.unicommerce.core.entity.Cliente;
import br.com.alura.unicommerce.core.entity.Usuario;

public record DadosNovoCliente(String nome, String cpf, String telefone, DadosNovoEndereco endereco, DadosUsuario usuario) {

	public Cliente toEntity(UsuarioService usuarioService) {
		return new Cliente(nome, cpf, telefone, endereco.toEntity(), usuario.toEntity(usuarioService));
	}

}

record DadosUsuario(String login, String senha) {

	public Usuario toEntity(UsuarioService usuarioService) {
		return new Usuario(login, senha);
	}

}


