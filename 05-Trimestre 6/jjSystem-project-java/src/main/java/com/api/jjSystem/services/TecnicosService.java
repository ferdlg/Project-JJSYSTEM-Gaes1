package com.api.jjSystem.services;

import com.api.jjSystem.Repository.TecnicosRepository;
import com.api.jjSystem.models.Tecnicos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TecnicosService {
    @Autowired
    private TecnicosRepository tecnicosRepository;
    public Tecnicos createTecnico(Tecnicos tecnicos)
    {
        return tecnicosRepository.save(tecnicos);
    }
    public Tecnicos getTecnicoById(Integer idTecnico)
    {
        Optional<Tecnicos> tecnicos = tecnicosRepository.findById(idTecnico);
        return  tecnicos.get();
    }
    public List<Tecnicos> getAllTecnicos()
    {
        return tecnicosRepository.findAll();
    }
    public void deleteTecnicosById(Integer idTecnico)
    {
        tecnicosRepository.deleteById(idTecnico);
    }
}
