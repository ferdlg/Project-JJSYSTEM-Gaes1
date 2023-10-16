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
    public EstadosUsuarios createEstado(EstadosUsuarios estadosUsuarios)
    {
        return estadosUsuariosRepository.save(estadosUsuarios);
    }
    public EstadosUsuarios getEstadoById(Integer idEstadoUsuario)
    {
        Optional<EstadosUsuarios> estadosUsuarios = estadosUsuariosRepository.findById(idEstadoUsuario);
        return estadosUsuarios.get();
    }
    public List<EstadosUsuarios> getAllEstados()
    {
        return estadosUsuariosRepository.findAll();
    }
    public void deleteEstadoById(Integer idEstadoUsuario)
    {
        estadosUsuariosRepository.deleteById(idEstadoUsuario);
    }
}
