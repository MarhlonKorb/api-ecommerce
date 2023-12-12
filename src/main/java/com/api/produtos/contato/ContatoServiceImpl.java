package com.api.produtos.contato;

import com.api.produtos.validador.contato.ContatoValidadorImpl;
import com.api.produtos.validador.contato.IContatoValidador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContatoServiceImpl implements ContatoService {

    private ContatoRepository contatoRepository;

    private ContatoValidadorImpl contatoValidador;

    @Autowired
    public void setContatoServiceImpl(ContatoRepository contatoRepository, IContatoValidador contatoValidador) {
        this.contatoRepository = contatoRepository;
        this.contatoValidador = (ContatoValidadorImpl) contatoValidador;
    }

    public Contato create(Contato contato) {
        contatoValidador.validar(contato);
        return contatoRepository.save(contato);
    }
}
