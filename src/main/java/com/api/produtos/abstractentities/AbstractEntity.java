package com.api.produtos.abstractentities;

import jakarta.persistence.*;

import java.util.Date;

@MappedSuperclass
public abstract class AbstractEntity {

    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    protected Date dataCriacao;

    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    protected Date dataUltimaAlteracao;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    /**
     * Configuração da data de criação antes da persistência
     */
    @PrePersist
    protected void prePersist() {
        dataCriacao = new Date();
    }

    /**
     * Lógica após a persistência
     */
    @PostPersist
    protected void postPersist() {
        // Atualização da data de última alteração após a persistência
        dataUltimaAlteracao = new Date();
    }

    /**
     * Lógica antes da atualização
     */
    @PreUpdate
    protected void preUpdate() {

    }

    /**
     * Lógica após a atualização
     */
    @PostUpdate
    protected void postUpdate() {

    }

    /**
     * Lógica antes da remoção
     */
    @PreRemove
    protected void preRemove() {

    }

    /**
     * Lógica após a remoção
     */
    @PostRemove
    protected void postRemove() {
    }

    /**
     * Lógica após o carregamento da entidade
     */
    @PostLoad
    protected void postLoad() {
    }
}
