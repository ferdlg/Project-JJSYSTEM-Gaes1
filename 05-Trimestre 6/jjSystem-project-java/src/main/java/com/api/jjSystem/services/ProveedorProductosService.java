package com.api.jjSystem.services;

import com.api.jjSystem.Repository.ProveedorProductosRepository;
import com.api.jjSystem.models.ProveedorProductos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProveedorProductosService {
    @Autowired
    private ProveedorProductosRepository proveedorProductosRepository;
    public ProveedorProductos createProveedor(ProveedorProductos proveedorProductos)
    {
        return proveedorProductosRepository.save(proveedorProductos);
    }
    public ProveedorProductos getProveedorById(Integer idProveedorProductos)
    {
        Optional<ProveedorProductos> proveedorProductos = proveedorProductosRepository.findById(idProveedorProductos);
        return proveedorProductos.get();
    }
    public List<ProveedorProductos> getAllProveedores()
    {
        return proveedorProductosRepository.findAll();
    }
    public void deleteProveedorById(Integer idProveedorProductos)
    {
        proveedorProductosRepository.deleteById(idProveedorProductos);
    }
}
