package com.api.produtos.usuario;

import com.api.produtos.abstractentities.EntidadeAuditada;
import com.api.produtos.security.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
public class Usuario extends EntidadeAuditada implements UserDetails {

    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    @Column(unique = true)
    @NotEmpty(message = "{campo.email.obrigatorio}")
    private String email;

    @Column(unique = true)
    private String nome;

    @Column(unique = true, name = "senha")
    @NotEmpty(message = "{campo.senha.obrigatorio}")
    private String senha;

    public Usuario() {
    }

    public Usuario(String login, String encryptedPassword, UserRole role) {
        this.email = login;
        this.senha = encryptedPassword;
        this.userRole = role;
    }

    public Usuario(String email, String nome, String senha) {
        this.email = email;
        this.nome = nome;
        this.senha = senha;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.userRole == UserRole.AS) {
            return List.of(new SimpleGrantedAuthority("ROLE_AS"), new SimpleGrantedAuthority("ROLE_AE"), new SimpleGrantedAuthority("ROLE_U"));
        }
        return List.of(new SimpleGrantedAuthority("ROLE_U"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
