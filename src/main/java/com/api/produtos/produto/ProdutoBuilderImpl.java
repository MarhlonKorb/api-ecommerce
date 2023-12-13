package com.api.produtos.produto;

public class ProdutoBuilderImpl implements ProdutoBuilder {
    private Long id;
    private String nome;
    private String descricao;
    private String imgLink;

    @Override
    public ProdutoBuilder id(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public ProdutoBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }

    @Override
    public ProdutoBuilder descricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    @Override
    public ProdutoBuilder imgLink(String imgLink) {
        this.imgLink = imgLink;
        return this;
    }

    @Override
    public Produto build() {
        // Realiza validações, se necessário, antes de construir o objeto
        return new Produto(nome, descricao, imgLink);
    }
}

