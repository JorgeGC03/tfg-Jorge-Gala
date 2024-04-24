package com.fpmislata.KebabJorge.domain.repository;

import com.fpmislata.KebabJorge.domain.entity.Kebab;
import com.fpmislata.KebabJorge.domain.entity.Proveedor;

import java.util.List;

public interface ProveedorRepository {
    public  List<Proveedor> getAll();
    public Proveedor findById(int proveedorId);
    public Proveedor insertProveedor(Proveedor proveedor);
    public void deleteProveedor(Proveedor proveedor);
    public Proveedor updateProveedorById(Proveedor proveedor);

}
