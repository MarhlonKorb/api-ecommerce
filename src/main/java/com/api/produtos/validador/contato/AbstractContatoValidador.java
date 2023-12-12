package com.api.produtos.validador.contato;

import com.api.produtos.contato.Contato;
import com.api.produtos.validador.email.IValidadorEmail;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractContatoValidador implements IContatoValidador{

    @Autowired
    private IValidadorEmail iValidadorEmail;

    @Override
    public void validar(Contato contato){
        validaIsNotCadastrado(contato.getEmail());
        validarNome(contato.getNome());
        iValidadorEmail.validar(contato.getEmail());
    }
}
