package com.ec3.pulcerojas.service;

import com.ec3.pulcerojas.model.Clase;
import java.util.List;

public interface ClaseService {
    Clase guardar(Clase clase);
    List<Clase> listar();
    Clase obtenerPorId(Long id);
}