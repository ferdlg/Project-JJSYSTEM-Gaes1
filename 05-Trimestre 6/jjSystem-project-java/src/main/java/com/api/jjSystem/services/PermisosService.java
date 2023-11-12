package com.api.jjSystem.services;

import com.api.jjSystem.Repository.PermisosRepository;
import com.api.jjSystem.models.Permisos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PermisosService {

    @Autowired
    private PermisosRepository permisosRepository;

    public Permisos createPermisos (Permisos permiso)
    {
        return permisosRepository.save(permiso);
    }

    public Permisos getPermisosById (Integer idPermiso)
    {
        Optional<Permisos> optionalPermisos = permisosRepository.findById(idPermiso);
        return optionalPermisos.get();
    }

    public List<Permisos> getAllPermisos()
    {
        return permisosRepository.findAll();
    }

    public void deletePermisos(Integer idPermiso)
    {
        permisosRepository.deleteById(idPermiso);
    }
}
