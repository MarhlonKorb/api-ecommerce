package com.api.produtos.produto;

public interface ProdutoBuilder {
    ProdutoBuilder id(Long id);
    ProdutoBuilder nome(String nome);
    ProdutoBuilder descricao(String descricao);
    ProdutoBuilder imgLink(String imgLink);
    Produto build();
}

