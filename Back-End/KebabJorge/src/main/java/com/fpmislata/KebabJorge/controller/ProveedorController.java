package com.fpmislata.KebabJorge.controller;

import com.fpmislata.KebabJorge.controller.model.proveedor.ProveedorCreateWeb;
import com.fpmislata.KebabJorge.controller.model.proveedor.ProveedorListWeb;
import com.fpmislata.KebabJorge.controller.model.proveedor.ProveedorUpdateWeb;
import com.fpmislata.KebabJorge.domain.entity.Proveedor;
import com.fpmislata.KebabJorge.domain.service.ProveedorService;
import com.fpmislata.KebabJorge.http_response.Response;
import com.fpmislata.KebabJorge.mapper.ProveedorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static com.fpmislata.KebabJorge.validaciones.Validation.validate;

@RequestMapping(ProveedorController.PROVEEDORES)
@RestController
public class ProveedorController {

    public static final String PROVEEDORES = "/proveedores";

    @Autowired
    ProveedorService proveedorService;


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Response getAll() {
        List<Proveedor> proveedor = proveedorService.getAll();
        List<ProveedorListWeb> proveedorListWeb = proveedor.stream()
                .map(ProveedorMapper.mapper::toProveedorListWeb)
                .toList();

        return Response.builder()
                .data(proveedorListWeb)
                .build();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{proveedorId}")
    public Response findById(@PathVariable("proveedorId") int proveedorId) {
        return new Response(ProveedorMapper.mapper.toProveedorDetailWeb(proveedorService.findById(proveedorId)));
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("")
    public Response insertProveedor(@RequestBody ProveedorCreateWeb proveedorCreateWeb) {
        validate(proveedorCreateWeb);
        return new Response(proveedorService.insertProveedor(ProveedorMapper.mapper.toProveedor(proveedorCreateWeb)));
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("/{id}")
    public void deleteProveedor(@PathVariable("id") int proveedorId) {
        proveedorService.deleteProveedor(proveedorId);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/{id}")
    public Response updateProveedor(@PathVariable("id") int proveedorId, @RequestBody ProveedorUpdateWeb proveedorUpdateWeb){
    ProveedorMapper.mapper.toProveedor(proveedorUpdateWeb);
    return new Response(proveedorService.updateProveedorById(ProveedorMapper.mapper.toProveedor(proveedorUpdateWeb),proveedorId));
    }
}
