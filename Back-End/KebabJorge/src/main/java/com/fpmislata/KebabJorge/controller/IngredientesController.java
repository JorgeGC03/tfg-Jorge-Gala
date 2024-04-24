package com.fpmislata.KebabJorge.controller;

import com.fpmislata.KebabJorge.controller.model.ingredientes.IngredientesCreateWeb;
import com.fpmislata.KebabJorge.controller.model.ingredientes.IngredientesDetailWeb;
import com.fpmislata.KebabJorge.controller.model.ingredientes.IngredientesListWeb;
import com.fpmislata.KebabJorge.controller.model.ingredientes.IngredientesUpdateWeb;
import com.fpmislata.KebabJorge.domain.entity.Ingredientes;
import com.fpmislata.KebabJorge.domain.service.IngredientesService;
import com.fpmislata.KebabJorge.http_response.Response;
import com.fpmislata.KebabJorge.mapper.IngredientesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(IngredientesController.INGREDIENTES)
@RestController
public class IngredientesController {

    public static final String INGREDIENTES = "/ingredientes";

    @Autowired
    IngredientesService ingredientesService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("")
    public Response getAll() {
        List<Ingredientes> ingredientes = ingredientesService.getAll();
        List<IngredientesListWeb> ingredientesListWeb = ingredientes.stream()
                .map(IngredientesMapper.mapper::toIngredientesListWeb)
                .toList();

        Response response = Response.builder()
                .data(ingredientesListWeb)
                .build();
        return response;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{ingredientesId}")
    public Response findById(@PathVariable("ingredientesId") int ingredientesId){
        return new Response( IngredientesMapper.mapper.toIngredientesDetailWeb(ingredientesService.findById(ingredientesId)));
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("")
    public Response insertIngrediente(@RequestBody IngredientesCreateWeb ingredientesCreateWeb){
        IngredientesDetailWeb ingredientesDetailWeb = IngredientesMapper.mapper.toIngredientesDetailWeb(ingredientesService.insertIngrediente(IngredientesMapper.mapper.toIngredientes(ingredientesCreateWeb), ingredientesCreateWeb.getProveedorIdWeb()));
        return new Response(ingredientesDetailWeb);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteIngrediente(@PathVariable("id") int ingredientesId){
        ingredientesService.deleteIngrediente(ingredientesId);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public Response updateIngredienteById(@PathVariable("id") int ingredientesId, @RequestBody IngredientesUpdateWeb ingredientesUpdateWeb){
        Ingredientes ingredientes = IngredientesMapper.mapper.toIngredientes(ingredientesUpdateWeb);
        ingredientes.setIngredientesId(ingredientesId);
        ingredientesService.updateIngredienteById(ingredientes, ingredientesUpdateWeb.getProveedorIdWeb());
        IngredientesDetailWeb ingredientesDetailWeb = IngredientesMapper.mapper.toIngredientesDetailWeb(ingredientes);
        return new Response(ingredientesDetailWeb);
    }
}
