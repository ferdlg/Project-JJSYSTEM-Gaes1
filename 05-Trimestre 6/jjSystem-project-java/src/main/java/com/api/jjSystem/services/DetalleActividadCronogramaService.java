package com.api.jjSystem.services;

import com.api.jjSystem.Repository.DetalleActividadCronogramaRepository;
import com.api.jjSystem.models.DetallesActividadCronograma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DetalleActividadCronogramaService {
    @Autowired
    private DetalleActividadCronogramaRepository detalleActividadCronogramaRepository;
    public DetallesActividadCronograma createDetalle(DetallesActividadCronograma detallesActividadCronograma)
    {
        return detalleActividadCronogramaRepository.save(detallesActividadCronograma);
    }
    public DetallesActividadCronograma getDetalleByid(Integer idDetalleActividad)
    {
        Optional<DetallesActividadCronograma> detalleActividadCronograma = detalleActividadCronogramaRepository.findById(idDetalleActividad);
        return detalleActividadCronograma.get();
    }
    public List<DetallesActividadCronograma> getAllDetalle()
    {
        return detalleActividadCronogramaRepository.findAll();
    }
    public void deleteDetalleById(Integer idDetalleVenta)
    {
        detalleActividadCronogramaRepository.deleteById(idDetalleVenta);
    }
}
