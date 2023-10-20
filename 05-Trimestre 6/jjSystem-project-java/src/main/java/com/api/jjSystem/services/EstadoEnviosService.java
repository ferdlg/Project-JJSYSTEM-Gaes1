package com.api.jjSystem.services;

import com.api.jjSystem.Repository.EstadoEnviosRepository;
import com.api.jjSystem.Repository.EstadoPQRSFRepository;
import com.api.jjSystem.models.EstadoEnvios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EstadoEnviosService {

    @Autowired
    private EstadoEnviosRepository estadoEnviosRepository;

    public EstadoEnvios createEstados (EstadoEnvios estadoEnvios)
    {
        return estadoEnviosRepository.save(estadoEnvios);
    }

    public EstadoEnvios getEstadosById (Integer id)
    {
        Optional<EstadoEnvios> optionalEstadoEnvios = estadoEnviosRepository.findById(id);
        return optionalEstadoEnvios.get();
    }

    public List<EstadoEnvios> getAllEstados()
    {
        return estadoEnviosRepository.findAll();
    }

    public void deleteEstados(Integer id)
    {
        estadoEnviosRepository.deleteById(id);
    }
}
