package com.api.produtos.usuario;

import com.api.produtos.usuario.dto.UsuarioDto;
import com.api.produtos.usuario.dto.UsuarioInput;
import com.api.produtos.validador.email.IValidadorEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe responsável por carregar os dados de acesso do usuário para efetuar a autenticação
 */
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private UsuarioFactory usuarioFactory;

    @Autowired
    private IValidadorEmail iValidadorEmail;

    public UsuarioDto create(UsuarioInput usuarioInput) {
        iValidadorEmail.validar(usuarioInput.email());
        Usuario usuario = usuarioFactory.criar(usuarioInput);
        usuarioRepository.save(usuario);
        return new UsuarioDto(usuario.getEmail(), usuario.getNome());
    }

}
