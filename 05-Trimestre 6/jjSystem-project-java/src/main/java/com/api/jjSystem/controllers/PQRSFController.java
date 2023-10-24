package com.api.jjSystem.controllers;

import com.api.jjSystem.models.PQRSF;
import com.api.jjSystem.services.PQRSFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api.jjSystem/pqrsf")
public class PQRSFController {

    @Autowired
    private PQRSFService pqrsfService;

    @PostMapping
    public PQRSF createPQRSF(PQRSF pqrsf)
    {
        return pqrsfService.createPQRSF(pqrsf);
    }

    @GetMapping
    public List<PQRSF> getAllPQRSF()
    {
        return pqrsfService.getAllPQRSF();
    }

    @GetMapping("{idPQRSF}")
    public PQRSF buscarPQRSFById(@PathVariable Integer id)
    {
        return pqrsfService.getPQRSFById(id);
    }

    @DeleteMapping("{idPQRSF}")
    public void deletePQRSFById(@PathVariable("idPQRSF") Integer idPQRSF)
    {
        pqrsfService.deletePQRSF(idPQRSF);
    }
}
