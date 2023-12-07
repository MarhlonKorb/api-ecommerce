package com.api.produtos.contato;
import com.api.produtos.abstractentities.AbstractEntity;
import jakarta.persistence.*;

@Entity
public class Contato extends AbstractEntity {
    @Column
    private String nome;
    @Column(nullable = false, unique = true)
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
