package com.jonathanrene.act3_t4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonathanrene.act3_t4.model.Alumno;
import com.jonathanrene.act3_t4.repository.AlumnoRepository;

@Service
public class AlumnoService {
    @Autowired
    private AlumnoRepository alumnoRepository;

    public List<Alumno> listarTodos() { return alumnoRepository.findAll(); }
    public Alumno guardar(Alumno alumno) { return alumnoRepository.save(alumno); }
    public Alumno obtenerPorId(Long id) { return alumnoRepository.findById(id).orElse(null); }
    public void eliminar(Long id) { alumnoRepository.deleteById(id); }
}