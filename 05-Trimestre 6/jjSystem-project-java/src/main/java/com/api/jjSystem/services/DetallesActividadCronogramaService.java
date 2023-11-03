package com.api.jjSystem.services;

import com.api.jjSystem.Repository.DetallesActividadCronogramaRepository;
import com.api.jjSystem.models.DetallesActividadCronograma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DetallesActividadCronogramaService {
    @Autowired
    private DetallesActividadCronogramaRepository detallesActividadCronogramaRepository;
    public DetallesActividadCronograma createDetalle(DetallesActividadCronograma detallesActividadCronograma)
    {
        return detallesActividadCronogramaRepository.save(detallesActividadCronograma);
    }
    public DetallesActividadCronograma getDetalleByid(Integer idDetalleActividad)
    {
        Optional<DetallesActividadCronograma> detalleActividadCronograma = detallesActividadCronogramaRepository.findById(idDetalleActividad);
        return detalleActividadCronograma.get();
    }
    public List<DetallesActividadCronograma> getAllDetalle()
    {
        return detallesActividadCronogramaRepository.findAll();
    }
    public void deleteDetalleById(Integer idDetalleVenta)
    {
        detallesActividadCronogramaRepository.deleteById(idDetalleVenta);
    }
}
