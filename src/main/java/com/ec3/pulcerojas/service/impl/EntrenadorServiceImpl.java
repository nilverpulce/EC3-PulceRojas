package com.ec3.pulcerojas.service.impl;

import com.ec3.pulcerojas.dto.EntrenadorDTO;
import com.ec3.pulcerojas.model.Entrenador;
import com.ec3.pulcerojas.repository.EntrenadorRepository;
import com.ec3.pulcerojas.service.EntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrenadorServiceImpl implements EntrenadorService {

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    @Override
    public Entrenador guardar(EntrenadorDTO entrenadorDTO) {
        if (entrenadorRepository.existsByTelefono(entrenadorDTO.getTelefono())) {
            throw new RuntimeException("El teléfono ya está registrado");
        }

        Entrenador entrenador = new Entrenador();
        entrenador.setNombre(entrenadorDTO.getNombre());
        entrenador.setEspecialidad(entrenadorDTO.getEspecialidad());
        entrenador.setTelefono(entrenadorDTO.getTelefono());

        return entrenadorRepository.save(entrenador);
    }

    @Override
    public List<Entrenador> listar() {
        return entrenadorRepository.findAll();
    }

    @Override
    public Entrenador obtenerPorId(Long id) {
        return entrenadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrenador no encontrado"));
    }

    @Override
    public Entrenador actualizar(Long id, EntrenadorDTO entrenadorDTO) {
        Entrenador entrenador = obtenerPorId(id);

        entrenador.setNombre(entrenadorDTO.getNombre());
        entrenador.setEspecialidad(entrenadorDTO.getEspecialidad());
        entrenador.setTelefono(entrenadorDTO.getTelefono());

        return entrenadorRepository.save(entrenador);
    }

    @Override
    public boolean eliminar(Long id) {
        Entrenador entrenador = obtenerPorId(id);
        entrenadorRepository.delete(entrenador);
        return true;
    }
}