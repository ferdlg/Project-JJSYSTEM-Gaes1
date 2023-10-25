package com.api.jjSystem.controllers;

import com.api.jjSystem.models.TiposPQRSF;
import com.api.jjSystem.services.TiposPQRSFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api.jjSystem/tiposPQRSF")

public class TiposPQRSFController {

    @Autowired
    private TiposPQRSFService tiposPQRSFService;

    @PostMapping
    public TiposPQRSF createTipoPQRSF(TiposPQRSF tiposPQRSF)
    {
        return tiposPQRSFService.createTipoPQRSF(tiposPQRSF);
    }

    @GetMapping
    public List<TiposPQRSF> getAllTiposPQRSF ()
    {
        return tiposPQRSFService.getAllTiposPQRSF();
    }

    @GetMapping("{idTipoPQRSF}")
    public TiposPQRSF buscarTiposPQRSFById (@PathVariable Integer idTipoPQRSF)
    {
        return tiposPQRSFService.getTipoPQRSFById(idTipoPQRSF);
    }

    @DeleteMapping("{idTipoPQRSF}")
    public void deleteTipoPQRSFById (@PathVariable("idTipoPQRSF") Integer idTipoPQRSF)
    {
        tiposPQRSFService.deleteTiposPQRSF(idTipoPQRSF);
    }

}
