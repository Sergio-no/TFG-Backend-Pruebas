package org.example.tfgbackendpruebas.dto.request;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ValoracionRequest {
    @NotNull private Long reparacionId;
    @NotNull @Min(1) @Max(5) private Short puntuacion; // cambia short por Short
    private String comentario;
}
