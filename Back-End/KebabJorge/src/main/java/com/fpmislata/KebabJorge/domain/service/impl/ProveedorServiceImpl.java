package com.fpmislata.KebabJorge.domain.service.impl;

import com.fpmislata.KebabJorge.domain.entity.Proveedor;
import com.fpmislata.KebabJorge.domain.repository.ProveedorRepository;
import com.fpmislata.KebabJorge.domain.service.ProveedorService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.fpmislata.KebabJorge.validaciones.Validation.validate;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    @Autowired
    ProveedorRepository proveedorRepository;

    @Override
    public List<Proveedor> getAll() {

        return proveedorRepository.getAll();
    }

    @Override
    public Proveedor findById(int proveedorId) {
        return proveedorRepository.findById(proveedorId);
    }

    @Override
    @Transactional
    public Proveedor insertProveedor(Proveedor proveedor){
        validate(proveedor);
        return proveedorRepository.insertProveedor(proveedor);
    }

    @Override
    public void deleteProveedor(int proveedorId) {
        Proveedor proveedor = proveedorRepository.findById(proveedorId);
        proveedorRepository.deleteProveedor(proveedor);
    }

    @Override
    public Proveedor updateProveedorById(Proveedor proveedor, int id) {
        validate(proveedor);
        proveedor.setProveedorId(id);
        return proveedorRepository.updateProveedorById(proveedor);
    }


}

