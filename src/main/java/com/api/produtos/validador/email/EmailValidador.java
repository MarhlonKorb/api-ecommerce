package com.api.produtos.validador.email;

import com.api.produtos.contato.exception.FormatoEmailInvalidoException;
import com.api.produtos.utils.mensagem.MensagemUtils;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe que executa a validação de email
 */
@Component
public class EmailValidador implements IValidadorEmail {
    /* Regex para comparar a formatação do email recebido */
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    @Override
    public void validar(String email) {
        final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        try {
            if (email == null || email.isEmpty()) {
                String mensagem = MensagemUtils.getMensagem("campo.email.obrigatorio");
                throw new FormatoEmailInvalidoException(mensagem);
            }
            final Matcher matcher = pattern.matcher(email);
            if (!matcher.matches()) {
                throw new FormatoEmailInvalidoException("Formato de e-mail inválido.");
            }
        } catch (FormatoEmailInvalidoException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
