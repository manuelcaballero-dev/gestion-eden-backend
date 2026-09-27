package com.gestioneden.repository;

import com.gestioneden.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//Repositorio encargado del acceso a los datos de los usuarios.
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    // Busca un usuario registrado mediante su correo electrónico.
    Optional<Usuario> findByCorreo(String correo);

    // Permite comprobar si ya existe un usuario con el correo indicado.
    boolean existsByCorreo(String correo);
}
