package com.jonathanrene.act3_t4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonathanrene.act3_t4.model.Escuela;
import com.jonathanrene.act3_t4.repository.EscuelaRepository;

@Service
public class EscuelaService {
    @Autowired
    private EscuelaRepository escuelaRepository;

    public List<Escuela> listarTodas() { return escuelaRepository.findAll(); }
    public Escuela guardar(Escuela escuela) { return escuelaRepository.save(escuela); }
    public Escuela obtenerPorId(Long id) { return escuelaRepository.findById(id).orElse(null); }
    public void eliminar(Long id) { escuelaRepository.deleteById(id); }
}