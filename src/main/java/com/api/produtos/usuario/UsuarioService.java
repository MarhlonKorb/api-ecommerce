package com.api.produtos.usuario;

import com.api.produtos.usuario.dto.UsuarioDto;
import com.api.produtos.usuario.dto.UsuarioInput;
import com.api.produtos.validador.senha.ISenhaService;
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
    private ISenhaService iSenhaService;

    public UsuarioDto create(UsuarioInput usuarioInput) {
        final String senhaCriptografada = iSenhaService.criptografarSenha(usuarioInput.senha());
        final Usuario usuario = new UsuarioBuilderImpl()
                .email(usuarioInput.email())
                .nome(usuarioInput.nome())
                .senha(senhaCriptografada)
                .build();
        usuarioRepository.save(usuario);
        return new UsuarioDto(usuario.getEmail(), usuario.getNome());
    }

}
