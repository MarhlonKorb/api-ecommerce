package com.api.produtos.usuario;

import com.api.produtos.usuario.dto.UsuarioDto;
import com.api.produtos.usuario.dto.UsuarioInput;
import com.api.produtos.usuario.dto.UsuarioLogin;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;

    @Autowired
    public void setUsuarioRepository(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDto create(@RequestBody UsuarioInput input) {
        return usuarioService.create(input);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsuarioLogin usuario) {
        try {
            usuarioService.login(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Falha ao realizar o login. " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e.getCause());
        }
    }
}
