package br.com.alura.unicommerce.api.produto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.unicommerce.api.produto.exception.ProdutoException;
import br.com.alura.unicommerce.core.dao.ProdutoDao;
import br.com.alura.unicommerce.core.entity.Produto;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoDao produtoDao;
    
    public void cadastra(Optional<Produto> obj) throws ProdutoException {
        if(obj.isEmpty()) throw new ProdutoException("Cadastro inválido para produto nulo");
        this.produtoDao.save(obj.get());
    }

    public Optional<Produto> buscaPorId(Long id) {
        return Optional.ofNullable(this.produtoDao.get(id));
    }

    public void atualiza(Produto produto) throws ProdutoException {
        if(produto == null) throw new ProdutoException("Atualização inválida para produto nulo");
        this.produtoDao.save(produto);
    }

    public Optional<List<Produto>> listaTodos() {
        return Optional.ofNullable(this.produtoDao.listaTodos());
    }

}