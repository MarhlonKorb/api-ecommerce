package com.api.produtos.contato;

import org.springframework.data.jpa.repository.JpaRepository;
public interface ContatoRepository extends JpaRepository<Contato, Long> {

    public Contato findByEmail(String email);
}
