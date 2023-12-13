package com.api.produtos.produto;

import com.api.produtos.abstractentities.EntidadeAuditada;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
@Entity(name = "produto")
public class Produto extends EntidadeAuditada {
    @Column
    private String nome;
    @Column
    private String descricao;
    @Column
    private String imgLink;

    public Produto() {
    }

    public Produto(String nome, String descricao, String imgLink) {
        super();
    }

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
