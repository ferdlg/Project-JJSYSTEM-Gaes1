package com.api.jjSystem.controllers;

import com.api.jjSystem.models.DetallesActividadCronograma;
import com.api.jjSystem.services.DetallesActividadCronogramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api.jjSystem/detallessActividad")
public class DetallesActividadCronogramaController {
    @Autowired
    private DetallesActividadCronogramaService detallesActividadCronogramaService;
    @PostMapping
    public DetallesActividadCronograma createDetalle(DetallesActividadCronograma detallesActividadCronograma)
    {
        return detallesActividadCronogramaService.createDetalle(detallesActividadCronograma);
    }
    @GetMapping
    public List<DetallesActividadCronograma> getAllDetalle()
    {
        return detallesActividadCronogramaService.getAllDetalle();
    }
    @GetMapping("{idDetalleActividad}")
    public DetallesActividadCronograma getDetalleById(@PathVariable Integer idDetalleActividad)
    {
        return detallesActividadCronogramaService.getDetalleByid(idDetalleActividad);
    }
    @DeleteMapping("{idDetalleActividad}")
    public void deleteDetalleById(@PathVariable("idDetalleActividad") Integer idDetalleActividad)
    {
        detallesActividadCronogramaService.deleteDetalleById(idDetalleActividad);    }
}
