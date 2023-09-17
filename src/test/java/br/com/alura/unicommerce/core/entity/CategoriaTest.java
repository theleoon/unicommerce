package br.com.alura.unicommerce.core.entity;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class CategoriaTest {

	@Test
	void deveCriarCategoriaComNomeValido() {
		Categoria novaCategoria = new Categoria("Celular");

		assertEquals("Celular", novaCategoria.getNome());
	}

	@Test
	void deveValidarCategoriaComNomeNulo() {

		assertThrows(IllegalArgumentException.class, () -> {
			new Categoria(null);
		});
	}

	@Test
	void deveValidarCategoriaComNomeVazio() {

		assertThrows(IllegalArgumentException.class, () -> {
			new Categoria("");
		});
	}
}