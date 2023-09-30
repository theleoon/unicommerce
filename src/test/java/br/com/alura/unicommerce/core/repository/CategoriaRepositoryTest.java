package br.com.alura.unicommerce.core.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.alura.unicommerce.core.entity.Categoria;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CategoriaRepositoryTest {

	@Autowired
	private CategoriaRepository repository;

	@Test
	@DisplayName("Cadastro de nova categoria")
	void cadastraCategoria() {

		var categoria = cadastrarCategoria("Artigos Esportivos");
		assertNotNull(categoria);
	}

	@Test
	@DisplayName("Desativa categoria")
	void desativaCategoria() {

		var categoria = cadastrarCategoria("Presentes");
		desativaCategoria(categoria);
		
		assertNotNull(categoria);
		assertEquals(Boolean.FALSE, categoria.isStatus());
	}

	private Categoria cadastrarCategoria(String nome) {
		return repository.save(new Categoria(nome));
	}

	private Categoria desativaCategoria(Categoria categoria) {
		categoria.desativa();
		return repository.save(categoria);
	}

}
