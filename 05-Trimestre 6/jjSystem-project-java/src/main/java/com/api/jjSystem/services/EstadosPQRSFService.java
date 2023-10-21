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

    public EstadosPQRSF createEstadoPQRSF (EstadosPQRSF estadoPQRSF)
    {
        return estadosPQRSFRepository.save(estadoPQRSF);
    }

    public EstadosPQRSF getEstadoPQRSFById(Integer idEstadoPQRSF)
    {
        Optional<EstadosPQRSF> optionalEstadosPQRSF = estadosPQRSFRepository.findById(idEstadoPQRSF);
        return optionalEstadosPQRSF.get();
    }

        public List<EstadosPQRSF> getAllEstadosPQRSF()
        {
            return estadosPQRSFRepository.findAll();
    }

    public void deleteEstadosPQRSF(Integer idEstadoPQRSF)
    {
        estadosPQRSFRepository.deleteById(idEstadoPQRSF);
    }
}
