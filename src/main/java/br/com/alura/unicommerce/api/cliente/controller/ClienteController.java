package br.com.alura.unicommerce.api.cliente.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.unicommerce.api.DadosMensagem;
import br.com.alura.unicommerce.api.cliente.DadosCliente;
import br.com.alura.unicommerce.api.cliente.DadosNovoCliente;
import br.com.alura.unicommerce.api.cliente.service.ClienteService;
import br.com.alura.unicommerce.core.entity.Cliente;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosCliente> criaNovoCliente(@RequestBody @Valid DadosNovoCliente form,
                                                    UriComponentsBuilder uriBuilder,
                                                    BindingResult result){
    	System.out.println(form.toString());
    	
        if(result.hasFieldErrors())
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        
        Cliente novaCliente = form.toEntity();
        service.cadastra(novaCliente);

        URI uri = uriBuilder.path("/api/clientes/{id}").buildAndExpand(novaCliente.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosCliente(novaCliente));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> buscaClientePorId(@PathVariable("id") Long idCliente){
    	
        if(idCliente == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new DadosMensagem("Id para buscar Cliente inválido"));
        
        Optional<Cliente> encontrada = service.buscaPorId(idCliente);
        
        if(encontrada.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new DadosMensagem("Cliente não encontrado"));

        return ResponseEntity.status(HttpStatus.OK).body(new DadosCliente(encontrada.get()));
    }
    
}
