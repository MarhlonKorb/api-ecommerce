package com.api.produtos.contato;

import com.api.produtos.validador.email.EmailValidador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Classe que executa a validação da entidade Contato
 */
@Component
public class ContatoValidadorImpl implements IContatoValidador {

    private EmailValidador emailValidador;

    @Autowired
    public void setEmailValidador(EmailValidador emailValidador) {
        this.emailValidador = emailValidador;
    }

    /**
     * Executa a validação do nome
     * @param nome
     * @return String
     */
    private void validarNome(String nome) {
        if(nome == null && nome.isEmpty()){
            throw new IllegalArgumentException("O nome não pode estar vazio.");
        }
    }

    @Override
    public void validar(Contato contato) {
        validarNome(contato.getNome());
        emailValidador.validarEmail(contato.getEmail());
    }
}
