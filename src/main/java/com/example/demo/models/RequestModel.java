package com.example.demo.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

//Modelo que se encarga de definir los 3 parametros necesarios para realizar
// el calculo solicitado. Implementa sus getters y setters para tener acceso
// a sus variables o atributos
public class RequestModel {

    @NotNull(message = "El parametro N es obligatorio")
    private Integer paramN;

    @NotNull(message = "El parametro X es obligatorio")
    @Min(1)
    private Integer paramX;

    @NotNull(message = "El parametro Y es obligatorio")
    private Integer paramY;

    public void setParamN(Integer paramN) {
        this.paramN = paramN;
    }

    public void setParamX(Integer paramX) {
        this.paramX = paramX;
    }

    public void setParamY(Integer paramY) {
        this.paramY = paramY;
    }

    public Integer getParamN() {
        return paramN;
    }

    public Integer getParamX() {
        return paramX;
    }

    public Integer getParamY() {
        return paramY;
    }
}
