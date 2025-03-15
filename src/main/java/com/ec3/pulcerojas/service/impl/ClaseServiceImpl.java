package com.ec3.pulcerojas.service.impl;

import com.ec3.pulcerojas.model.Clase;
import com.ec3.pulcerojas.repository.ClaseRepository;
import com.ec3.pulcerojas.service.ClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaseServiceImpl implements ClaseService {

    @Autowired
    private ClaseRepository claseRepository;

    @Override
    public Clase guardar(Clase clase) {
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
}
