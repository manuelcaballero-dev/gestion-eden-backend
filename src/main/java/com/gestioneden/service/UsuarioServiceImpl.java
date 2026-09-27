package com.gestioneden.service;

import com.gestioneden.entity.Usuario;
import com.gestioneden.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

// Implementa la lógica de registro y autenticación de usuarios.
@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Registra un usuario si el correo todavía no existe.
    @Override
    public Usuario registrar(Usuario usuario) {

        if (usuarioRepository.existsByCorreo(usuario.getCorreo())) {
            return null;
        }

        usuario.setEstado(true);
        return usuarioRepository.save(usuario);
    }

    // Válida el correo y la contraseña de un usuario activo.
    @Override
    public Usuario autenticar(String correo, String password) {

        return usuarioRepository.findByCorreo(correo)
                .filter(usuario -> Boolean.TRUE.equals(usuario.getEstado()))
                .filter(usuario -> usuario.getPassword().equals(password))
                .orElse(null);
    }
}