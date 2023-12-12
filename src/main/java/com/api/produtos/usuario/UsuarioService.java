package com.api.produtos.usuario;

import com.api.produtos.usuario.dto.UsuarioDto;
import com.api.produtos.usuario.dto.UsuarioInput;
import com.api.produtos.validador.senha.SenhaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Classe responsável por carregar os dados de acesso do usuário para efetuar a autenticação
 */
@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    private SenhaServiceImpl senhaService;

    @Autowired
    public void setUsuarioService(UsuarioRepository usuarioRepository, SenhaServiceImpl senhaService) {
        this.usuarioRepository = usuarioRepository;
        this.senhaService = senhaService;
    }

    public UsuarioDto create(UsuarioInput usuarioInput) {
        final Usuario usuario = new Usuario();
        usuario.setEmail(usuarioInput.email());
        usuario.setNome(usuarioInput.nome());
        final String senhaCriptografada = senhaService.criptografarSenha(usuarioInput.senha());
        usuario.setSenha(senhaCriptografada);
        usuarioRepository.save(usuario);
        return new UsuarioDto(usuario.getEmail(), usuario.getNome());
    }

}
