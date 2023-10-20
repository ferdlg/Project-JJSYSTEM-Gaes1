package com.api.jjSystem.services;

import com.api.jjSystem.Repository.EstadosUsuariosRepository;
import com.api.jjSystem.models.EstadosUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EstadosUsuariosService {

    @Autowired
    private EstadosUsuariosRepository estadosUsuariosRepository;

    public EstadosUsuarios createEstadoUsuario(EstadosUsuarios estadoUsuario)
    {
        return estadosUsuariosRepository.save(estadoUsuario);
    }

    public EstadosUsuarios getEstadoUsuarioById(Integer idEstadoUsuario)
    {
        Optional<EstadosUsuarios> optionalEstadosUsuarios = estadosUsuariosRepository.findById(idEstadoUsuario);
        return optionalEstadosUsuarios.get();
    }

    public List<EstadosUsuarios> getAllEstadosUsuarios()
    {
        return estadosUsuariosRepository.findAll();
    }

    public void deleteEstadosUsuarios(Integer idEstadoUsuario)
    {
        estadosUsuariosRepository.deleteById(idEstadoUsuario);
    }
}
