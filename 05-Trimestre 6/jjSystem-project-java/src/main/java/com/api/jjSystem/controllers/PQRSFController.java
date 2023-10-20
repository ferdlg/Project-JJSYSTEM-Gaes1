package com.api.jjSystem.controllers;

import com.api.jjSystem.models.PQRSF;
import com.api.jjSystem.services.PQRSFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api.jjsystem/PQRSF")
public class PQRSFController {

    @Autowired
    private PQRSFService pqrsfService;

    @PostMapping
    public PQRSF createPQRSF (PQRSF pqrsf)
    {
        return pqrsfService.createPQRSF(pqrsf);
    }

    @GetMapping
    public List<PQRSF> getAllPQRSF ()
    {
        return pqrsfService.getAllPQRSF();
    }

    @GetMapping("{id}")
    public PQRSF buscarPQRSFById (@PathVariable Integer id)
    {
        return pqrsfService.getPQRSFById(id);
    }

    @DeleteMapping("{id}")
    public void deletePQRSFById (@PathVariable("id") Integer id)
    {
        pqrsfService.deletePQRSF(id);
    }
}
