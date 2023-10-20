package com.api.jjSystem.services;

import com.api.jjSystem.Repository.EstadoPQRSFRepository;
import com.api.jjSystem.models.EstadoPQRSF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EstadoPQRSFService {

    @Autowired
    private EstadoPQRSFRepository estadoPQRSFRepository;

    public EstadoPQRSF createEstados (EstadoPQRSF estadoPQRSF)
    {
        return estadoPQRSFRepository.save(estadoPQRSF);
    }

    public EstadoPQRSF getEstadosByid (Integer id)
    {
        Optional<EstadoPQRSF> optionalEstadoPQRSF = estadoPQRSFRepository.findById(id);
        return optionalEstadoPQRSF.get();
    }

    public List<EstadoPQRSF> getAllEstados()
    {
        return estadoPQRSFRepository.findAll();
    }

    public void deleteEstados(Integer id)
    {
        estadoPQRSFRepository.deleteById(id);
    }
}
