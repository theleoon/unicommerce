package br.com.alura.unicommerce.api.pedido.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.unicommerce.api.cliente.service.ClienteService;
import br.com.alura.unicommerce.api.infra.DadosMensagem;
import br.com.alura.unicommerce.api.pedido.DadosNovoPedido;
import br.com.alura.unicommerce.api.pedido.DadosPedido;
import br.com.alura.unicommerce.api.pedido.service.PedidoService;
import br.com.alura.unicommerce.api.produto.service.ProdutoService;
import br.com.alura.unicommerce.core.entity.Pedido;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {
	
	private static final Logger log = LoggerFactory.getLogger(PedidoController.class);
	
	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ProdutoService produtoService;
	
	@PostMapping
	@Transactional
	public ResponseEntity<Object> cadastra(@RequestBody @Valid DadosNovoPedido dadosDePedido, 
			BindingResult result) {
		
		log.info(dadosDePedido.toString());
		
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
	
	
	@GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Object> buscaPorId(@PathVariable("id") Long id){
    	
        if(id == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new DadosMensagem("Id para buscar inválido"));
        
        Optional<Pedido> encontrada = pedidoService.buscaPorId(id);
        
        if(encontrada.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new DadosMensagem("Pedido não encontrado"));

        return ResponseEntity.status(HttpStatus.OK).body(new DadosPedido(encontrada.get()));
    }
	
	@GetMapping("/lista")
    @ResponseBody
    public ResponseEntity<?> listaTodos(){
    	
        Optional<List<Pedido>> pedidos = pedidoService.listaTodas();
        
        if(pedidos.isEmpty()) return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new DadosMensagem("Não existem pedidos no sistema"));

        return ResponseEntity.status(HttpStatus.OK)
        		.body(pedidos.get().stream().map(DadosPedido::new).collect(Collectors.toList()));
    }

}
