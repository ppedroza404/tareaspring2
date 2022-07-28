package com.centotec.app.lab6.service;

import com.centotec.app.lab6.domain.Persona;

import java.util.List;

public interface PersonaService {
    void savePersona(Persona persona);
    void deletePersona(Persona persona);
    List<Persona> getAll();
}
