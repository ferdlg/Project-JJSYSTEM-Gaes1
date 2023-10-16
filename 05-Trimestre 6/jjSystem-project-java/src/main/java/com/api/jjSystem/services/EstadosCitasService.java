package com.api.jjSystem.services;

import com.api.jjSystem.Repository.EstadosCitasRepository;
import com.api.jjSystem.models.EstadosCitas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EstadosCitasService {
    @Autowired
    private EstadosCitasRepository estadosCitasRepository;
    public EstadosCitas createEstado(EstadosCitas estadosCitas)
    {
        return estadosCitasRepository.save(estadosCitas);
    }
    public EstadosCitas getEstadoByid(Integer idEstadoCita)
    {
        Optional<EstadosCitas> estadosCitas = estadosCitasRepository.findById(idEstadoCita);
        return estadosCitas.get();
    }
    public List<EstadosCitas> getAllEstados()
    {
        return estadosCitasRepository.findAll();
    }
    public void deleteEstadoById(Integer idEstadoCita)
    {
        estadosCitasRepository.deleteById(idEstadoCita);
    }
}
