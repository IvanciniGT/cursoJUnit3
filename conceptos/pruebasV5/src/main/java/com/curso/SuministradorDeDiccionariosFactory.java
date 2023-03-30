package com.curso;

public interface SuministradorDeDiccionariosFactory {
    
    static SuministradorDeDiccionarios getInstance(){ // Me temo que si... Desde Java 8
        throw new RuntimeException("No implementado todavia"); 
    }

}