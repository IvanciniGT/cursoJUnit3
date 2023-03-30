package com.curso;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;


import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AppTest {
    
    private SuministradorDeDiccionarios suministrador ;
    
    //@AfterAll
    //@AfterEach
    //@BeforeEach
    @BeforeAll
    public void iniciarSuministardor(){
        suministrador = SuministradorDeDiccionariosFactory.getInstance();
    }
    
    @Test
    @DisplayName("Consultar diccionario de un idioma para el que hay diccionario")
    public void consultarDiccionarioExistente(){
       boolean valorDevuelto = suministrador.tienesDiccionarioDe("ES");
       Assertions.assertTrue(valorDevuelto);
    }
      
    @Test
    @DisplayName("Consultar diccionario de un idioma para el que NO hay diccionario")
    public void consultarDiccionarioNoExistente(){
       boolean valorDevuelto = suministrador.tienesDiccionarioDe("ELFOS");
       Assertions.assertFalse(valorDevuelto);
    }
    
    @Test
    @DisplayName("Recuperar diccionario de un idioma para el que hay diccionario")
    public void recuperarDiccionarioExistente(){
       String idioma = "ES";
       Optional<Diccionario> optionalDiccionario = suministrador.getDiccionario(idioma);
       Assertions.assertTrue(optionalDiccionario.isPresent());
       Assertions.assertEquals(idioma, optionalDiccionario.get().getIdioma());
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"manzana","Manzana","MANZANA","perro","Perro","PERRO"})
    @DisplayName("Consultar una palabra que existe en el diccionario")
    public void consultarPalabraExistente(String palabra){
       String idioma = "ES";
       Optional<Diccionario> optionalDiccionario = suministrador.getDiccionario(idioma);
       Diccionario diccionario = optionalDiccionario.get();
       boolean valorDevuelto = diccionario.existe(palabra);
       Assertions.assertTrue(valorDevuelto);
    }    
    
    @ParameterizedTest
    @ValueSource(strings = {"manana", "55555", "$%&/·"})
    @DisplayName("Consultar una palabra que NO existe en el diccionario")
    public void consultarPalabraInExistente(String palabra){
       String idioma = "ES";
       Optional<Diccionario> optionalDiccionario = suministrador.getDiccionario(idioma);
       Diccionario diccionario = optionalDiccionario.get();
       boolean valorDevuelto = diccionario.existe(palabra);
       Assertions.assertFalse(valorDevuelto);
    }
      
    @ParameterizedTest
    @CsvSource({"manzana,1,Fruto del manzano", "Perro,2,Animal de compañía"})
    @DisplayName("Obtener significados de una palabra que existe en el diccionario")
    public void significadosPalabraExistente(String palabra, int numeroSignificados, String primerSignificado){
       String idioma = "ES";
       Optional<Diccionario> optionalDiccionario = suministrador.getDiccionario(idioma);
       Diccionario diccionario = optionalDiccionario.get();
       Optional<List<String>> optionalSignificados = diccionario.getDefiniciones(palabra);
       
       Assertions.assertTrue(optionalSignificados.isPresent());
       Assertions.assertEquals(numeroSignificados, optionalSignificados.get().size());
       Assertions.assertEquals(primerSignificado, optionalSignificados.get().get(0));
    }
      
    @ParameterizedTest
    @CsvFileSource(resources="/palabrasExistentes.csv", numLinesToSkip=1)
    @DisplayName("Obtener significados de una palabra que existe en el diccionario (Desde un fichero)")
    public void significadosPalabraExistenteEnFichero(String palabra, int numeroSignificados, String primerSignificado){
       String idioma = "ES";
       Optional<Diccionario> optionalDiccionario = suministrador.getDiccionario(idioma);
       Diccionario diccionario = optionalDiccionario.get();
       Optional<List<String>> optionalSignificados = diccionario.getDefiniciones(palabra);
       
       Assertions.assertTrue(optionalSignificados.isPresent());
       Assertions.assertEquals(numeroSignificados, optionalSignificados.get().size());
       Assertions.assertEquals(primerSignificado, optionalSignificados.get().get(0));
    }
      
    @ParameterizedTest
    @ValueSource(strings = {"manana", "55555", "$%&/·"})
    @DisplayName("Significados de una palabra que NO existe en el diccionario")
    public void significadosPalabraInExistente(String palabra){
       String idioma = "ES";
       Optional<Diccionario> optionalDiccionario = suministrador.getDiccionario(idioma);
       Diccionario diccionario = optionalDiccionario.get();
       Optional<List<String>> optionalSignificados = diccionario.getDefiniciones(palabra);
       Assertions.assertFalse(optionalSignificados.isPresent());
    }
}
