package com.api.produtos.produto;

import com.api.produtos.abstractentities.AbstractEntity;
import jakarta.persistence.*;

@Entity(name = "produto")
public class Produto extends AbstractEntity {
    @Column
    private String nome;
    @Column
    private String descricao;

    @Column
    private String imgLink;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }
}
