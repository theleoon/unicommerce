package br.com.alura.unicommerce.api.usuario.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.unicommerce.api.DadosMensagem;
import br.com.alura.unicommerce.api.usuario.DadosNovoUsuario;
import br.com.alura.unicommerce.api.usuario.DadosUsuario;
import br.com.alura.unicommerce.api.usuario.service.UsuarioService;
import br.com.alura.unicommerce.core.entity.Usuario;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping
	public ResponseEntity<Object> cadastra(@RequestBody @Valid DadosNovoUsuario dadosNovoUsuario) {

		try {
			
			Optional<Usuario> usuario = usuarioService.cadastrar(dadosNovoUsuario.converter());
			return ResponseEntity.status(HttpStatus.CREATED).body(new DadosUsuario(usuario.get()));
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new DadosMensagem("Ocorreu uma falha no cadastro de usuario"));
		}
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Object> consultaPorId(@PathVariable("id") Long usuarioId) {

		try {
			
			Optional<Usuario> usuario = usuarioService.buscaPorId(usuarioId);
			
			if (usuario.isEmpty()) 
				ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new DadosMensagem("Usuário não encontrado por id: " + usuarioId));
			
			return ResponseEntity.status(HttpStatus.CREATED).body(new DadosUsuario(usuario.get()));
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new DadosMensagem("Ocorreu na consulta por id: " + usuarioId));
		}
	}
	
	@GetMapping("/lista")
	public ResponseEntity<Object> listaTodos() {

		try {
			
			Optional<List<Usuario>> usuarios = usuarioService.listaTodos();
			
			if (usuarios.isEmpty()) 
				ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new DadosMensagem("Não há usuários cadastrados"));
			
			return ResponseEntity.status(HttpStatus.OK).body(usuarios.get().stream().map(DadosUsuario::new).collect(Collectors.toList()));
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new DadosMensagem("Ocorreu na consulta por de usuários"));
		}
	}

}
