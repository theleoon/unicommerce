package br.com.alura.unicommerce.api.categoria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.unicommerce.api.categoria.exception.CategoriaException;
import br.com.alura.unicommerce.core.dao.CategoriaDao;
import br.com.alura.unicommerce.core.entity.Categoria;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaDao categoriaDao;

	public void cadastra(Categoria categoria) throws CategoriaException {

		if (categoria == null)
			throw new CategoriaException("Cadastro inválido para objeto nulo");

		categoriaDao.save(categoria);
	}

	public Optional<Categoria> buscaPorId(Long categoriaId) throws CategoriaException {

		if (categoriaId == null)
			throw new CategoriaException("Falha ao carregar categoria, id inválido");

		return Optional.ofNullable(categoriaDao.get(categoriaId));
	}

	public Optional<List<Categoria>> listaTodas() {
		return Optional.ofNullable(categoriaDao.listaTodos());
	}
}