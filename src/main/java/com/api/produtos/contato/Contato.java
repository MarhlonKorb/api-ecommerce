package com.api.produtos.contato;

import com.api.produtos.abstractentities.EntidadeAuditada;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Contato extends EntidadeAuditada {
    @Column
    @NotEmpty(message = "{campo.nome.obrigatorio}")
    private String nome;
    @Column(nullable = false, unique = true)
    @NotEmpty(message = "{campo.email.obrigatorio}")
    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
