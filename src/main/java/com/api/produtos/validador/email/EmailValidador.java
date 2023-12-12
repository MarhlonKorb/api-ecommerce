package com.api.produtos.validador.email;

import com.api.produtos.contato.ContatoRepository;
import com.api.produtos.contato.exception.FormatoEmailInvalidoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe que executa a validação de email
 */
@Component
public class EmailValidador implements IValidadorEmail{
    /* Regex para comparar a formatação do email recebido */
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private ContatoRepository contatoRepository;

    @Autowired
    public void setContatoRepository(ContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }

    @Override
    public void validar(String email) {
        final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        try {
            if (email == null || email.isEmpty()) {
                throw new FormatoEmailInvalidoException("E-mail não pode estar vazio.");
            }
            final Matcher matcher = pattern.matcher(email);
            if (!matcher.matches()) {
                throw new FormatoEmailInvalidoException("Formato de e-mail inválido.");
            }
            if(contatoRepository.findByEmail(email) != null){
                throw new DataIntegrityViolationException("E-mail já cadastrado.");
            }
        } catch (FormatoEmailInvalidoException | DataIntegrityViolationException  e) {
            System.out.println(e.getMessage());
        }
    }

}
