package com.api.produtos.usuario;

import com.api.produtos.usuario.dto.UsuarioDto;
import com.api.produtos.usuario.dto.UsuarioInput;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDto create(@RequestBody UsuarioInput input) {
        return usuarioService.create(input);
    }

}
