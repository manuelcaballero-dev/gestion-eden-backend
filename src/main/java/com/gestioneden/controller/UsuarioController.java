package com.gestioneden.controller;

import com.gestioneden.entity.Usuario;
import com.gestioneden.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

// Controlador REST encargado del registro y del inicio de sesión de los usuarios.
@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "http://localhost:5173")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Registra un nuevo usuario en la base de datos.
    @PostMapping("/registro")
    public ResponseEntity<?> registrar(@RequestBody Usuario usuario) {

        Usuario usuarioRegistrado = usuarioService.registrar(usuario);

        if (usuarioRegistrado == null) {
            return ResponseEntity.badRequest()
                    .body(Map.of("mensaje", "El correo ya se encuentra registrado"));
        }

        return ResponseEntity.ok(
                Map.of("mensaje", "Usuario registrado satisfactoriamente")
        );
    }

    // Válida el correo y la contraseña enviados por el usuario.
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credenciales) {

        String correo = credenciales.get("correo");
        String password = credenciales.get("password");

        Usuario usuario = usuarioService.autenticar(correo, password);

        if (usuario == null) {
            return ResponseEntity.status(401)
                    .body(Map.of("mensaje", "Error en la autenticación"));
        }

        return ResponseEntity.ok(
                Map.of(
                        "mensaje", "Autenticación satisfactoria",
                        "usuario", usuario.getNombre(),
                        "rol", usuario.getRol()
                )
        );
    }
}