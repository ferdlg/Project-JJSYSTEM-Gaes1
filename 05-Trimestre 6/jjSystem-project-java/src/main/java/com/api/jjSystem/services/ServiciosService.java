package com.api.jjSystem.services;

import com.api.jjSystem.Repository.ServiciosRepository;
import com.api.jjSystem.models.Servicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ServiciosService {

    @Autowired
    private ServiciosRepository serviciosRepository;

    public Servicios createServicio(Servicios servicio)
    {
        return serviciosRepository.save(servicio);
    }

    public Servicios getServicioById(Integer idServicio)
    {
        Optional<Servicios> optionalServicios = serviciosRepository.findById(idServicio);
        return optionalServicios.get();
    }

    public List<Servicios> getAllServicios()
    {
        return serviciosRepository.findAll();
    }

    public void deleteServicios(Integer idServicio)
    {
        serviciosRepository.deleteById(idServicio);
    }
}
