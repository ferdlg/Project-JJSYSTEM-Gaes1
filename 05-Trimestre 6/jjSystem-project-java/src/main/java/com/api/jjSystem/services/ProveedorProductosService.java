package com.api.jjSystem.services;

import com.api.jjSystem.Repository.ProveedorProductosRepository;
import com.api.jjSystem.models.ProveedoresProductos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProveedorProductosService {

    @Autowired
    private ProveedorProductosRepository proveedorProductosRepository;

    public ProveedoresProductos createProveedorProducto(ProveedoresProductos proveedorProducto)
    {
        return proveedorProductosRepository.save(proveedorProducto);
    }

    public ProveedoresProductos getProveedorProductoById(Integer idProveedorProducto)
    {
        Optional<ProveedoresProductos> proveedorProductos = proveedorProductosRepository.findById(idProveedorProducto);
        return proveedorProductos.get();
    }

    public List<ProveedoresProductos> getAllProveedorProductos()
    {
        return proveedorProductosRepository.findAll();
    }

    public void deleteProveedorProductos(Integer idProveedorProducto)
    {
        proveedorProductosRepository.deleteById(idProveedorProducto);
    }
}
