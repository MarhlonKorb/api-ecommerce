package com.api.produtos.validador.contato;

import com.api.produtos.contato.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

/**
 * Classe que executa a validação da entidade Contato
 */
@Component
public class ContatoValidadorImpl extends AbstractContatoValidador {
    @Autowired
    private ContatoRepository contatoRepository;

    /**
     * Executa a validação do nome
     * @param nome
     * @return String
     */
    public void validarNome(String nome) {
        if(nome == null || nome.isEmpty()){
            throw new IllegalArgumentException("O nome não pode estar vazio.");
        }
    }

    @Override
    public void validaIsNotCadastrado(String email){
        if(contatoRepository.findByEmail(email) != null){
            throw new DataIntegrityViolationException("E-mail já cadastrado.");
        }
    }

}
