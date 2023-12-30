package com.api.produtos.security.controller;

import com.api.produtos.security.dto.AuthenticationDTO;
import com.api.produtos.security.dto.RegisterDTO;
import com.api.produtos.security.services.TokenService;
import com.api.produtos.usuario.Usuario;
import com.api.produtos.usuario.UsuarioRepository;
import com.api.produtos.usuario.UsuarioService;
import com.security.securityauth.dto.LoginResponseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

/**
 * Controller que valida a autenticação do usuário
 */
@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = authenticationManager.authenticate(usernamePassword);

        // Gera o token para o usuário
        var token = tokenService.generateToken(
                (Usuario) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterDTO data) {
        usuarioService.create(data);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/recurso-protegido")
    public ResponseEntity<String> recursoProtegido() {
        // Lógica do endpoint aqui
        return ResponseEntity.ok("Este é um recurso protegido!");
    }
}
