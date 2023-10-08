package br.com.alura.unicommerce.api.produto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.unicommerce.api.produto.exception.ProdutoException;
import br.com.alura.unicommerce.core.dao.ProdutoDao;
import br.com.alura.unicommerce.core.entity.Produto;
import br.com.alura.unicommerce.core.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;
    
    public void cadastra(Optional<Produto> obj) throws ProdutoException {
        if(obj.isEmpty()) throw new ProdutoException("Cadastro inválido para produto nulo");
        repository.save(obj.get());
    }

    public Optional<Produto> buscaPorId(Long id) {
        return repository.findById(id);
    }

    public void atualiza(Produto produto) throws ProdutoException {
        if(produto == null) throw new ProdutoException("Atualização inválida para produto nulo");
        repository.save(produto);
    }

    public Optional<List<Produto>> listaTodos() {
        return Optional.ofNullable(repository.findAll());
    }

}