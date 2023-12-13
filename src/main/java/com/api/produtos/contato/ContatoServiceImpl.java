package com.api.produtos.contato;

import com.api.produtos.validador.contato.IContatoValidador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContatoServiceImpl implements ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private IContatoValidador contatoValidador;

    public Contato create(Contato contato) {
        contatoValidador.validar(contato);
        return contatoRepository.save(contato);
    }
}
