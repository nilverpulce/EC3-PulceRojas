package com.ec3.pulcerojas.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "entrenadores")
public class Entrenador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String especialidad;
    private String telefono;

    @OneToMany(mappedBy = "entrenador", cascade = CascadeType.ALL)
    private List<Clase> clases;
}