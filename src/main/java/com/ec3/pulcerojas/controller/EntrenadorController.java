package com.ec3.pulcerojas.controller;

import com.ec3.pulcerojas.dto.EntrenadorDTO;
import com.ec3.pulcerojas.model.Entrenador;
import com.ec3.pulcerojas.service.EntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entrenadores")
public class EntrenadorController {

    @Autowired
    private EntrenadorService entrenadorService;

    @PostMapping
    public Entrenador guardar(@RequestBody EntrenadorDTO entrenadorDTO) {
        return entrenadorService.guardar(entrenadorDTO);
    }

    @GetMapping
    public List<Entrenador> listar() {
        return entrenadorService.listar();
    }

    @GetMapping("/{id}")
    public Entrenador obtenerPorId(@PathVariable Long id) {
        return entrenadorService.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public Entrenador actualizar(@PathVariable Long id, @RequestBody EntrenadorDTO entrenadorDTO) {
        return entrenadorService.actualizar(id, entrenadorDTO);
    }
}