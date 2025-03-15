package com.ec3.pulcerojas.repository;

import com.ec3.pulcerojas.model.Entrenador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrenadorRepository extends JpaRepository<Entrenador, Long> {
}