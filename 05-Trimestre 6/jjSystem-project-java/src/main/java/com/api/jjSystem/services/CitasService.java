package com.api.jjSystem.services;

import com.api.jjSystem.Repository.CitasRepository;
import com.api.jjSystem.models.Citas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CitasService {
    @Autowired
    private CitasRepository citasRepository;
    public Citas createCita(Citas citas)
    {
        return citasRepository.save(citas);
    }
    public Citas getCitaById(Integer idCita)
    {
        Optional<Citas> citas= citasRepository.findById(idCita);
        return citas.get();
    }
    public List<Citas> getAllCita()
    {
        return citasRepository.findAll();
    }
    public void deleteCitaById(Integer idCita)
    {
        citasRepository.deleteById(idCita);
    }
}
