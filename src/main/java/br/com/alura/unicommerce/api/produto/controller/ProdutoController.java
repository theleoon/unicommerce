package br.com.alura.unicommerce.api.produto.controller;

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

import br.com.alura.unicommerce.api.DadosMensagem;
import br.com.alura.unicommerce.api.categoria.service.CategoriaService;
import br.com.alura.unicommerce.api.produto.DadosProduto;
import br.com.alura.unicommerce.api.produto.DadosNovoProduto;
import br.com.alura.unicommerce.api.produto.service.ProdutoService;
import br.com.alura.unicommerce.core.entity.Produto;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private CategoriaService categoriaService;

	@PostMapping
	@Transactional
	public ResponseEntity<Object> criaNovoProduto(@RequestBody @Valid DadosNovoProduto form, UriComponentsBuilder uriBuilder,
			BindingResult result) {

		try {

			if (result.hasErrors())
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new DadosMensagem(result.getAllErrors()));

			Optional<Produto> novo = form.toEntity(categoriaService);
				
			produtoService.cadastra(novo);
			
			URI uri = uriBuilder.path("/api/produtos/{id}").buildAndExpand(novo.get().getId()).toUri();
			return ResponseEntity.created(uri).body(new DadosProduto(novo.get()));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new DadosMensagem("Ocorreu uma falha no cadastro de produto"));
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> buscaPorId(@PathVariable("id") Long produtoId) {
		try {
			Optional<Produto> produto = produtoService.buscaPorId(produtoId);

			if (produto.isEmpty())
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new DadosMensagem("Produto não encontrado"));

			return ResponseEntity.ok(new DadosProduto(produto.get()));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@GetMapping("/lista")
	public ResponseEntity<List<DadosProduto>> listaTodos() {
		try {
			Optional<List<Produto>> produtos = produtoService.listaTodos();

			if (produtos.isEmpty())
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);

			List<DadosProduto> produtosDto = produtos.get().stream().map(DadosProduto::new).collect(Collectors.toList());

			return ResponseEntity.ok(produtosDto);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}
