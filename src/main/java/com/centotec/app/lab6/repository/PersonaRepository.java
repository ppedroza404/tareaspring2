package com.centotec.app.lab6.repository;

import com.centotec.app.lab6.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}

