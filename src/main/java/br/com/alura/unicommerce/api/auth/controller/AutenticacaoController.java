package br.com.alura.unicommerce.api.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.unicommerce.api.auth.DadosAutenticacao;
import br.com.alura.unicommerce.api.auth.DadosTokenJWT;
import br.com.alura.unicommerce.core.entity.Usuario;
import br.com.alura.unicommerce.infra.security.service.TokenService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<?> efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = manager.authenticate(authenticationToken);

        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());
        
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-access-token", tokenJWT);

        return ResponseEntity
        		.status(HttpStatus.OK)
        		.headers(headers)
        		.body(new DadosTokenJWT(tokenJWT));
    }

}
