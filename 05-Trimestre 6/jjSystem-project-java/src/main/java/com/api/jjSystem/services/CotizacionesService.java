package com.api.jjSystem.services;

import com.api.jjSystem.Repository.CotizacionesRepository;
import com.api.jjSystem.models.Cotizaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CotizacionesService {
    @Autowired
    private CotizacionesRepository cotizacionesRepository;

    public Cotizaciones createCotizacion(Cotizaciones cotizaciones)
    {
        return cotizacionesRepository.save(cotizaciones);
    }
    public Cotizaciones getCotizacionesById(Integer idCotizacion)
    {
        Optional<Cotizaciones> cotizaciones = cotizacionesRepository.findById(idCotizacion);
        return cotizaciones.get();
    }
    public List<Cotizaciones> getAllCotizaciones()
    {
        return cotizacionesRepository.findAll();
    }
    public void deleteCotizacionById(Integer idCotizacion)
    {
        cotizacionesRepository.deleteById(idCotizacion);
    }
}
