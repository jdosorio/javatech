package com.example.demo.services;

import org.springframework.stereotype.Component;

@Component
public class CalculoService {
    public Integer getCalculo(Integer n, Integer x, Integer y) {
        int calculo = (n - n % x + y <= n) ? n - n % x + y : n - n % x - (x - y);

        return (calculo >= 0 && calculo <= n) ? calculo : -1;
    }
}
