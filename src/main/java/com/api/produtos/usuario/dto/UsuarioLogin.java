package com.api.produtos.usuario.dto;

/**
 * Classe utilizada para executar o login de usuário
 *
 * @param email
 * @param senha
 */
public record UsuarioLogin(String email, String senha) {
}
