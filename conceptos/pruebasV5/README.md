
# Libreria: Diccionario

Podemos solicitar a la libreria es un Diccionario de un determinado Idioma

Si lo tiene, lo entrega. 

Y a partir de ese momento podemos preguntarle cosas al Diccionario

- Si tiene registrada o no una palabra
- Si la tiene, que nos ofrezca sus significados
- Si no la tiene, que me proponga alternativas:
    manana 
        mañana
        manzana
        manzano

---
PRUEBAS

Comprobar si indica que si hay diccionario cuando se solicita un idioma para el que hay diccionario


    boolean existencia = SuministradorDeDiccionarios.tienesDiccionario("ES")
    existencia == true

    VAMOS A TENER UN DICCIONARIO DE ESPAÑOL

Comprobar si indica que no hay diccionario cuando se solicita un idioma para el que no hay diccionario


    boolean existencia = SuministradorDeDiccionarios.tienesDiccionario("DE LOS ELFOS")
    existencia == false

    NO VAMOS A TENER UN DICCIONARIO DE LOS ELFOS

Comprobar si se devuleve un diccionario cuando se solicita un idioma para el que hay diccionario


    Optional<Diccionario> dict = SuministradorDeDiccionarios.dameDiccionario("ES")
    dict != null              **** MIERDA GIGANTESCA... RUINA ABSOLUTA.... LA PEOR PRACTICA DEL MUNDO !!!
    dict.isPresent()
    dict.get().getIdioma() == "ES"
    
    Una función no debería devolver nulo..... y eso? Pero hasta java 8 no había buenas alternativas
    De acuerdo?         IIII
    No de acuerdo?      I
    No se?              III

    interface SuministradorDeDiccionarios{
        ...
        Optional<Diccionario> dameDiccionario(String idioma);
        
        Qué puede devolver?
            Un Optional vacio
            Un Optional con un Diccionario
            
        Diccionario dameDiccionario(String idioma);
        NPI si puede devolver null... donde lo miro? En el código... tengo acceso a él? ????
                                                     Y si no... lo miro en la Documentación... En serio???? en el 2023???
        
        // Y si el idioma es el de los elfos? que devuelvo? 
                        COSAS BUENAS                                                        COSAS MALAS
        - Exception     Que queda explicitado en el enunciado el comportamiento     Nunca se debe usar una Excepcion para controlar LOGICA DE LA APP
        - null          Que evito usar una exception                                No queda explicitado en la definición de la función el comportamiento
        
    }

Comprobar si no se devuleve un diccionario cuando se solicita un idioma para el que no hay diccionario

    Optional<Diccionario> dict = SuministradorDeDiccionarios.dameDiccionario("DE LOS ELFOS")
    dict.isEmpty()

Comprobar si una palabra está registrada. YA PUESTOS... Busco sólo la palabra "mañana"?
                                                        O mejor... busco 6 o 7?
    # Varias... con algún criterio. 1 significado... con muchos....


    Diccionario dict = SuministradorDeDiccionarios.dameDiccionario("ES").get();
    

    boolean existe = dict.existe("mañana");
    existe == true

    boolean existe = dict.existe("Mañana");
    existe == true

    boolean existe = dict.existe("MAÑANA");
    existe == true
        
    boolean existe = dict.existe("MAÑANA ");
    existe == true

    class DiccionarioImpl implements Diccionario{
        
        private Map<String,List<String>> terminosExistentes;
        ...
        public boolean existe(String palabra){
            return terminosExistentes.containsKey(Utilidades.normalizarPalabra(palabra));
        }
        
    }
    
Comprobar si una palabra no está registrada


    Diccionario dict = SuministradorDeDiccionarios.dameDiccionario("ES").get();
    

    boolean existe = dict.existe("manana");
    existe == false

Comprobar que podemos recuperar los significados de una palabra existente.... Cuantas probamos?
    # Varias... con algún criterio. 1 significado... con muchos....
    # Sabeis que estamos haciendo aquí? Pruebas de caja negra

    Diccionario dict = SuministradorDeDiccionarios.dameDiccionario("ES").get();
        
    Optional<List<String>> significados = dict.dameSignificados("mañana");
    significados.isPresent()
    significados.get().size()  == 2
        Y miro los que devuelve.... que sean los correctos

    DATOS
    -------------
    manzana -> 1 -> Futro del manzano
    mañana=Hoy no... mañana|Primera parte de la jornada
    manzano=Arbol frutal
    zapato=Para los pies
    
Comprobar que no podemos recuperar los significados de una palabra que no existe

    Diccionario dict = SuministradorDeDiccionarios.dameDiccionario("ES").get();
        
    Optional<List<String>> significados = dict.dameSignificados("manana");
    significados.isEmpty()

    DATOS
    -----------
    manana
    calcetín
    federico
    
Comprobar que podemos pedir alternativas para una palabra

    Diccionario dict = SuministradorDeDiccionarios.dameDiccionario("ES").get();
        
    List<String> alternativas = dict.dameAlternativas("manana");
    alternativas.size == 5

    List<String> alternativas = dict.dameAlternativas("A34234SDKHFA)=(=·JNLQW234ED)=(·$KLFDE)=(·)");
    - Encontraría ninguna alternativa
        alternativas.size=0

    DATOS
    ---------
    manana -> 3
    A34234SDKHFA)=(=·JNLQW234ED)=(·$KLFDE)=(·) -> 0
    zapata -> 1

Qué datos necesito para hacer las pruebas?
Diccionario... EL CONTENIDO LO DEFINO YO QUE HAGO LAS PRUEBAS

DICCIONARIO DE ES
Que tendrá la palabra manzana=Futro del manzano
                      mañana=Hoy no... mañana|Primera parte de la jornada
                      manzano=Arbol frutal
                      zapato=Para los pies
                      
                      
----
Libreria 
    groupId :   com.curso
    artifactID: diccionario
    version: 1.0.0
    
Ofrece, expone un API
    Interfaz Diccionario
    Interfaz SuministradorDeDiccionarios
    
    DiccionarioImpl.java ??? Me importa eso? NO
    SuministradorDeDiccionariosImpl.java ???? Me importa eso? NO
        ^^^ Como se llama a ese concepto en programación Orientada a Objetos? 
                Inversión de dependencias.
                

Alguien externo que usase esta librería, 
tendría que tener constancia de las clases que implementan las interfaces????

Mi proyecto...
    Mi proyecto tiene una dependencia con la libreria: diccionario

    import SuministradorDeDiccionariosFactory; // YA no dependo de clases de la libreria: GENIAL !!!
                                               // Bien hecho, buena práctica
    import SuministradorDeDiccionariosImpl; // He destrozado el Principio de Inversión de dependencias
                                            // ES UNA PRACTICA HORRIBLE en programación 
    ...
    YO , clase de MiProyecto, soy el responsable de generar una instancia del Suministrador de diccionarios?
        NO... me la dan... cuando llamo a la factoria... << Inyección de dependencias
        La inyeccion de depenencias va de la mano para conseguir la Inversión de dependencias.
    SuministradorDeDiccionarios miSuministradorDeDiccionarios = SuministradorDeDiccionariosFactory.dameSuministrador();
    Diccionario dict = miSuministradorDeDiccionarios.dameDiccionario("ES")
    dict.exite("jamón")
    dict.dameSugerencias("jamon")