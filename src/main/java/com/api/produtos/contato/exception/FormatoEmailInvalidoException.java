package com.api.produtos.contato.exception;

/**
 * Exception para formato de email inválido
 */
public class FormatoEmailInvalidoException extends Exception {
    public FormatoEmailInvalidoException(String mensagem) {
        super(mensagem);
    }
}
