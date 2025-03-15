package com.ec3.pulcerojas.controller;

import com.ec3.pulcerojas.model.Suscripcion;
import com.ec3.pulcerojas.service.SuscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suscripciones")
public class SuscripcionController {

    @Autowired
    private SuscripcionService suscripcionService;

    @PostMapping
    public Suscripcion guardar(@RequestBody Suscripcion suscripcion) {
        return suscripcionService.guardar(suscripcion);
    }

    @GetMapping
    public List<Suscripcion> listar() {
        return suscripcionService.listar();
    }

    @GetMapping("/{id}")
    public Suscripcion obtenerPorId(@PathVariable Long id) {
        return suscripcionService.obtenerPorId(id);
    }
}
