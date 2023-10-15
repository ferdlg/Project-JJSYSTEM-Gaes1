package com.api.jjSystem.services;

import com.api.jjSystem.Repository.EnviosRepository;
import com.api.jjSystem.models.Envios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Component
public class EnviosService {

    @Autowired
    private EnviosRepository enviosRepository;

    public Envios createEnvio(Envios envio)
    {
        return enviosRepository.save(envio);
    }

    public Envios getEnvioById(Integer id)
    {
        Optional<Envios> optionalEnvios = enviosRepository.findById(id);
        return optionalEnvios.get();
    }

    public List<Envios> getAllEnvios()
    {
        return enviosRepository.findAll();
    }

    public void deleteEnvios(Integer id)
    {
        enviosRepository.deleteById(id);
    }
}
