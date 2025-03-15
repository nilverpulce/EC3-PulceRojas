package com.ec3.pulcerojas.service;

import com.ec3.pulcerojas.dto.SuscripcionDTO;
import com.ec3.pulcerojas.model.Suscripcion;
import java.util.List;

public interface SuscripcionService {
    Suscripcion guardar(SuscripcionDTO suscripcionDTO);
    List<Suscripcion> listar();
    Suscripcion obtenerPorId(Long id);
    Suscripcion actualizar(Long id, SuscripcionDTO suscripcionDTO);
    boolean eliminar(Long id);
}