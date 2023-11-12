package com.api.jjSystem.controllers;

import com.api.jjSystem.models.ActividadesCronogramaTecnicos;
import com.api.jjSystem.services.ActividadesCronogramaTecnicosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api.jjSystem/actividadesCronogramaTecnicos")
public class ActividadesCronogramaTecnicosController {
    @Autowired
    private ActividadesCronogramaTecnicosService actividadesCronogramaTecnicosService;
    @PostMapping
    public ActividadesCronogramaTecnicos createActidadesTecnicos(ActividadesCronogramaTecnicos actividadesCronogramaTecnicos)
    {
        return actividadesCronogramaTecnicosService.createActividadesTecnicos(actividadesCronogramaTecnicos);
    }
    @GetMapping
    public List<ActividadesCronogramaTecnicos> getAllActidadesTecnicos()
    {
        return actividadesCronogramaTecnicosService.getAllActidadesTecnicos();
    }
    @GetMapping("{idActividadCronogramaTecnico}")
    public ActividadesCronogramaTecnicos getActividadesTecnicosById(@PathVariable Integer idActividadCronogramaTecnico)
    {
        return actividadesCronogramaTecnicosService.getActidadesTecnicosById(idActividadCronogramaTecnico);
    }

    @DeleteMapping("{idActividadCronogramaTecnico}")
    public void deleteActidadesTecnicosById(@PathVariable("idActividadCronogramaTecnico")Integer idActividadCronogramaTecnico)
    {
        actividadesCronogramaTecnicosService.deleteActidadesTecnicos(idActividadCronogramaTecnico);
    }
}
