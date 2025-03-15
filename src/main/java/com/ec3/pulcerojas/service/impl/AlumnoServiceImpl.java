package com.ec3.pulcerojas.service.impl;

import com.ec3.pulcerojas.dto.AlumnoDTO;
import com.ec3.pulcerojas.model.Alumno;
import com.ec3.pulcerojas.repository.AlumnoRepository;
import com.ec3.pulcerojas.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Override
    public Alumno guardar(AlumnoDTO alumnoDTO) {
        Alumno alumno = new Alumno();
        alumno.setNombre(alumnoDTO.getNombre());
        alumno.setApellidos(alumnoDTO.getApellidos());
        alumno.setFechaNacimiento(alumnoDTO.getFechaNacimiento());
        alumno.setDni(alumnoDTO.getDni());
        alumno.setTelefono(alumnoDTO.getTelefono());
        alumno.setEmail(alumnoDTO.getEmail());
        alumno.setDireccion(alumnoDTO.getDireccion());
        return alumnoRepository.save(alumno);
    }

    @Override
    public List<Alumno> listar() {
        return alumnoRepository.findAll();
    }

    @Override
    public Alumno obtenerPorId(Long id) {
        return alumnoRepository.findById(id).orElse(null);
    }

    @Override
    public Alumno actualizar(Long id, AlumnoDTO alumnoDTO) {
        Alumno alumno = obtenerPorId(id);
        if (alumno != null) {
            alumno.setNombre(alumnoDTO.getNombre());
            alumno.setApellidos(alumnoDTO.getApellidos());
            alumno.setFechaNacimiento(alumnoDTO.getFechaNacimiento());
            alumno.setDni(alumnoDTO.getDni());
            alumno.setTelefono(alumnoDTO.getTelefono());
            alumno.setEmail(alumnoDTO.getEmail());
            alumno.setDireccion(alumnoDTO.getDireccion());
            return alumnoRepository.save(alumno);
        }
        return null;
    }

    @Override
    public boolean eliminar(Long id) {
        Alumno alumno = obtenerPorId(id);
        if (alumno != null) {
            alumnoRepository.delete(alumno);
            return true;
        }
        return false;
    }
}
