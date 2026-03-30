package org.example.tfgbackendpruebas.dto.request;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ValoracionRequest {
    @NotNull private Long reparacionId;
    @Min(1) @Max(5) private short puntuacion;
    private String comentario;
}
