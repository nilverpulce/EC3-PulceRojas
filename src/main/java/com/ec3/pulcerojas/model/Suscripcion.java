package com.ec3.pulcerojas.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "suscripciones")
public class Suscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "alumno_id", nullable = false)
    private Alumno alumno;

    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double monto;
}