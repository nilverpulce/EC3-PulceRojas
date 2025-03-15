package com.ec3.pulcerojas.service;

import com.ec3.pulcerojas.model.Suscripcion;
import java.util.List;

public interface SuscripcionService {
    Suscripcion guardar(Suscripcion suscripcion);
    List<Suscripcion> listar();
    Suscripcion obtenerPorId(Long id);
}