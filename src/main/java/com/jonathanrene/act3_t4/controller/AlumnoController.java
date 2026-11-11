package com.jonathanrene.act3_t4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonathanrene.act3_t4.model.Alumno;
import com.jonathanrene.act3_t4.model.Escuela;
import com.jonathanrene.act3_t4.service.AlumnoService;
import com.jonathanrene.act3_t4.service.EscuelaService;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;
    
    @Autowired
    private EscuelaService escuelaService;

    // 1. LEER (READ) - Obtener todos los alumnos (Muestra la relación con Escuela)
    @GetMapping
    public List<Alumno> listarTodos() {
        return alumnoService.listarTodos();
    }

    // 2. CREAR (CREATE) - Registrar un nuevo alumno
    @PostMapping
    public Alumno crearAlumno(@RequestBody Alumno alumno) {
        // Asegurarnos de que la escuela existe antes de guardar al alumno
        Escuela escuela = escuelaService.obtenerPorId(alumno.getEscuela().getId());
        if(escuela != null) {
            alumno.setEscuela(escuela);
            return alumnoService.guardar(alumno);
        }
        return null; 
    }

    // 3. ACTUALIZAR (UPDATE) - Modificar un alumno existente
    @PutMapping("/{id}")
    public Alumno actualizarAlumno(@PathVariable Long id, @RequestBody Alumno alumnoActualizado) {
        Alumno alumnoExistente = alumnoService.obtenerPorId(id);
        if (alumnoExistente != null) {
            alumnoExistente.setNombre(alumnoActualizado.getNombre());
            alumnoExistente.setMatricula(alumnoActualizado.getMatricula());
            
            Escuela nuevaEscuela = escuelaService.obtenerPorId(alumnoActualizado.getEscuela().getId());
            if(nuevaEscuela != null){
                alumnoExistente.setEscuela(nuevaEscuela);
            }
            return alumnoService.guardar(alumnoExistente);
        }
        return null;
    }

    // 4. ELIMINAR (DELETE) - Borrar un alumno
    @DeleteMapping("/{id}")
    public String eliminarAlumno(@PathVariable Long id) {
        alumnoService.eliminar(id);
        return "Alumno con ID " + id + " eliminado correctamente.";
    }
}