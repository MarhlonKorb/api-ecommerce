package com.api.produtos.usuario.dto;

/**
 * Record que representa o objeto usuário de entrada do sistema
 *
 * @param email
 * @param nome
 * @param senha
 */
public record UsuarioInput(String email, String nome, String senha) {
}
