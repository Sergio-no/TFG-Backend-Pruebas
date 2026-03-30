package org.example.tfgbackendpruebas.controller;

import org.example.tfgbackendpruebas.dto.response.EstadisticasResponse;
import org.example.tfgbackendpruebas.service.EstadisticasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/estadisticas")
public class EstadisticasController {

    @Autowired private EstadisticasService estadisticasService;

    @GetMapping
    public ResponseEntity<EstadisticasResponse> getEstadisticas() {
        return ResponseEntity.ok(estadisticasService.getEstadisticas());
    }
}