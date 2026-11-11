package com.jonathanrene.act3_t4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonathanrene.act3_t4.model.Escuela;
import com.jonathanrene.act3_t4.service.EscuelaService;

@RestController
@RequestMapping("/api/escuelas")
public class EscuelaController {

    @Autowired
    private EscuelaService escuelaService;

    // LEER TODAS (C - R - U - D)
    @GetMapping
    public List<Escuela> listarTodas() {
        return escuelaService.listarTodas();
    }

    // CREAR (C - R - U - D)
    @PostMapping
    public Escuela crearEscuela(@RequestBody Escuela escuela) {
        return escuelaService.guardar(escuela);
    }
}