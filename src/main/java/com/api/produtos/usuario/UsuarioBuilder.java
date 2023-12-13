package com.api.produtos.usuario;

public interface UsuarioBuilder {
    UsuarioBuilder id(Long id);
    UsuarioBuilder email(String email);
    UsuarioBuilder nome(String nome);
    UsuarioBuilder senha(String senha);
    Usuario build();
}

