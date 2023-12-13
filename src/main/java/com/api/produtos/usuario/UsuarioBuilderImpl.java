package com.api.produtos.usuario;

public class UsuarioBuilderImpl implements UsuarioBuilder {
    private Long id;
    private String email;
    private String nome;
    private String senha;

    @Override
    public UsuarioBuilder id(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public UsuarioBuilder email(String email) {
        this.email = email;
        return this;
    }

    @Override
    public UsuarioBuilder senha(String senha) {
        this.senha = senha;
        return this;
    }

    @Override
    public UsuarioBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }

    @Override
    public Usuario build() {
        // Realiza validações, se necessário, antes de construir o objeto
        return new Usuario(email, nome, senha);
    }
}

