package com.api.jjSystem.services;

import com.api.jjSystem.Repository.AdministradorRepository;
import com.api.jjSystem.Repository.ProveedorProductosRepository;
import com.api.jjSystem.models.Administrador;
import com.api.jjSystem.models.ProveedorProductos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AdministradorService {
    @Autowired
    private AdministradorRepository administradorRepository;
    public Administrador createAdministrador(Administrador administrador)
    {
        return administradorRepository.save(administrador);
    }
    public Administrador getAdministradorById(Integer idAdministrador)
    {
        Optional<Administrador> administrador = administradorRepository.findById(idAdministrador);
        return administrador.get();
    }
    public List<Administrador> getAllAdministrador()
    {
        return administradorRepository.findAll();
    }
    public void deleteAdministradorById(Integer idAdministrador)
    {
        administradorRepository.deleteById(idAdministrador);
    }
}
