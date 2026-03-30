package org.example.tfgbackendpruebas.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class VehiculoRequest {
    @NotNull  private Long clienteId;
    @NotBlank private String marca;
    @NotBlank private String modelo;
    @NotNull  private short anio;
    @NotBlank private String matricula;
    private int kilometraje = 0;
}