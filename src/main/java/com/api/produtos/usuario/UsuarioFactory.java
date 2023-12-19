package com.api.produtos.usuario;

import com.api.produtos.usuario.dto.UsuarioInput;
import com.api.produtos.validador.senha.ISenhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Factory para a entidade usuário
 */
@Component
public class UsuarioFactory {

    @Autowired
    private ISenhaService iSenhaService;

    public Usuario criar(UsuarioInput usuarioInput) {
        final String senhaCriptografada = iSenhaService.criptografarSenha(usuarioInput.senha());

        return new UsuarioBuilderImpl()
                .email(usuarioInput.email())
                .nome(usuarioInput.nome())
                .senha(senhaCriptografada)
                .build();
    }

}

