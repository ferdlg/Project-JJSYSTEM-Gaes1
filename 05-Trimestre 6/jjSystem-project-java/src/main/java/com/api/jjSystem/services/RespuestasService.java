package com.api.jjSystem.services;

import com.api.jjSystem.Repository.RespuestasRepository;
import com.api.jjSystem.models.Respuestas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RespuestasService {

    @Autowired
    private RespuestasRepository respuestasRepository;

    public Respuestas createRespuesta(Respuestas respuesta)
    {
        return respuestasRepository.save(respuesta);
    }

    public Respuestas getRespuestaById(Integer idRespuesta)
    {
        Optional<Respuestas> optionalRespuestas = respuestasRepository.findById(idRespuesta);
        return optionalRespuestas.get();
    }

    public List<Respuestas> getAllRespuestas()
    {
        return respuestasRepository.findAll();
    }

    public void deleteRespuestas(Integer idRespuesta)
    {
        respuestasRepository.deleteById(idRespuesta);
    }

}
