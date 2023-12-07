package com.api.produtos.contato;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ContatoService {

    private ContatoRepository contatoRepository;

    private ContatoValidadorImpl contatoValidador;

    @Autowired
    public void setContatoRepository(ContatoRepository contatoRepository, IContatoValidador contatoValidador) {
        this.contatoRepository = contatoRepository;
        this.contatoValidador = (ContatoValidadorImpl) contatoValidador;

    }

    public Contato create(Contato contato){
        contatoValidador.validar(contato);
        return contatoRepository.save(contato) ;
    }
}
