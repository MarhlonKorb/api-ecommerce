package com.api.produtos.validador.senha;

public interface ISenhaValidador {

    void validar(String senha, String hashedSenha);
}
