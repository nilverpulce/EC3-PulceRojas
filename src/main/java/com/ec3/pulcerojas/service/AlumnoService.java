package com.ec3.pulcerojas.service;

import com.ec3.pulcerojas.dto.AlumnoDTO;
import com.ec3.pulcerojas.model.Alumno;
import java.util.List;

public interface AlumnoService {
    Alumno guardar(AlumnoDTO alumnoDTO);
    List<Alumno> listar();
    Alumno obtenerPorId(Long id);
    Alumno actualizar(Long id, AlumnoDTO alumnoDTO);
    boolean eliminar(Long id);
}
