package com.api.jjSystem.controllers;

import com.api.jjSystem.models.Respuestas;
import com.api.jjSystem.services.RespuestasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api.jjSystem/respuestas")
public class RespuestasController {

    @Autowired
    private RespuestasService respuestasService;

    @PostMapping
    public Respuestas createRespuesta(Respuestas respuestas)
    {
        return respuestasService.createRespuesta(respuestas);
    }

    @GetMapping
    public List<Respuestas> getAllRespuestas()
    {
        return respuestasService.getAllRespuestas();
    }

    @GetMapping("{idRespuesta}")
    public Respuestas buscarRespuestasById(@PathVariable Integer idRespuesta)
    {
        return respuestasService.getRespuestaById(idRespuesta);
    }

    @DeleteMapping("{idRespuesta}")
    public void deleteRespuestaById(@PathVariable("idRespuesta") Integer idRespuesta)
    {
        respuestasService.deleteRespuestas(idRespuesta);
    }

}
