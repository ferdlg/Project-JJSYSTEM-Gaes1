package com.api.jjSystem.services;

import com.api.jjSystem.Repository.DetallesVentasRepository;
import com.api.jjSystem.models.DetallesVentas;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DetallesVentasService {

    @Autowired
    private DetallesVentasRepository detallesVentasRepository;

    public DetallesVentas createDetalleVenta(DetallesVentas detalleVenta)
    {
        return detallesVentasRepository.save(detalleVenta);
    }

    public DetallesVentas getDetallesVentasById (Integer idDetalleVenta)
    {
        Optional<DetallesVentas> optionalDetallesVentas = detallesVentasRepository.findById(idDetalleVenta);
        return optionalDetallesVentas.get();
    }

    public List<DetallesVentas> getAllDetallesVentas()
    {
        return detallesVentasRepository.findAll();
    }

    public void deleteDetallesVentas(Integer idDetalleVenta)
    {
        detallesVentasRepository.deleteById(idDetalleVenta);
    }

}
