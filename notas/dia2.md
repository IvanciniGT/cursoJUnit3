mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4


Una prueba dinámica puede descubrir DEFECTOS en el código? NO
Una prueba dinámica descubre FALLOS!

Qué era un DEFECTO? La manifestación de un ERROR cometido por el desarrollador
Qué era un FALLO? La manifestación de un DEFECTO

Si la prueba dinámica identifica un FALLO...
A quién le toca identificar el DEFECTO? 
- Al desarrollador (a mi) <- Depurar (debugging)
    Y me lo quiero poner fácil? o dificil? FACIL 
    Y qué me interesa para ello? qué puedo hacer? Que la prueba que puede fallar,
    tenga un SCOPE muy pequeño. Qué esté probando lo mínimo posible
- A las pruebas estáticas... que lo que hacen es leer el código (algunos)
 
PRUEBA UNITARIA: Solo comprueba UNA UNICA CARACTERISTICA de un componente AISLADO

---

Metodología TDD?

Test Driven Development

Primero creo las pruebas y luego el código

A qué me ha ayudado hacer primero la prueba resetearContador
antes de haber escrito ningún código al respecto?
- Ayudar a entender la función que debo montar ( y su comportamiento)
- A definir el API y validarlo
    (la definición de mis funciones, con sus argumentos y valores devueltos)


---
El software funcionando es la **medida principal de progreso**.

Hace 20 años, cuando usábamos metodologías tradicionales (waterfall),
cómo sabía el jefe de proyecto, qué tal íbamos?
¿Qué forma tenía el jefe de proyecto de MEDIR el PROGRESO del proyecto?
Le preguntaba al desarrollador
Contar el número de lineas que había escrito un desarrollador a la semana

Hoy en día cómo se mide el grado de avance de un proyecto?
Lo que miro es el incremento en el número de pruebas pasadas!
SOFTWARE FUNCIONANDO = Que funciona... y quién dice que funciona? Las pruebas

---

La simplicidad, o el arte de maximizar la cantidad de trabajo no realizado, 
es esencial.

Hace 20 años, estaba considerado una buena práctica el dejar cositas 
preparadas en el código... por si acaso!
Hoy en día eso se considera una MUY MALA PRACTICA !
No escribo NI UNA SANTA LINEA MAS DE CODIGO DE LAS QUE NECESITO EN MI PROGRAMA

Y quién me dice lo que necesito? Las pruebas que HAYA HECHO
Cuanto código tengo que escribir? 
El necesario para superar las pruebas. PUNTO PELOTA ! PERIOD
Esto está muy relacionado con las metodologías TDD

