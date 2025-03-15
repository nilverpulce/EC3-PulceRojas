package com.ec3.pulcerojas.service.impl;

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
    public Entrenador guardar(Entrenador entrenador) {
        return entrenadorRepository.save(entrenador);
    }

    @Override
    public List<Entrenador> listar() {
        return entrenadorRepository.findAll();
    }

    @Override
    public Entrenador obtenerPorId(Long id) {
        return entrenadorRepository.findById(id).orElse(null);
    }
}
