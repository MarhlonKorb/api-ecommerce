package com.api.produtos.validador.contato;

import com.api.produtos.contato.Contato;
import com.api.produtos.validador.IValidador;
import com.api.produtos.validador.email.IValidadorEmail;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractContatoValidador implements IValidador<Contato> {

    @Autowired
    private IValidadorEmail iValidadorEmail;

    abstract void validaIsNotCadastrado(String email);

    @Override
    public void validar(Contato contato){
        validaIsNotCadastrado(contato.getEmail());
        iValidadorEmail.validar(contato.getEmail());
    }
}
