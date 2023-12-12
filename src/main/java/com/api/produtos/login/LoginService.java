package com.api.produtos.login;

import com.api.produtos.usuario.dto.UsuarioDto;
import com.api.produtos.usuario.dto.UsuarioLogin;
import jakarta.persistence.EntityNotFoundException;

public interface LoginService {

    UsuarioDto login(UsuarioLogin usuario) throws EntityNotFoundException;
}
