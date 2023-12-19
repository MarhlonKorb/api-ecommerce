package com.api.produtos.validador.senha;

import jakarta.persistence.PrePersist;

public interface ISenhaValidador {

    void validar(String senha, String hashedSenha);
}
