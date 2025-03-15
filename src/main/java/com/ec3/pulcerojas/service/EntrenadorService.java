package com.ec3.pulcerojas.service;

import com.ec3.pulcerojas.model.Entrenador;
import java.util.List;

public interface EntrenadorService {
    Entrenador guardar(Entrenador entrenador);
    List<Entrenador> listar();
    Entrenador obtenerPorId(Long id);
}