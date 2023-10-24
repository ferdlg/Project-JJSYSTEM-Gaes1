package com.api.jjSystem.controllers;

import com.api.jjSystem.models.Citas;
import com.api.jjSystem.services.CitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api.jjSystem/citas")
public class CitasController {
    @Autowired
    private CitasService citasService;
    @PostMapping
    public Citas createCitas(Citas citas)
    {
        return citasService.createCita(citas);
    }
    @GetMapping
    public List<Citas> getAllCitas()
    {
        return citasService.getAllCita();
    }
    @GetMapping("idCita")
    public Citas getCitasById(@PathVariable Integer idCita)
    {
        return citasService.getCitaById(idCita);
    }
    @DeleteMapping("idCita")
    public void deleteCitasById(@PathVariable("idCita") Integer idCita)
    {
        citasService.deleteCitaById(idCita);
    }
}
