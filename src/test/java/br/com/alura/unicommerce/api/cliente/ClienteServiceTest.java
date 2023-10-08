package br.com.alura.unicommerce.api.cliente;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
public class ClienteServiceTest {
	
	@BeforeAll
	static void init() {
		// TODO construir todos os dados necessários para os cenários.
	}
	
	@Test
	void validarCenarioDeNegocio1() {
		// TODO implementar validação da regra de negócio
	}
	
	@Test
	void validarCenarioDeNegocio2() {
		// TODO implementar validação da regra de negócio
		assertTrue(Boolean.TRUE, "Sucesso");
	}

}
