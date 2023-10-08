package br.com.alura.unicommerce.api.categoria;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
@ActiveProfiles("test")
class CategoriaControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private JacksonTester<DadosCategoria> dadosCategoriaJson;
	
	@Autowired
	private JacksonTester<DadosNovaCategoria> dadosNovaCategoriaJson;
	
	@Test
	@DisplayName("Valida a consulta de uma categoria por id")
	@WithMockUser
	void cria_categoria() throws Exception {
		
		// Crio JSON a partir de um Record
		System.out.println(dadosNovaCategoriaJson.write(new DadosNovaCategoria("Celulares")).getJson());
		
		// Faço uma requisição do tipo GET
		var response = mvc.perform(get("/api/categoria/2"))
				.andReturn()
				.getResponse();
		
		// Mostro o resultado que retornou na resposta da requisição
		System.out.println(response.getContentAsString());
		
		// Posso converter o JSON do response em um objeto Record
		DadosCategoria dadosCategoria = dadosCategoriaJson.parseObject(response.getContentAsString());
		
		System.out.println(dadosCategoria);
		 
		assertEquals(response.getStatus(), 200);

	}
	
	@Test
	@DisplayName("Cadastro nova categoria")
	@WithMockUser
	void cadastroNovaCategoria() throws Exception {

			var dados = dadosNovaCategoriaJson
							.write(new DadosNovaCategoria("Geladeiras")).getJson();
			
			System.out.println(dados);
			
			var response = mvc.perform(post("/api/categoria")
								.contentType(MediaType.APPLICATION_JSON)
								.content(dados))
								.andReturn().getResponse();
			
			System.out.println(response.getContentAsString());
			
			assertEquals(201, response.getStatus());
	}

}
