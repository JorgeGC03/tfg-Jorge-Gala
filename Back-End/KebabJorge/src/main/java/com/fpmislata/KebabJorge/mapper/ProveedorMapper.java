package com.fpmislata.KebabJorge.mapper;

import com.fpmislata.KebabJorge.controller.model.proveedor.ProveedorCreateWeb;
import com.fpmislata.KebabJorge.controller.model.proveedor.ProveedorDetailWeb;
import com.fpmislata.KebabJorge.controller.model.proveedor.ProveedorListWeb;
import com.fpmislata.KebabJorge.controller.model.proveedor.ProveedorUpdateWeb;
import com.fpmislata.KebabJorge.domain.entity.Proveedor;
import com.fpmislata.KebabJorge.persistance.model.ProveedorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProveedorMapper {

    ProveedorMapper mapper = Mappers.getMapper(ProveedorMapper.class);

    List<Proveedor> toProveedorList (List<ProveedorEntity> proveedorEntity);
    ProveedorListWeb toProveedorListWeb(Proveedor proveedor);
    ProveedorDetailWeb toProveedorDetailWeb(Proveedor proveedor);
    Proveedor toProveedor(ProveedorEntity proveedorEntity);

    ProveedorEntity toProveedorEntity(Proveedor proveedor);

    Proveedor toProveedor(ProveedorCreateWeb proveedorCreateWeb);
    Proveedor toProveedor(ProveedorUpdateWeb proveedorupdateWeb);

}
