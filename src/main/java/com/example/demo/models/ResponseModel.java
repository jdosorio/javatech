package com.example.demo.models;

import java.util.List;

import lombok.Data;

//Modelo que se encarga de definir la respuesta o retorno del metodo calculo.
// Implementa sus getters y setters para tener acceso
// a sus variables o atributos
@Data
public class ResponseModel {
    private Integer data;
    private Integer status;
    private List<String> errors;

}
