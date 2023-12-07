package com.api.produtos.usuario;

import com.api.produtos.abstractentities.AbstractEntity;
import com.api.produtos.usuario.enums.TipoUsuario;
import jakarta.persistence.*;

@Entity
public class Usuario extends AbstractEntity {

    @Enumerated
    private TipoUsuario tipoUsuario;
    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String nome;

    @Column(unique = true, name = "senha")
    private String senha;

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
