package com.fpmislata.KebabJorge.domain.service;

import com.fpmislata.KebabJorge.domain.entity.Proveedor;
import com.fpmislata.KebabJorge.persistance.model.ProveedorEntity;

import java.util.List;

public interface ProveedorService {

    List<Proveedor> getAll();
    public Proveedor findById(int proveedorId);
    public Proveedor insertProveedor(Proveedor proveedor);
    public void deleteProveedor(int proveedorId);
    public Proveedor updateProveedorById(Proveedor proveedor, int id);
}
