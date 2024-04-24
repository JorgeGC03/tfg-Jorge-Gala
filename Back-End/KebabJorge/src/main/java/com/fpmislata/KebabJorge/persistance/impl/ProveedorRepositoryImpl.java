package com.fpmislata.KebabJorge.persistance.impl;

import com.fpmislata.KebabJorge.controller.model.proveedor.ProveedorDetailWeb;
import com.fpmislata.KebabJorge.domain.entity.Proveedor;
import com.fpmislata.KebabJorge.domain.repository.ProveedorRepository;
import com.fpmislata.KebabJorge.mapper.ProveedorMapper;
import com.fpmislata.KebabJorge.persistance.dao.ProveedorDAO;
import com.fpmislata.KebabJorge.persistance.model.ProveedorEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProveedorRepositoryImpl implements ProveedorRepository {

    @Autowired
    ProveedorDAO proveedorDAO;
    @Override
    public List<Proveedor> getAll() {
        List<ProveedorEntity> proveedorEntities = proveedorDAO.findAll();
        return ProveedorMapper.mapper.toProveedorList(proveedorEntities);
    }

    @Override
    public Proveedor findById(int proveedorId) {
        ProveedorEntity proveedorEntity = proveedorDAO.findById(proveedorId).orElse(null);
        return ProveedorMapper.mapper.toProveedor(proveedorEntity);
    }

    @Override
    @Transactional
    public Proveedor insertProveedor(Proveedor proveedor){
        ProveedorEntity proveedorEntity = proveedorDAO.save(ProveedorMapper.mapper.toProveedorEntity(proveedor));
        return ProveedorMapper.mapper.toProveedor(proveedorEntity);
    }

    @Override
    @Transactional
    public void deleteProveedor(Proveedor proveedor) {proveedorDAO.deleteById(proveedor.getProveedorId());}

    @Override
    public Proveedor updateProveedorById(Proveedor proveedor) {
        ProveedorEntity proveedorEntity = proveedorDAO.save(ProveedorMapper.mapper.toProveedorEntity(proveedor));
        return ProveedorMapper.mapper.toProveedor(proveedorEntity);
    }
}

