package com.ec3.pulcerojas.controller;

import com.ec3.pulcerojas.dto.SuscripcionDTO;
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
    public Suscripcion guardar(@RequestBody SuscripcionDTO suscripcionDTO) {
        return suscripcionService.guardar(suscripcionDTO);
    }

    @GetMapping
    public List<Suscripcion> listar() {
        return suscripcionService.listar();
    }

    @GetMapping("/{id}")
    public Suscripcion obtenerPorId(@PathVariable Long id) {
        return suscripcionService.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public Suscripcion actualizar(@PathVariable Long id, @RequestBody SuscripcionDTO suscripcionDTO) {
        return suscripcionService.actualizar(id, suscripcionDTO);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        boolean eliminado = suscripcionService.eliminar(id);
        if (eliminado) {
            return "Suscripción eliminada correctamente";
        } else {
            return "No se encontró la suscripción";
        }
    }
}