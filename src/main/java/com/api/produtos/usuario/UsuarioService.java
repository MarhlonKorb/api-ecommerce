package com.api.produtos.usuario;

import com.api.produtos.usuario.dto.UsuarioDto;
import com.api.produtos.usuario.dto.UsuarioInput;
import com.api.produtos.usuario.dto.UsuarioLogin;
import jakarta.persistence.EntityNotFoundException;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

/**
 * Classe responsável por carregar os dados de acesso do usuário para efetuar a autenticação
 */
@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setUsuarioRepository(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Método responsável por realizar a busca e validação pelo email no database
     *
     * @param usuarioInput
     * @return UsuarioDto
     * @throws EntityNotFoundException
     */
    public UsuarioDto login(UsuarioLogin usuarioInput) throws EntityNotFoundException {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(usuarioInput.email());
        /* Valida se as senhas conferem de acordo com o email informado */
        if (!verificarSenha(usuarioInput.senha(), usuario.get().getSenha())) {
            throw new BadCredentialsException("Senha incorreta. Por favor, verifique.");
        }
        return new UsuarioDto(usuario.get().getEmail(), usuario.get().getNome());
    }

    public UsuarioDto create(UsuarioInput usuarioInput) {
        final Usuario usuario = new Usuario();
        usuario.setEmail(usuarioInput.email());
        usuario.setNome(usuarioInput.nome());
        usuario.setDataCriacao(new Date());
        // Criptografar a senha antes de salvar no banco
        final String senhaCriptografada = criptografarSenha(usuarioInput.senha());
        usuario.setSenha(senhaCriptografada);

        usuarioRepository.save(usuario);
        return new UsuarioDto(usuario.getEmail(), usuario.getNome());
    }

    // Método para criptografar a senha
    public String criptografarSenha(String senha) {
        String hashedSenha = BCrypt.hashpw(senha, BCrypt.gensalt());
        return hashedSenha;
    }

    // Método para verificar a senha
    public boolean verificarSenha(String senha, String hashedSenha) {
        return BCrypt.checkpw(senha, hashedSenha);
    }
}
