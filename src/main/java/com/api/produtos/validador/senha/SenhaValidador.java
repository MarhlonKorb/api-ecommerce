package com.api.produtos.validador.senha;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

@Service
public class SenhaValidador implements ISenhaValidador {

    @Override
    public void validar(String senha, String hashedSenha) {
        if(!BCrypt.checkpw(senha, hashedSenha)){
            throw new BadCredentialsException("Senha incorreta. Por favor, verifique.");
        }
    }

}
