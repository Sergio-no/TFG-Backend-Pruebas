package org.example.tfgbackendpruebas.repository;

import org.example.tfgbackendpruebas.model.Mecanico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MecanicoRepository extends JpaRepository<Mecanico, Long> {
    List<Mecanico> findByActivoTallerTrue();
}