package com.centotec.app.lab6.controller;

import com.centotec.app.lab6.domain.Persona;
import com.centotec.app.lab6.service.PersonaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.Instant;
import java.util.Date;

@Controller
public class PersonaController {

    @Autowired
    PersonaServiceImpl personaService;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("persona", personaService.getAll());
        return "index";
    }

    @RequestMapping(value = "/agregarEntrada", method = RequestMethod.GET)
    public String navegarPaginaInsertar(Model model){
        Persona persona = new Persona();

        model.addAttribute("persona",persona);
        return "agregarEntrada";
    }

    @RequestMapping(value = "/agregarEntrada", method = RequestMethod.POST)
    public String accionPaginaInsertar(Persona persona, BindingResult result, Model model){
        persona.setdNacimineto(Date.from(Instant.now()));
        personaService.savePersona(persona);
        return "agregarEntrada";
    }

    @RequestMapping(value = "/modificar", method = RequestMethod.GET)
    public String navegarPaginaModificar(Model model){
        Persona persona = new Persona();
        model.addAttribute("persona",persona);
        return "modificarPersona";
    }

}