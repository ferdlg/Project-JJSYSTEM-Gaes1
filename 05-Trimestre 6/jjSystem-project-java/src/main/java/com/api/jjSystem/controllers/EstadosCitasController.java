package com.api.jjSystem.controllers;

import com.api.jjSystem.models.EstadosCitas;
import com.api.jjSystem.services.EstadosCitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api.jjSystem/estadosCitas")
public class EstadosCitasController {
    @Autowired
    private EstadosCitasService estadosCitasService;
    @PostMapping
    public EstadosCitas createCitas(EstadosCitas estadosCitas)
    {
        return estadosCitasService.createEstado(estadosCitas);
    }
    @GetMapping
    public List<EstadosCitas> getAllEstados()
    {
        return estadosCitasService.getAllEstados();
    }
    @GetMapping("idEstadoCita")
    public EstadosCitas getEstadosById(Integer idEstadoCita)
    {
        return estadosCitasService.getEstadoByid(idEstadoCita);
    }
    @DeleteMapping("idEstadoCita")
    public void deleteEstadoById(@PathVariable("idEstadoCita") Integer idEstadoCita)
    {
        estadosCitasService.deleteEstadoById(idEstadoCita);
    }
}
