package br.com.alura.unicommerce.api.pedido.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.unicommerce.api.cliente.service.ClienteService;
import br.com.alura.unicommerce.api.pedido.DadosDePedido;
import br.com.alura.unicommerce.api.pedido.service.PedidoService;
import br.com.alura.unicommerce.api.produto.service.ProdutoService;
import br.com.alura.unicommerce.core.entity.Pedido;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {
	
	@Autowired
	private PedidoService service;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ProdutoService produtoService;
	
	@PostMapping
	ResponseEntity<Object> cadastraNovoPedido(@RequestBody @Valid DadosDePedido dadosDePedido, 
			BindingResult result) {
		
		System.out.println(dadosDePedido);
		
		if (result.hasErrors()) ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		
		Pedido novoPedido = dadosDePedido.converter(clienteService, produtoService);
		service.cadastra(novoPedido);
		
		return null;
	}

}
