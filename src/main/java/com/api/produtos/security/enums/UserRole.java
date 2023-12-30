package com.api.produtos.security.enums;

public enum UserRole {
    // AS = Admin Sistema
    // AE = Admin Empresa
    // UM = Usuario Simples;
    AS("admin system"), AE("admin empresa"), U("user");

    private String role;

    UserRole(String role){
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}