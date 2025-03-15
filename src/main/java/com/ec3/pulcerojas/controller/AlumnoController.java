package com.ec3.pulcerojas.controller;

import com.ec3.pulcerojas.dto.AlumnoDTO;
import com.ec3.pulcerojas.model.Alumno;
import com.ec3.pulcerojas.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @PostMapping
    public Alumno guardar(@RequestBody AlumnoDTO alumnoDTO) {
        return alumnoService.guardar(alumnoDTO);
    }

    @GetMapping
    public List<Alumno> listar() {
        return alumnoService.listar();
    }

    @GetMapping("/{id}")
    public Alumno obtenerPorId(@PathVariable Long id) {
        return alumnoService.obtenerPorId(id);
    }
}