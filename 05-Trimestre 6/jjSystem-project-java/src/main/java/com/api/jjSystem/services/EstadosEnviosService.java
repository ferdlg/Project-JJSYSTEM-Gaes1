package com.api.jjSystem.services;

import com.api.jjSystem.Repository.EstadosEnviosRepository;
import com.api.jjSystem.models.EstadosEnvios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EstadosEnviosService {

    @Autowired
    private EstadosEnviosRepository estadosEnviosRepository;

    public EstadosEnvios createEstadoEnvio (EstadosEnvios estadoEnvio)
    {
        return estadosEnviosRepository.save(estadoEnvio);
    }

    public EstadosEnvios getEstadoEnvioById (Integer idEstadoEnvio)
    {
        Optional<EstadosEnvios> optionalEstadosEnvios = estadosEnviosRepository.findById(idEstadoEnvio);
        return optionalEstadosEnvios.get();
    }

    public List<EstadosEnvios> getAllEstadosEnvios()
    {
        return estadosEnviosRepository.findAll();
    }

    public void deleteEstadosEnvios(Integer idEstadoEnvio)
    {
        estadosEnviosRepository.deleteById(idEstadoEnvio);
    }
}
