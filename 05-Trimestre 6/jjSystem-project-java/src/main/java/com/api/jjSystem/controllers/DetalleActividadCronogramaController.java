package com.api.jjSystem.controllers;

import com.api.jjSystem.models.DetalleActividadCronograma;
import com.api.jjSystem.services.CronogramaTecnicosService;
import com.api.jjSystem.services.DetalleActividadCronogramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping
public class DetalleActividadCronogramaController {
    @Autowired
    private DetalleActividadCronogramaService detalleActividadCronogramaService;
    @PostMapping
    public DetalleActividadCronograma createDetalle(DetalleActividadCronograma detalleActividadCronograma)
    {
        return detalleActividadCronogramaService.createDetalle(detalleActividadCronograma);
    }
    @GetMapping
    public List<DetalleActividadCronograma> getAllDetalle()
    {
        return detalleActividadCronogramaService.getAllDetalle();
    }
    @GetMapping("{idDetalleActividad}")
    public DetalleActividadCronograma getDetalleById(@PathVariable Integer idDetalleActividad)
    {
        return detalleActividadCronogramaService.getDetalleByid(idDetalleActividad);
    }
    @DeleteMapping("{idDetalleActividad}")
    public void deleteDetalleById(@PathVariable("idDetalleActividad") Integer idDetalleActividad)
    {
        detalleActividadCronogramaService.deleteDetalleById(idDetalleActividad);    }
}
