package com.api.produtos.validador.senha;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class SenhaServiceImpl implements ISenhaService{
    @Override
    public String criptografarSenha(String senha) {
        return BCrypt.hashpw(senha, BCrypt.gensalt());
    }
}
