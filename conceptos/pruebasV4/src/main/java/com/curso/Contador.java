package com.curso;

public class Contador {
    
    private String nombre;
    private int numero;
    
    public Contador(String nombre){
        this.nombre=nombre;
        setNumero(0);
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    private void setNumero(int numero){
        this.numero=numero;
    }
    
    public int getNumero(){
        return this.numero;
    }
    
    public void incrementar(){
        setNumero(this.numero+1);
    }
    
    public void decrementar(){
        setNumero(this.numero-1);
    }
    
    public void resetear(){
        setNumero(0);
    }
}
