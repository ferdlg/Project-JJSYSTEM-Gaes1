package com.api.jjSystem.services;

import com.api.jjSystem.Repository.DetalleActividadCronogramaRepository;
import com.api.jjSystem.models.DetalleActividadCronograma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DetalleActividadCronogramaService {
    @Autowired
    private DetalleActividadCronogramaRepository detalleActividadCronogramaRepository;
    public DetalleActividadCronograma createDetalle(DetalleActividadCronograma detalleActividadCronograma)
    {
        return detalleActividadCronogramaRepository.save(detalleActividadCronograma);
    }
    public DetalleActividadCronograma getDetalleByid(Integer idDetalleActividad)
    {
        Optional<DetalleActividadCronograma> detalleActividadCronograma = detalleActividadCronogramaRepository.findById(idDetalleActividad);
        return detalleActividadCronograma.get();
    }
    public List<DetalleActividadCronograma> getAllDetalle()
    {
        return detalleActividadCronogramaRepository.findAll();
    }
    public void deleteDetalleById(Integer idDetalleVenta)
    {
        detalleActividadCronogramaRepository.deleteById(idDetalleVenta);
    }
}
