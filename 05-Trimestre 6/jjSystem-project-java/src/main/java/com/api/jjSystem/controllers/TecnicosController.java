package com.api.jjSystem.controllers;

import com.api.jjSystem.models.Tecnicos;
import com.api.jjSystem.services.TecnicosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api.jjSystem/tecnicos")
public class TecnicosController {
    @Autowired
    private TecnicosService tecnicosService;
    @PostMapping
    public Tecnicos createTecnicos(Tecnicos tecnicos)
    {
        return tecnicosService.createTecnico(tecnicos);
    }
    @GetMapping
    public List<Tecnicos> getAllTecnicos()
    {
        return tecnicosService.getAllTecnicos();
    }
    @GetMapping("{idTecnico}")
    public Tecnicos getTecnicosById(Integer idTecnico)
    {
     return tecnicosService.getTecnicoById(idTecnico);
    }
    @DeleteMapping("{idTecnico}")
    public void deleteTecnicoById(Integer idTecnico)
    {
        tecnicosService.deleteTecnicosById(idTecnico);
    }
}
