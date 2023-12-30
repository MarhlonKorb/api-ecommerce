package com.api.produtos.security.dto;

import com.api.produtos.security.enums.UserRole;

public record RegisterDTO(String email, String password, UserRole role) {
}
