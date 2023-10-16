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
    public Ventas createVenta(Ventas ventas) {return ventasRepository.save(ventas);}
    public Ventas getVentaByid(Integer idVenta)
    {
        Optional<Ventas> ventas = ventasRepository.findById(idVenta);
        return ventas.get();
    }

    public List<Ventas> getAllVentas()
    {
        return ventasRepository.findAll();
    }
    public void deleteVentasById(Integer idVenta)
    {
        ventasRepository.deleteById(idVenta);
    }
}
