package com.ec3.pulcerojas.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class ClaseDTO {
    @NotBlank(message = "La descripción es obligatoria")
    private String descripcion;

    @NotNull(message = "La fecha de la clase es obligatoria")
    @Future(message = "La fecha de la clase debe ser en el futuro")
    private LocalDateTime fecha;

    @NotNull(message = "El ID del entrenador es obligatorio")
    private Long entrenadorId;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Long getEntrenadorId() {
        return entrenadorId;
    }

    public void setEntrenadorId(Long entrenadorId) {
        this.entrenadorId = entrenadorId;
    }
}
