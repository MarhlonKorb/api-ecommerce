package com.api.produtos.usuario;

import com.api.produtos.abstractentities.EntidadeAuditada;
import com.api.produtos.usuario.enums.TipoUsuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Usuario extends EntidadeAuditada {

    @Enumerated
    private TipoUsuario tipoUsuario;
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

    public Usuario(String email, String nome, String senha) {
        super();
        this.email = email;
        this.nome = nome;
        this.senha = senha;
    }


    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
