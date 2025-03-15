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
        Entrenador entrenador = entrenadorRepository.findById(claseDTO.getEntrenadorId()).orElse(null);
        if (entrenador == null) {
            throw new RuntimeException("Entrenador no encontrado");
        }

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
        return claseRepository.findById(id).orElse(null);
    }

    @Override
    public Clase actualizar(Long id, ClaseDTO claseDTO) {
        Clase clase = obtenerPorId(id);
        if (clase != null) {
            Entrenador entrenador = entrenadorRepository.findById(claseDTO.getEntrenadorId()).orElse(null);
            if (entrenador == null) {
                throw new RuntimeException("Entrenador no encontrado");
            }
            clase.setDescripcion(claseDTO.getDescripcion());
            clase.setFecha(claseDTO.getFecha());
            clase.setEntrenador(entrenador);
            return claseRepository.save(clase);
        }
        return null;
    }

    @Override
    public boolean eliminar(Long id) {
        Clase clase = obtenerPorId(id);
        if (clase != null) {
            claseRepository.delete(clase);
            return true;
        }
        return false;
    }
}