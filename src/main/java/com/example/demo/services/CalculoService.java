package com.example.demo.services;

import org.springframework.stereotype.Component;

// Servicio que contiene la logica del negocio, en este caso con unico metodo
// getCalculo(n,x,y) el cual recibe 3 variables para realizar el calculo

// Esta funcion resuelve el problema planteado https://codeforces.com/problemset/problem/1374/A
// el cual tendria una version para resolverlo programatica (con bucle y estrucutra de control)
// o una solucion con una expresion matematica que es mas simple en codigo
@Component
public class CalculoService {
    public Integer getCalculo(Integer n, Integer x, Integer y) {
        if (x <= 0) {
            return -1;
        }

        int calculo = (n - n % x + y <= n) ? n - n % x + y : n - n % x - (x - y);

        return (calculo >= 0 && calculo <= n) ? calculo : -1;
    }
}
