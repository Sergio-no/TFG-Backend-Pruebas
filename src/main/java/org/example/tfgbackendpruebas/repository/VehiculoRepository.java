package org.example.tfgbackendpruebas.repository;

import org.example.tfgbackendpruebas.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
    List<Vehiculo> findByClienteId(Long clienteId);

    Optional<Vehiculo> findByMatricula(String matricula);
}
