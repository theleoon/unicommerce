package br.com.alura.unicommerce.api.categoria.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

import br.com.alura.unicommerce.api.categoria.CategoriaDto;
import br.com.alura.unicommerce.api.categoria.CategoriaRequestDto;
import br.com.alura.unicommerce.api.categoria.service.CategoriaService;
import br.com.alura.unicommerce.core.MensagemDto;
import br.com.alura.unicommerce.core.entity.Categoria;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @PostMapping
    @Transactional
    public ResponseEntity<CategoriaDto> criaNovaCategoria(@RequestBody @Valid CategoriaRequestDto form,
                                                    UriComponentsBuilder uriBuilder,
                                                    BindingResult result){
    	System.out.println(form.toString());
    	
        if(result.hasFieldErrors())
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);

        Categoria novaCategoria = form.converter();
        service.cadastra(novaCategoria);

        URI uri = uriBuilder.path("/api/categorias/{id}").buildAndExpand(novaCategoria.getId()).toUri();
        return ResponseEntity.created(uri).body(new CategoriaDto(novaCategoria));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> obtemCategoriaPorId(@PathVariable("id") Long idCategoria){
        if(idCategoria == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MensagemDto("Id para buscar categoria inválido"));
        
        Optional<Categoria> encontrada = service.buscaPorId(idCategoria);
        
        if(encontrada.isEmpty()) return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new MensagemDto("Categoria não encontrada"));

        return ResponseEntity.status(HttpStatus.OK).body(new CategoriaDto(encontrada.get()));
    }
    
    @GetMapping("/lista")
    public ResponseEntity<?> buscaTodasAsCategorias(){
    	
        Optional<List<Categoria>> categorias = service.listaTodas();
        
        if(categorias.isEmpty()) return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new MensagemDto("Não existem categorias no sistema"));

        return ResponseEntity.status(HttpStatus.OK)
        		.body(categorias.get().stream().map(CategoriaDto::new).collect(Collectors.toList()));
    }
}