package com.gestioneden.service;

import com.gestioneden.entity.Usuario;

// Define las operaciones necesarias para el registro y la autenticación de usuarios.
public interface UsuarioService {

    // Registra un nuevo usuario en el sistema.
    Usuario registrar(Usuario usuario);

    // Válida las credenciales ingresadas por el usuario.
    Usuario autenticar(String correo, String password);
}
