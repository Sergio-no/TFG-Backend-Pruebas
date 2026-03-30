package org.example.tfgbackendpruebas.repository;

import org.example.tfgbackendpruebas.model.ReparacionPieza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReparacionPiezaRepository extends JpaRepository<ReparacionPieza, Long> {
    List<ReparacionPieza> findByReparacionId(Long reparacionId);
}
