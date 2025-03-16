package com.ec3.pulcerojas.repository;

import com.ec3.pulcerojas.model.Clase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ClaseRepository extends JpaRepository<Clase, Long> {
    boolean existsByDescripcionAndFecha(String descripcion, LocalDateTime fecha);
}