package com.example.demo.controllers;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.RequestModel;
import com.example.demo.models.ResponseModel;
import com.example.demo.services.CalculoService;

@RestController
public class CalculoController {
    @Autowired
    CalculoService calculoService;

    @RequestMapping(value = "/api/calculo", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public ResponseEntity<ResponseModel> calcular(@RequestBody RequestModel requestModel) {
        ResponseModel response = new ResponseModel();

        response.setData(calculoService.getCalculo(requestModel.getParamN(), requestModel.getParamX(),
                requestModel.getParamY()));
        response.setStatus(200);

        return ResponseEntity.ok(response);
    }
}
