package com.curso;

import org.junit.Assert;

import org.junit.Test;

public class AppTest {
    
    /*
    // Compruebo que se puede crear un contador sin que genere una Excepción
    // Encubiertamente estoy llamando a la función setNumero... pero solo compruebo 
    // que no lanza Exception 
    @Test
    public void crearContador() {
        new Contador("Contador1");
    }
    */
    /*
    // Compruebo que el constructor asigna correctamente el valor inicial del número
    // Compruebo que el setter del numero funciona bien
    // Compruebo que el número se recupera sin problemas (el getter)
    @Test
    public void recuperarNumero() {
        Contador c1=new Contador("Contador1");
        int valorDevuelto = c1.getNumero();
        int valorEsperado = 0;
        Assert.assertEquals(valorEsperado, valorDevuelto);
    }    
    */
    /*
    // Compruebo que el constructor asigna correctamente el valor inicial del nombre
    // Compruebo que el nombre se recupera sin problemas (el getter)
    @Test
    public void recuperarNombre() {
        String valorEsperado = "Contador1";
        Contador c1=new Contador(valorEsperado);
        String valorDevuelto = c1.getNombre();
        Assert.assertEquals(valorEsperado, valorDevuelto);
    }   
    */
    
    // Y esto lo considero una prueba unitaria
    // Compruebo el constructor
    @Test
    public void comprobarContador() {
        String nombreEsperado = "Contador1";
        Contador c1=new Contador(nombreEsperado);
        String nombreDevuelto = c1.getNombre();
        Assert.assertEquals(nombreEsperado, nombreDevuelto);
        int valorDevuelto = c1.getNumero();
        int valorEsperado = 0;
        Assert.assertEquals(valorEsperado, valorDevuelto);
    }   
    
    
    // Compruebo que el método incrementar funciona correctamente
    // De hecho, esta es la primera prueba UNITARIA del fichero!
    // Eso si somos muy muy muy puristas (gilipollas!!!!)
    // En la práctica, los settery los getter, no los compruebo unitariamente...
    // A no ser que tengan código de verdad...
    @Test
    public void incrementarNumero() {
        Contador c1=new Contador("Contador1");
        c1.incrementar();
        int valorDevuelto = c1.getNumero();
        int valorEsperado = 1;
        Assert.assertEquals(valorEsperado, valorDevuelto);
    }
    // Compruebo que el método decrementar funciona correctamente

    @Test
    public void decrementarNumero() {
        Contador c1=new Contador("Contador1");
        c1.decrementar();
        int valorDevuelto = c1.getNumero();
        int valorEsperado = -1;
        Assert.assertEquals(valorEsperado, valorDevuelto);
    }
 
    // Compruebo el incrementar? No. ya lo he comprobado antes
    // Solo estoy comprobando el reseteo
    @Test
    public void resetearContador() {
        Contador c1=new Contador("Contador1");
        c1.incrementar();
        c1.resetear();
        int valorDevuelto = c1.getNumero();
        int valorEsperado = 0;
        Assert.assertEquals(valorEsperado, valorDevuelto);
    }
    
}
