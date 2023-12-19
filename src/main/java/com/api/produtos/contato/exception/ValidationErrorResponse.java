package com.api.produtos.contato.exception;

import org.springframework.http.HttpStatus;

import java.util.Map;

public class ValidationErrorResponse {
    private HttpStatus status;
    private String entityName;
    private Map<String, String> errors;

    /**
     * Construtor
     *
     * @param status
     * @param entityName
     * @param errors
     */
    public ValidationErrorResponse(HttpStatus status, String entityName, Map<String, String> errors) {
        this.status = status;
        this.entityName = entityName;
        this.errors = errors;
    }

}

