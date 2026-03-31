package org.example.tfgbackendpruebas.dto.request;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ValoracionRequest {
    @NotNull private Long reparacionId;
    @NotNull @Min(1) @Max(5) private Short puntuacion;
    private String comentario;

    public Long getReparacionId() { return reparacionId; }
    public void setReparacionId(Long reparacionId) { this.reparacionId = reparacionId; }
    public Short getPuntuacion() { return puntuacion; }
    public void setPuntuacion(Short puntuacion) { this.puntuacion = puntuacion; }
    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }
}