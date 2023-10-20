package com.api.jjSystem.services;

import com.api.jjSystem.Repository.VentasRepository;
import com.api.jjSystem.models.Roles;
import com.api.jjSystem.models.Ventas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class VentasService {

    @Autowired
    private VentasRepository ventasRepository;

    public Ventas createVenta(Ventas venta)
    {
        return ventasRepository.save(venta);
    }

    public Ventas getVentaById(Integer idVenta)
    {
        Optional<Ventas> optionalVentas = ventasRepository.findById(idVenta);
        return optionalVentas.get();
    }

    public List<Ventas> getAllVentas()
    {
        return ventasRepository.findAll();
    }

    public void deleteVentas(Integer idVenta)
    {
        ventasRepository.deleteById(idVenta);
    }

}
