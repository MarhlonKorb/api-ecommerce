package com.api.produtos.validador;

import com.api.produtos.contato.Contato;

/**
 * Interface para validação de uma entindade
 */
public interface IValidador<T> {

    /**
     * Executa a validação de uma entidade
     * @param Entity
     */
    void validar(T Entity);


}
