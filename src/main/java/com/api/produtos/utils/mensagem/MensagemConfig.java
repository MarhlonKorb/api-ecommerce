package com.api.produtos.utils.mensagem;

import jakarta.annotation.PostConstruct;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;

/**
 * Classe que inicializa o objeto messageSource
 */
@Configuration
public class MensagemConfig {

    private final MessageSource messageSource;

    public MensagemConfig(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @PostConstruct
    public void init() {
        MensagemUtils.setMessageSource(messageSource);
    }
}

