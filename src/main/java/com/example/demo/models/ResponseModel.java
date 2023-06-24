package com.example.demo.models;

import java.util.List;

//Modelo que se encarga de definir la respuesta o retorno del metodo calculo.
// Implementa sus getters y setters para tener acceso
// a sus variables o atributos

public class ResponseModel {
    private Integer data;
    private Integer status;
    private List<String> errors;

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getData() {
        return data;
    }

    public List<String> getErrors() {
        return errors;
    }

    public Integer getStatus() {
        return status;
    }
}
