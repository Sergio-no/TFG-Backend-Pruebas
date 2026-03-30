package org.example.tfgbackendpruebas.repository;

import org.example.tfgbackendpruebas.model.PuntosHistorial;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PuntosHistorialRepository extends JpaRepository<PuntosHistorial, Long> {
    List<PuntosHistorial> findByClienteIdOrderByFechaDesc(Long clienteId);
}
