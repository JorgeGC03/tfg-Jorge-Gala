package com.fpmislata.KebabJorge.controller;

import java.util.ArrayList;
import java.util.List;

import com.fpmislata.KebabJorge.controller.model.ingredientes.IngredientesListWeb;
import com.fpmislata.KebabJorge.controller.model.kebab.KebabCreateWEB;
import com.fpmislata.KebabJorge.controller.model.kebab.KebabDetailWeb;
import com.fpmislata.KebabJorge.controller.model.kebab.KebabUpdateWEB;
import com.fpmislata.KebabJorge.domain.entity.Ingredientes;
import com.fpmislata.KebabJorge.domain.service.IngredientesService;
import com.fpmislata.KebabJorge.mapper.IngredientesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.fpmislata.KebabJorge.controller.model.kebab.KebabListWeb;
import com.fpmislata.KebabJorge.domain.entity.Kebab;
import com.fpmislata.KebabJorge.domain.service.KebabService;
import com.fpmislata.KebabJorge.http_response.Response;
import com.fpmislata.KebabJorge.mapper.KebabMapper;

import static com.fpmislata.KebabJorge.validaciones.Validation.validate;

@RequestMapping(KebabController.KEBABS)
@RestController
public class KebabController {

    public static final String KEBABS = "/kebabs";

    @Autowired
    KebabService kebabService;
    @Autowired
    IngredientesService ingredientesService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Response getAll() {
        List<Kebab> kebab = kebabService.getAll();
        List<KebabListWeb> kebabListWeb = kebab.stream()
                .map(KebabMapper.mapper::toKebabListWeb)
                .toList();

        return Response.builder()
                .data(kebabListWeb)
                .build();
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{kebabId}")
    public Response findById(@PathVariable("kebabId") int kebabId){
        return new Response( KebabMapper.mapper.toKebabDetailWeb(kebabService.findById(kebabId)));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Response insert(@RequestBody KebabCreateWEB kebabCreateWEB){

        KebabDetailWeb kebabDetailWeb = KebabMapper.mapper.toKebabDetailWeb(kebabService.insert(KebabMapper.mapper.toKebab(kebabCreateWEB), kebabCreateWEB.getIngredientesIdWeb()));
        return new Response(kebabDetailWeb);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteKebabById(@PathVariable("id") int kebabId){
        kebabService.deleteKebabById(kebabId);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public Response updateKebabById(@PathVariable("id") int kebabId, @RequestBody KebabUpdateWEB kebabUpdateWEB){
        Kebab kebab = KebabMapper.mapper.toKebab(kebabUpdateWEB);
        kebab.setKebabId(kebabId);
        kebabService.updateKebabById(kebab, kebabUpdateWEB.getIngredientesIdWeb());
        KebabDetailWeb kebabDetailWeb = KebabMapper.mapper.toKebabDetailWeb(kebab);
        return new Response(kebabDetailWeb);
    }
}
