package com.ec3.pulcerojas.service;

import com.ec3.pulcerojas.dto.ClaseDTO;
import com.ec3.pulcerojas.model.Clase;
import java.util.List;

public interface ClaseService {
    Clase guardar(ClaseDTO claseDTO);
    List<Clase> listar();
    Clase obtenerPorId(Long id);
    Clase actualizar(Long id, ClaseDTO claseDTO);
    boolean eliminar(Long id);
}