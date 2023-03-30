import java.util.function.*;

public class Funcional {
    
    public static void main(String[] args){
        
        int numero = 7;
        String texto = "Hola";
        texto = "Adios";
        // En este punto el objeto "HOLA" ha quedado sin nadie que le apunte... 
        // y se ha convertido en BASURA! GARBAGE... ocupando espacio en ram
        // Y ya se encargará de eliminiar ese objeto el GARBAGE COLLECTOR
        // Asigna la variable texto al valor "hola"

        // "Hola" -> Colocar un objeto de Tipo String con valor "hola" en RAM
        // String texto -> Define una variable llamada "texto" que es de tipo String???
        //               Que no se puede asignar a valores que no sean String???
        Function<Integer, Integer> mifuncion=Funcional::doblar;
        
        System.out.println(mifuncion.apply(3));
        
        imprimirResultado(mifuncion, 10);
    }
    
    public static void imprimirResultado(Function<Integer, Integer> operacion, int numero){
        System.out.println(operacion.apply(numero));
    }
    
    public static int doblar(int numero){
        return numero*2;
    }
    
}