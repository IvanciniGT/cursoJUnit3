package com.curso;

import com.curso.impl.SuministradorDeDiccionariosDesdeFicheros;

public interface SuministradorDeDiccionariosFactory {
    
    static SuministradorDeDiccionarios getInstance(){ // Me temo que si... Desde Java 8
        //throw new RuntimeException("No implementado todavia"); 
        return new SuministradorDeDiccionariosDesdeFicheros();

    }

}