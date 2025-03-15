package com.ec3.pulcerojas.controller;

import com.ec3.pulcerojas.model.Clase;
import com.ec3.pulcerojas.service.ClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clases")
public class ClaseController {

    @Autowired
    private ClaseService claseService;

    @PostMapping
    public Clase guardar(@RequestBody Clase clase) {
        return claseService.guardar(clase);
    }

    @GetMapping
    public List<Clase> listar() {
        return claseService.listar();
    }

    @GetMapping("/{id}")
    public Clase obtenerPorId(@PathVariable Long id) {
        return claseService.obtenerPorId(id);
    }
}
