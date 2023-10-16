package com.api.jjSystem.services;

import com.api.jjSystem.Repository.DisponibilidadCronogramasRepository;
import com.api.jjSystem.models.DisponibilidadCronogramas;
import com.api.jjSystem.models.EstadosCitas;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DisponibilidadCronogramasService {
    @Autowired
    private DisponibilidadCronogramasRepository disponibilidadCronogramasRepository;
    public DisponibilidadCronogramas createDisponibilidad(DisponibilidadCronogramas disponibilidadCronogramas)
    {
        return disponibilidadCronogramasRepository.save(disponibilidadCronogramas);
    }
    public DisponibilidadCronogramas getDisponibilidadById(Integer idDisponibilidadCronograma)
    {
        Optional<DisponibilidadCronogramas> disponibilidadCronogramas = disponibilidadCronogramasRepository.findById(idDisponibilidadCronograma);
        return disponibilidadCronogramas.get();
    }
    public void deleteDisponibilidadById(Integer idDisponibilidadCronograma)
    {
        disponibilidadCronogramasRepository.deleteById(idDisponibilidadCronograma);
    }
}
