package com.api.jjSystem.controllers;

import com.api.jjSystem.models.DetallesActividadCronograma;
import com.api.jjSystem.services.DetalleActividadCronogramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api.jjSystem/detalleActividad")
public class DetalleActividadCronogramaController {
    @Autowired
    private DetalleActividadCronogramaService detalleActividadCronogramaService;
    @PostMapping
    public DetallesActividadCronograma createDetalle(DetallesActividadCronograma detallesActividadCronograma)
    {
        return detalleActividadCronogramaService.createDetalle(detallesActividadCronograma);
    }
    @GetMapping
    public List<DetallesActividadCronograma> getAllDetalle()
    {
        return detalleActividadCronogramaService.getAllDetalle();
    }
    @GetMapping("{idDetalleActividad}")
    public DetallesActividadCronograma getDetalleById(@PathVariable Integer idDetalleActividad)
    {
        return detalleActividadCronogramaService.getDetalleByid(idDetalleActividad);
    }
    @DeleteMapping("{idDetalleActividad}")
    public void deleteDetalleById(@PathVariable("idDetalleActividad") Integer idDetalleActividad)
    {
        detalleActividadCronogramaService.deleteDetalleById(idDetalleActividad);    }
}
