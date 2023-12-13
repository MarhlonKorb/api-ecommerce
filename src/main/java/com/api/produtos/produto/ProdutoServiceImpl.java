package com.api.produtos.produto;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ProdutoServiceImpl implements ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public Set<Produto> getAll() {
        return new HashSet<>(produtoRepository.findAll());
    }

    public Produto create(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto update(Produto produto) {
        final Produto produtoEncontrado = produtoRepository.findById(produto.getId()).orElseThrow(EntityNotFoundException::new);
        final Produto produtoBuilder = new ProdutoBuilderImpl()
                .id(produtoEncontrado.getId())
                .nome(produto.getNome())
                .descricao(produto.getDescricao())
                .imgLink(produto.getImgLink()).build();
        return produtoRepository.save(produtoBuilder);
    }

    public void delete(Long id) {
        produtoRepository.deleteById(id);
    }
}
