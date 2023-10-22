package com.api.jjSystem.controllers;

import com.api.jjSystem.models.TipoPQRSF;
import com.api.jjSystem.services.TipoPQRSFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api.jjSystem/tipoPqrsf")
public class TipoPQRSFController {

    @Autowired
    private TipoPQRSFService tipoPQRSFService;

    @PostMapping
    public TipoPQRSF createTipo (TipoPQRSF tipoPQRSF)
    {
        return tipoPQRSFService.createTipo(tipoPQRSF);
    }

    @GetMapping
    public List<TipoPQRSF> getAllTipos ()
    {
        return tipoPQRSFService.getAllTipos();
    }

    @GetMapping("{id}")
    public TipoPQRSF buscarTipoById (@PathVariable Integer id)
    {
        return tipoPQRSFService.getTipoById(id);
    }

    @DeleteMapping("{id}")
    public void deleteTipoById (@PathVariable("id") Integer id)
    {
        tipoPQRSFService.deleteTipo(id);
    }

}
