package com.api.produtos.produto;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ProdutoService {
    private ProdutoRepository produtoRepository;

    @Autowired
    private void setProdutoRepository(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Set<Produto> getAll(){
        return new HashSet<>(produtoRepository.findAll());
    }

    public Produto create(Produto produto){
        return produtoRepository.save(produto);
    }
    public Produto update(Produto produto){
        final Produto produtoEncontrado = produtoRepository.findById(produto.getId()).orElseThrow(EntityNotFoundException::new);
        produtoEncontrado.setNome(produto.getNome());
        produtoEncontrado.setDescricao(produto.getDescricao());
        produtoEncontrado.setImgLink(produto.getImgLink());
        return produtoRepository.save(produtoEncontrado);
    }

    public void deleteById(Long id){
        produtoRepository.deleteById(id);
    }
}
