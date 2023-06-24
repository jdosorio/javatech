package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.RequestModel;
import com.example.demo.models.ResponseModel;
import com.example.demo.services.CalculoService;

//Declaracion de clase CalculoController la cual contiene el endpoint para calcular y el endpoint healthcheck
@RestController
public class CalculoController {
    // Se inyecta el servicio calculoService el cual contiene la logica de negocio
    @Autowired
    CalculoService calculoService;

    // Endpoint /api/calculo
    // Se permite cualquier origen de la peticion (ayuda a prevenir el error de CORS
    // en desarrollo)
    @CrossOrigin(origins = "*")
    // Se define el endpoint y se permite como metodo http GET y POST para realizar
    // la peticion
    @RequestMapping(value = "/api/calculo", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    // Metodo que recibe una peticion con los parametros de tipo RequestModel
    // y retorna como respuesta un ResponseModel el cual es esperado por el front
    public ResponseEntity<ResponseModel> calcular(@Valid @RequestBody RequestModel requestModel) {
        ResponseModel response = new ResponseModel();

        response.setData(calculoService.getCalculo(requestModel.getParamN(), requestModel.getParamX(),
                requestModel.getParamY()));
        response.setStatus(200);

        return ResponseEntity.ok(response);
    }

    // Endpoint / que es el endpoint raiz, el cual se encarga de retornar
    // un String con un mensaje para comprobar que el servicio esta operativo
    @GetMapping("/")
    public String index() {
        return "HEALTH CHECK OK! Bienvenido a la prueba tecnica";
    }

    // Metdo encargado de capturar las excepciones que se presentan con los
    // parametros
    // suministrados el cual recorre los errores, contruye un array de errores y lo
    // retorna
    // parseado al tipo response model
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseModel> handleValidationErrors(MethodArgumentNotValidException ex) {
        ResponseModel response = new ResponseModel();
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        final List<String> errors = new ArrayList<String>();
        for (final FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        response.setStatus(500);
        response.setData(null);
        response.setErrors(errors);
        return ResponseEntity.status(500).body(response);
    }
}
