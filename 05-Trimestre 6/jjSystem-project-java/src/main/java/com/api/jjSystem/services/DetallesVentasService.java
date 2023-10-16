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
    public DetallesVentas createDetalle(DetallesVentas detallesVentas)
    {
        return detallesVentasRepository.save(detallesVentas);
    }
    public DetallesVentas getDetalleById (Integer idDetalleVenta)
    {
        Optional<DetallesVentas> detallesVentas = detallesVentasRepository.findById(idDetalleVenta);
        return detallesVentas.get();
    }
    public List<DetallesVentas> getAllDetalles()
    {
        return detallesVentasRepository.findAll();
    }
    public void deleteDetallesById(Integer idDetalleVenta)
    {
        detallesVentasRepository.deleteById(idDetalleVenta);
    }

}
