package com.ec3.pulcerojas.controller;

import com.ec3.pulcerojas.dto.ClaseDTO;
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
    public Clase guardar(@RequestBody ClaseDTO claseDTO) {
        return claseService.guardar(claseDTO);
    }

    @GetMapping
    public List<Clase> listar() {
        return claseService.listar();
    }

    @GetMapping("/{id}")
    public Clase obtenerPorId(@PathVariable Long id) {
        return claseService.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public Clase actualizar(@PathVariable Long id, @RequestBody ClaseDTO claseDTO) {
        return claseService.actualizar(id, claseDTO);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        boolean eliminado = claseService.eliminar(id);
        if (eliminado) {
            return "Clase eliminada correctamente";
        } else {
            return "No se encontró la clase";
        }
    }
}
