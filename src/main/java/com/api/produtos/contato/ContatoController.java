package com.api.produtos.contato;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contato")
public class ContatoController {

    private ContatoServiceImpl contatoService;

    @Autowired
    public void setContatoService(ContatoServiceImpl contatoService) {
        this.contatoService = contatoService;
    }

    @PostMapping()
    public Contato create(@RequestBody Contato contato) {
        return contatoService.create(contato);
    }
}
