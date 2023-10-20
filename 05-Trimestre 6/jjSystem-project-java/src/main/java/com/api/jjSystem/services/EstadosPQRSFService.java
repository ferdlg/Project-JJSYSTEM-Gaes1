package com.api.jjSystem.services;

import com.api.jjSystem.Repository.EstadosPQRSFRepository;
import com.api.jjSystem.models.EstadosPQRSF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EstadosPQRSFService {

    @Autowired
    private EstadosPQRSFRepository estadosPQRSFRepository;

    public EstadosPQRSF createEstadosPQRSF (EstadosPQRSF estadosPQRSF)
    {
        return estadosPQRSFRepository.save(estadosPQRSF);
    }

    public EstadosPQRSF getEstadosPQRSFById(Integer idPQRSF)
    {
        Optional<EstadosPQRSF> optionalEstadoPQRSF = estadosPQRSFRepository.findById(idPQRSF);
        return optionalEstadoPQRSF.get();
    }

    public List<EstadosPQRSF> getAllEstadosPQRSF()
    {
        return estadosPQRSFRepository.findAll();
    }

    public void deleteEstadosPQRSF(Integer id)
    {
        estadosPQRSFRepository.deleteById(id);
    }
}
