package com.api.jjSystem.services;

import com.api.jjSystem.Repository.EstadosCotizacionesRepository;
import com.api.jjSystem.models.EstadosCotizaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EstadosCotizacionesService {

    @Autowired
    private EstadosCotizacionesRepository estadosCotizacionesRepository;

    public EstadosCotizaciones createEstadoCotizacion(EstadosCotizaciones estadoCotizacion)
    {
        return estadosCotizacionesRepository.save(estadoCotizacion);
    }

    public EstadosCotizaciones getEstadoCotizacionById(Integer idEstadoCotizacion)
    {
        Optional<EstadosCotizaciones> optionalEstadosCotizaciones = estadosCotizacionesRepository.findById(idEstadoCotizacion);
        return optionalEstadosCotizaciones.get();
    }

    public List<EstadosCotizaciones> getAllEstadosCotizaciones()
    {
        return estadosCotizacionesRepository.findAll();
    }

    public void deleteEstadosCotizaciones(Integer idEstadoCotizacion)
    {
        estadosCotizacionesRepository.deleteById(idEstadoCotizacion);
    }

}
