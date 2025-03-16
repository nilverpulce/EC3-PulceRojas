package com.ec3.pulcerojas.service.impl;

import com.ec3.pulcerojas.dto.SuscripcionDTO;
import com.ec3.pulcerojas.model.Alumno;
import com.ec3.pulcerojas.model.Suscripcion;
import com.ec3.pulcerojas.repository.AlumnoRepository;
import com.ec3.pulcerojas.repository.SuscripcionRepository;
import com.ec3.pulcerojas.service.SuscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuscripcionServiceImpl implements SuscripcionService {

    @Autowired
    private SuscripcionRepository suscripcionRepository;

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Override
    public Suscripcion guardar(SuscripcionDTO suscripcionDTO) {
        Alumno alumno = alumnoRepository.findById(suscripcionDTO.getAlumnoId())
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));

        Suscripcion suscripcion = new Suscripcion();
        suscripcion.setAlumno(alumno);
        suscripcion.setFechaInicio(suscripcionDTO.getFechaInicio());
        suscripcion.setFechaFin(suscripcionDTO.getFechaFin());
        suscripcion.setMonto(suscripcionDTO.getMonto());

        return suscripcionRepository.save(suscripcion);
    }

    @Override
    public List<Suscripcion> listar() {
        return suscripcionRepository.findAll();
    }

    @Override
    public Suscripcion obtenerPorId(Long id) {
        return suscripcionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Suscripción no encontrada"));
    }

    @Override
    public Suscripcion actualizar(Long id, SuscripcionDTO suscripcionDTO) {
        Suscripcion suscripcion = obtenerPorId(id);
        Alumno alumno = alumnoRepository.findById(suscripcionDTO.getAlumnoId())
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));

        suscripcion.setAlumno(alumno);
        suscripcion.setFechaInicio(suscripcionDTO.getFechaInicio());
        suscripcion.setFechaFin(suscripcionDTO.getFechaFin());
        suscripcion.setMonto(suscripcionDTO.getMonto());

        return suscripcionRepository.save(suscripcion);
    }

    @Override
    public boolean eliminar(Long id) {
        Suscripcion suscripcion = obtenerPorId(id);
        suscripcionRepository.delete(suscripcion);
        return true;
    }
}
