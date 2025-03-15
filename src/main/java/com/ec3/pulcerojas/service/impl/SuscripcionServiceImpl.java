package com.ec3.pulcerojas.service.impl;

import com.ec3.pulcerojas.model.Suscripcion;
import com.ec3.pulcerojas.repository.SuscripcionRepository;
import com.ec3.pulcerojas.service.SuscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuscripcionServiceImpl implements SuscripcionService {

    @Autowired
    private SuscripcionRepository suscripcionRepository;

    @Override
    public Suscripcion guardar(Suscripcion suscripcion) {
        return suscripcionRepository.save(suscripcion);
    }

    @Override
    public List<Suscripcion> listar() {
        return suscripcionRepository.findAll();
    }

    @Override
    public Suscripcion obtenerPorId(Long id) {
        return suscripcionRepository.findById(id).orElse(null);
    }
}
