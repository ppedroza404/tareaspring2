package com.centotec.app.lab6.service;

import com.centotec.app.lab6.domain.Persona;
import com.centotec.app.lab6.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    PersonaRepository personaRepository;
    @Override
    public void savePersona(Persona persona){
        personaRepository.save(persona);
    }
    @Override
    public List<Persona> getAll(){
        return personaRepository.findAll();
    }
}
