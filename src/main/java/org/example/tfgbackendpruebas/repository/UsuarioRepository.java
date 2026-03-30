package org.example.tfgbackendpruebas.repository;

import org.example.tfgbackendpruebas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByFirebaseUid(String firebaseUid);

    Optional<Usuario> findByEmail(String email);

    boolean existsByEmail(String email);
}
