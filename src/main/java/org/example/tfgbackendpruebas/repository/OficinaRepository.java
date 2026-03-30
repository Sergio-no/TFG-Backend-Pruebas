package org.example.tfgbackendpruebas.repository;

import org.example.tfgbackendpruebas.model.Oficina;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface OficinaRepository extends JpaRepository<Oficina, Long> {
    Optional<Oficina> findByUsuarioId(Long usuarioId);
    Optional<Oficina> findByUsuarioFirebaseUid(String firebaseUid);
}