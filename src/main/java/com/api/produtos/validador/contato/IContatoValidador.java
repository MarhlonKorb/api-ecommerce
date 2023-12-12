package com.api.produtos.validador.contato;

import com.api.produtos.contato.Contato;

/**
 * Interface para validação da entindade contato
 */
public interface IContatoValidador {

    /**
     * Executa a validação do contato
     * @param contato
     */
    public void validar(Contato contato);

}
