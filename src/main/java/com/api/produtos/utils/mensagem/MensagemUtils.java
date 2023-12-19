package com.api.produtos.utils.mensagem;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 * Classe utilitária responsável pela internacionalização das mensagens
 */
public class MensagemUtils {

    private static MessageSource messageSource;

    public static void setMessageSource(MessageSource messageSource) {
        MensagemUtils.messageSource = messageSource;
    }

    /**
     * Retorna a mensagem de acordo a chave informada
     *
     * @param key
     * @return String
     */
    public static String getMensagem(String key) {
        return messageSource.getMessage(key, null, LocaleContextHolder.getLocale());
    }
}

