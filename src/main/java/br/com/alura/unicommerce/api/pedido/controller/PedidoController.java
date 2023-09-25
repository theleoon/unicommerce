package br.com.alura.unicommerce.api.pedido.controller;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.unicommerce.api.DadosMensagem;
import br.com.alura.unicommerce.api.cliente.service.ClienteService;
import br.com.alura.unicommerce.api.pedido.DadosNovoPedido;
import br.com.alura.unicommerce.api.pedido.DadosPedido;
import br.com.alura.unicommerce.api.pedido.service.PedidoService;
import br.com.alura.unicommerce.api.produto.service.ProdutoService;
import br.com.alura.unicommerce.core.entity.Pedido;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ProdutoService produtoService;
	
	@PostMapping
	@Transactional
	ResponseEntity<Object> cadastra(@RequestBody @Valid DadosNovoPedido dadosDePedido, 
			BindingResult result) {
		
		if (result.hasErrors()) ResponseEntity
									.status(HttpStatus.BAD_REQUEST)
									.body(null);
		
		Optional<Pedido> novoPedido = dadosDePedido
										.converter(clienteService, produtoService);
		
		if (novoPedido.isPresent()) {
			pedidoService.cadastra(novoPedido.get());
			return ResponseEntity.status(HttpStatus.CREATED)
						.body(new DadosPedido(novoPedido.get()));
		}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new DadosMensagem("Falha ao gravar novo pedido"));
	}

}
