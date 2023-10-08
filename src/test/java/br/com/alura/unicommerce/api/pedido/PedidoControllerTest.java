package br.com.alura.unicommerce.api.pedido;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
@ActiveProfiles("test")
class PedidoControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private JacksonTester<DadosNovoPedido> dadosNovoPedidoJson;
	
	@Test
	@DisplayName("Cadastro novo pedido")
	@WithMockUser
	void cenarioCadastraNovoPedido() throws Exception {
		
		DadosNovoPedido dadosNovoPedido = criaNovoPedido();

		var json = dadosNovoPedidoJson.write(dadosNovoPedido).getJson();
		
		System.out.println(json);
		
		var response = mvc.perform(post("/api/pedido")
							.contentType(MediaType.APPLICATION_JSON)
							.content(json))
							.andReturn().getResponse();
		
		System.out.println(response.getContentAsString());
		
		assertEquals(201, response.getStatus());

	}

	private DadosNovoPedido criaNovoPedido() {
		List<DadosDeProduto> produtos = new ArrayList<>();
		produtos.add(new DadosDeProduto(1l, 2l));
		produtos.add(new DadosDeProduto(2l, 3l));
		DadosNovoPedido dadosNovoPedido = 
				new DadosNovoPedido(1l, new BigDecimal("1000"), produtos);
		return dadosNovoPedido;
	}
	
	@Test
	@DisplayName("Busca pedido por id")
	@WithMockUser
	void cenarioBuscaPedidoPorId() {
		
		

	}

}
