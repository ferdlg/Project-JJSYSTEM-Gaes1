package com.api.jjSystem.controllers;

import com.api.jjSystem.models.DisponibilidadCronogramas;
import com.api.jjSystem.services.DisponibilidadCronogramasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api.jjSystem/disponibilidad")
public class DisponibilidadCronogramasController {
    @Autowired
    private DisponibilidadCronogramasService disponibilidadCronogramasService;
    @PostMapping
    public DisponibilidadCronogramas createDisponibilidad(DisponibilidadCronogramas disponibilidadCronogramas)
    {
        return disponibilidadCronogramasService.createDisponibilidad(disponibilidadCronogramas);
    }
    @GetMapping
    public List<DisponibilidadCronogramas> getAllDisponibilidad()
    {
        return disponibilidadCronogramasService.getAllDisponibilidad();
    }
    @GetMapping("{idDisponibilidadCronograma}")
    public DisponibilidadCronogramas getDisponibilidadById(Integer idDisponibilidadCronograma)
    {
        return disponibilidadCronogramasService.getDisponibilidadById(idDisponibilidadCronograma);
    }
    @DeleteMapping("{idDisponibilidadCronograma}")
    public void deleteDisponibilidadById(@PathVariable("idDisponibilidadCronograma")Integer idDisponibilidadCronograma)
    {
        disponibilidadCronogramasService.deleteDisponibilidadById(idDisponibilidadCronograma);
    }
}
