package com.ec3.pulcerojas.service.impl;

import com.ec3.pulcerojas.dto.ClaseDTO;
import com.ec3.pulcerojas.model.Clase;
import com.ec3.pulcerojas.model.Entrenador;
import com.ec3.pulcerojas.repository.ClaseRepository;
import com.ec3.pulcerojas.repository.EntrenadorRepository;
import com.ec3.pulcerojas.service.ClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaseServiceImpl implements ClaseService {

    @Autowired
    private ClaseRepository claseRepository;

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    @Override
    public Clase guardar(ClaseDTO claseDTO) {
        if (claseRepository.existsByDescripcionAndFecha(claseDTO.getDescripcion(), claseDTO.getFecha())) {
            throw new RuntimeException("Ya existe una clase con esta descripción en la misma fecha");
        }

        Entrenador entrenador = entrenadorRepository.findById(claseDTO.getEntrenadorId())
                .orElseThrow(() -> new RuntimeException("Entrenador no encontrado"));

        Clase clase = new Clase();
        clase.setDescripcion(claseDTO.getDescripcion());
        clase.setFecha(claseDTO.getFecha());
        clase.setEntrenador(entrenador);

        return claseRepository.save(clase);
    }

    @Override
    public List<Clase> listar() {
        return claseRepository.findAll();
    }

    @Override
    public Clase obtenerPorId(Long id) {
        return claseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Clase no encontrada"));
    }

    @Override
    public Clase actualizar(Long id, ClaseDTO claseDTO) {
        Clase clase = obtenerPorId(id);

        Entrenador entrenador = entrenadorRepository.findById(claseDTO.getEntrenadorId())
                .orElseThrow(() -> new RuntimeException("Entrenador no encontrado"));

        clase.setDescripcion(claseDTO.getDescripcion());
        clase.setFecha(claseDTO.getFecha());
        clase.setEntrenador(entrenador);

        return claseRepository.save(clase);
    }

    @Override
    public boolean eliminar(Long id) {
        Clase clase = obtenerPorId(id);
        claseRepository.delete(clase);
        return true;
    }
}