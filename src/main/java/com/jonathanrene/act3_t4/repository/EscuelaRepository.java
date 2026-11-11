package com.jonathanrene.act3_t4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jonathanrene.act3_t4.model.Escuela;

@Repository
public interface EscuelaRepository extends JpaRepository<Escuela, Long> {
}