package com.jonathanrene.act3_t4.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "alumnos")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String matricula;

    // Relación: Muchos alumnos pertenecen a una escuela
    @ManyToOne
    @JoinColumn(name = "escuela_id", nullable = false) // Esta será la llave foránea en MySQL
    private Escuela escuela;

    // Constructor vacío exigido por JPA
    public Alumno() {}

    public Alumno(String nombre, String matricula, Escuela escuela) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.escuela = escuela;
    }

    // --- GETTERS Y SETTERS ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }
    
    public Escuela getEscuela() { return escuela; }
    public void setEscuela(Escuela escuela) { this.escuela = escuela; }
}