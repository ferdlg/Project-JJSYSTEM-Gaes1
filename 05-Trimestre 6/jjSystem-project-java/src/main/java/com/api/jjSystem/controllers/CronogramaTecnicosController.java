package com.api.jjSystem.controllers;

import com.api.jjSystem.models.CronogramaTecnicos;
import com.api.jjSystem.services.CronogramaTecnicosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api.jjSystem/cronograma")
public class CronogramaTecnicosController {
    @Autowired
    private CronogramaTecnicosService cronogramaTecnicosService;
    @PostMapping
    public CronogramaTecnicos createCronograma(CronogramaTecnicos cronogramaTecnicos)
    {
        return cronogramaTecnicosService.createCronograma(cronogramaTecnicos);
    }
    @GetMapping
    public List<CronogramaTecnicos> getAllCronograma()
    {
        return cronogramaTecnicosService.getAllCronograma();
    }
    @GetMapping("{idCronogramaTecnico}")
    public CronogramaTecnicos getCronogramaById(@PathVariable Integer idCronogramaTecnico)
    {
        return cronogramaTecnicosService.getCronogramaById(idCronogramaTecnico);
    }
    @DeleteMapping("{idCronogramaTecnico}")
    public void deleteCronogramaById(@PathVariable("idCronogramaTecnico") Integer idCronogramaTecnico)
    {
        cronogramaTecnicosService.deleteCronogramaById(idCronogramaTecnico);
    }

}
