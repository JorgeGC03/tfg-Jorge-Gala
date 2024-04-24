package com.fpmislata.KebabJorge.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("")
    public String index(){
        return "Bienvenido a la API de KEBABS DE GORDOS";
    }

}