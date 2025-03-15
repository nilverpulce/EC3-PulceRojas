package com.ec3.pulcerojas.service;

import com.ec3.pulcerojas.dto.EntrenadorDTO;
import com.ec3.pulcerojas.model.Entrenador;
import java.util.List;

public interface EntrenadorService {
    Entrenador guardar(EntrenadorDTO entrenadorDTO);
    List<Entrenador> listar();
    Entrenador obtenerPorId(Long id);
    Entrenador actualizar(Long id, EntrenadorDTO entrenadorDTO);
    boolean eliminar(Long id);
}