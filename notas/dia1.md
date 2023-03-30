
# Pruebas de software

Los desarrolladores "ODIAMOS" las pruebas.
Lo cierto es que nos ENCANTAN las pruebas !!!

## Para qué sirven las pruebas?

- √ **Para verificar el cumplimiento de un requisito**
- √ Para descubrir la mayor cantidad posible de defectos en el código antes de ponerlo en producción
- √ Para descubrir la mayor cantidad posible de fallos en el código antes de ponerlo en producción
- x Para asegurarnos que el código está libre de errores: FALACIA !
- √ Conocer mejor nuestro producto:
    - Para mejorar el código (por ejemplo su rendimiento)
    - Para poder extraer enseñanzas que aplicar en futuros proyectos
- √ Para poder suministrar información a desarrollo que ayuden en la identificación de DEFECTOS < - Debugging
- √ Para identificar los errores y sus causas, para evitar errores futuros

## Vocabilario que empleamos en el mundo del testing

- ERROR     Un error es cometido por una persona
- DEFECTO   Al cometerlo introduce un DEFECTO en un producto (código)
- FALLO     Ese DEFECTO puede dar la cara en algún momento -> FALLO: Manifestación de un DEFECTO !

## Tipos de pruebas


### En base al nivel de la prueba

- Pruebas unitarias                 Se comprueba **UNA** CARACTERISTICA DE UN COMPONENTE **AISLADO** del sistema (función)      QUERY
- Pruebas de integración            Se comprueba **LA COMUNICACION** entre componentes                                          LATENCIA DE RED
- Pruebas de sistema (End2End)      Se comprueba **EL COMPORTAMIENTO** del sistema                                              SISTEMA da un tiempo adecuado
  - Pruebas de aceptación           Las que solicita el cliente final (suelen ser un subconjunto de las anteriores)

### Otra forma pararalela de clasificar las pruebas

- Pruebas estáticas                 Las que NO requieren poner el sistema o un componente en funcionamiento para su realización.
    - Revisión de calidad de código     Herramientas tipo Sonar (hoy en día)... hace 20 años... las hacía el desarrollador Senior
    - Revisión de requisitos
                                    > El sistema debe tener un redimiento adecuado, que permita su uso sin causar demoras a los usuarios. 
                                    > Tal petición/programa/función debe ejecuatrse en menos de 200ms !
                                    > El sistema/programa/función, instalado en un entorno con ESTAS CARACTERISTICAS
                                      y cometido a una carga de trabajo de X (la que se defina) debe realizar tal operación 
                                      con un percentil 95% inferior a 200ms

- Pruebas dinámicas                 Las que SI requieren poner el sistema o un componente en funcionamiento para su realización.
    - Pruebas funcionales           Se centran en la FUNCIONALIDAD
        - Pruebas de un API
        - Pruebas de una UI
    - Pruebas NO funcionales        Se centran en otros aspectos
        - Pruebas de rendimiento    Comprueba la velocidad (tiempos) que tarda algo en realizarse
        - Pruebas de estres         Cómo se degrada el sistema ante un uso prolongado en el tiempo
        - Pruebas de carga          Cómo se degrada el sistema ante GRANDES conjuntos de datos.
        - Pruebas de UX             Cómo de facil es usar un sistema por los usaurios


###

- Pruebas de caja blanca: Cuando conocemos los detalles de la implementación... y vamos buscando los casos especiales de la misma
   Generalmente estas las realizan los desarrolladores... que conocen el código
    AQUI ME ECHA UNA MANO EL SONARQUBE
    - Complejidad ciclomática: Cantidad de caminos que puede tomar un código
    - Complejidad cognitiva:   Cómo de complejo es para un ser humano entender un código

        Hace 20 años al que escribía el código más friki se le idolatraba... VAYA MAQUINA ... UOOOOOO
        Hoy en día está despedido al día sigiuente.... por pringao !!!!!


        // tarea 1
        if(condicion1){
            // tarea 2
            if(condicion2){
                // tarea 3
            }else{
                // tarea 4
            }
        }else if (condicion3){
            // tarea 5
            if(condicion4){
                // tarea6
            }else if (condicion5){
                // tarea7
            }
        }
        
        tarea 1 (condicion1) tarea 2 (condicion2) tarea3
        tarea 1 (condicion1) tarea 2 (!condicion2) tarea 4
        tarea 1 (!condicion1 && condicion3) tarea 5 (condicion 4) tarea 6
        tarea 1 (!condicion1 && condicion3) tarea 5 (!condicion 4 && condicion5) tarea 7
        tarea 1 (!condicion1 && condicion3) tarea 5 (!condicion 4 && !condicion5)
        tarea 1 (!condicion1 && !condicion3)
        
        
        Complejidad ciclomática? 6
        Complejidad cognitiva?  Alta
        
        switch(variable1){
            case 1:
                tarea 1
            case 2:
                tarea 2
            case 3:
                tarea 3
            case 4:
                tarea 4
            case 5:
                tarea 5
            case default:
                tarea 6
        }
        Complejidad ciclomática? 6          >>>>> Está condicionada por los requerimientos funcionales
            A qué me ayuda la complejidad ciclomática? Para que me vale el dato??? con respecto en particular a las pruebas?
            Es el MINIMO NUMERO DE PRUEBAS que debo realizar a un código
        Complejidad cognitiva?   Baja       >>>>> REFACTORIZACION

- Pruebas de caja negra:  Cuando NO CONOCEMOS los detalles de la implementación... y busco lo que se me ocurre que puede tener implicaciones
   Generalmente estas las realizan los testers... que no conocen el código.... Y LO SUELEN REVENTAR.

Hoy en día tan importante o MAS es que el sistema (software) esté bien construido como que se comporte adecuadamente.
Ya hemos sufrido años y años el poner sistemas en producción a cualquier coste... LA MANTENIBILIDAD en el futuro me come.
    -> REFACTORIZACION DE UN CODIGO

---

# La forma en la que hace 20 años o 15 gestionábamos un proyecto de software

¿Qué metodologías usábamos? Metodologías Waterfall o en cascada

No ha sido posible usar metodologçías en cascada en el mundo del software con éxito. ES UNA FALACIA !

Cuántas entregas hacíamos al cliente? Una al final. Al año.


# Las metodogías ágiles: SCRUM, Extreme programming

Un grupo muy respetado de desarrolaldores firman el manifiesto agil: agilemanifesto.org

Cúantas entragas hago al cliente? Cada 15 días o mes, o como mucho 45 días.
El producto lo entrego de forma incremental.
- A los 15 dias de comenzar hago la primera instalación en prducción. Instalación 100% funcional de mi sistema. 
  Quizás solo entrego el 10% de la funcionalidad
  > Necesito probar el 10% de los requerimientos

- A los 30 dias de comenzar hago la segunda instalación en prducción. Instalación 100% funcional de mi sistema. 
  Quizás solo entrego el +5% de la funcionalidad
  > Necesito probar el +5% de los requerimientos
  > Necesito probar el 10% anterior de los requerimientos (intentaré hacerle las mismas pruebas que ya tenía diseñadas) *Pruebas de regresión*

- A los 45 dias de comenzar hago la tercera instalación en prducción. Instalación 100% funcional de mi sistema. 
  Quizás solo entrego el +5% de la funcionalidad

Gracias a esto, consigo FEEDBACK muy rápido (RETROALIMENTACIÓN)

# Claro... que lo que no me cuentan en los cursos de SCRUM y de Agile es la contraparte...

Porque el adoptar estas forms de trabajo, ha tenido sus problemas, nuevos, que nos han aparecido!

¿Cántas veces instalaba antes en producción? 1
¿Y ahora? Cada 15 días.... 20-30 veces a lo largo del proyecto...
¿Y de donde saco la pasta para eso?

¿Cántas veces probaba antes? 1
¿Y ahora? Cada 15 días.... 20-30 veces a lo largo del proyecto...
Se me multiplican las pruebas!!!!!!!
¿Y de donde saco la pasta para eso?

ESTO SOLO TIENE UNA SOLUCION !!!! Cuál??? AUTOMATIZAR:
- Pruebas
- Instalaciones
- Compilación
- Empaquetado
- TODO LO QUE SEA AUTOMATIZABLE!!!!!

--- 

# DEV--->OPS

DEVOP no es un perfil, como lo es un desarrollador o un tester o el administrador de sistema. O al menos... no lo era.

Devops es una cultura, un movimiento en pro de la AUTOMATIZACION

El que despliega las cosas.

Queremos automatizar TODO el trabajo.

              AUTOMATIZABLE?                    HERRAMIENTAS
              
PLAN            Malamente
CODE            Cada día más                    Github copilot y similares
BUILD           √                               MAVEN, GRADLE, SBT
                                                MSBUILD DOTNET
                                                POETRY
                                                NPM, YARN
TEST            x Definición de la prueba
                √ Ejecución de la prueba        Junit / TestNG, Unittest, MSTest
                                                Selenium, Appium, SoapUI, Postman, Karate, Cypress, ReadyAPI
                                                JMeter, LoadRunner
                                                Sonarqube
                √ Tener un entorno de pruebas
                    √ Adquirir infraestructura. Clouds, Terraform, Vagrant
                    √ Planchar la infra         ansible, puppet, chef
RELEASE         √ Imagenes de contenedor        Docker, podman
DEPLYMENT       √
OPERATION       √   Kubernetes (K8S, Openshift, Tamzu)
MONITOR         √

Y si automatizo todas las tareas que soy capaz de automatizar (automatizables).... tengo ya todo automatizado?
o me falta algo? 
El lanzar esas tarea de forma ORQUESTADA ENTRE SI
A esto nos ayudan herramientas como: Los servidores de automatización: Jenkins, Teamcity, bamboo, TravisCI, Github actions, Gitlab CI/CD

Y hoy en día ya no tengo Administradores de sistemas que instalen en producción, testers que hagan pruebas....

Y una herrameinta como Jenkins, extraerá mi código de un repo de git (en cuantito yo haga commit),
lo compilará, empaquetará
instalará en un entorno de pruebas, lo probará
Y si todo va bien, se monta en producción.... SIN MEDIACION HUMANA.... y en 15 minutos

---

# JUNIT, TESTNG, UNITTES, MSTEST

Frameworks de pruebas ~~UNITARIAS~~

Desde el punto de vista de JUnit (y en general del resto de frameworks de pruebas... que todos copian a JUnit), al ejecutar una prueba
en qué estados puede acabar?
- OK (Success)
- NOK (failure)
    - Error (ostion mu' gordo que ha impedido la correcta ejecución de la prueba)

Estos estados a su vez, coinciden con los estados que usan los Testers para definir el resultado de una prueba:
- SUPERADA
- NO SUPERADA
    - NO SE PUDO EJECUTAR LA PRUEBA

JUnit tenía una versión que se usaba y usa aún (legacy) que es la 4...
Pero en un momento dado sacan la 5 (JUPITER)... y cambia todo!

---

## Framework vs librería.

Una librería es un conjunto de código (funciones, clases, interfaces) que puedo utilizar desde mi programa para realizar algunas operaciones.

Los framework suelen contener 1 o más librerías.

El framework impone una forma de códigocaciónpara usar las librerías.

---

# Versiones de software

                Cuándo se incrementan?
1.2.3
    ^ MICRO         Un arrelo de un bug (fix)
  ^ MINOR           Cuando se añade funcionalidad
^ MAYOR             Cuando hay un cambio que no respeta RETROCOMPATIBILIDAD

---

# MAVEN

Gestor de ciclo de vida de software y dependencias:
- Gestor de dependencias
- Compilar el código
- Ejecutar PRUEBAS del proyecto
- Generar INFORMES DE PRUEBAS
- Generar el artefacto (entregable) del proyecto
- Exportar ese artefacto a un registro de artefactos (nexus, artifactory)

Maven funciona mediante PLUGINS, que le aportan la funcionaldiad. Por defecto viene con unos cuantos cargados....
Y yo le puedo meter otros 500.

Los plugins los invoco mediante GOLES: Tareas concretas que queremos hacer sobre nuestro proyecto:
- compile           Compilar mi código java (src/main/java)... y el resultado dónde se lleva? target/classes
- test-compile      Compilar mi el código java de mis pruebas (src/test/java)... y el resultado dónde se lleva? target/test-classes
- test              Ejecuta los programas de prueba automatizados
                    Y genera un informe de pruebas, que se deja en? target/surefire-reports
- package           Empaqueta el proyecto en un .jar, .war, .ear, nada... y el resultado se deja en target
- install           Copia el artefacto al directorio ".m2". Es un directorio que crea maven en mi carpeta de usuario: c:\Users\MiUsuario\.m2
                                                                                                                      /home/miUsuario/.m2   
                    Para que proyecto pueda ser usado como dependencia en otros proyectos. 
                    A día de hoy esto lo hacemos MUCHISIMO
- clean             Borra la carpeta target

Maven nos impone (es configurable ... pero no lo cambiamos NUNCA JAMAS !!!) una determina estructura de carpetas para trabajar:

    proyecto:
      |- src/                       El código fuente del proyecto
      |   |- main/                  Código de la app/librería/sistema que monto
      |   |   |- java/              Código java de mi app
      |   |   |- resources/         Archivos de configuración y otros que puedan ser necesarios para la correcta ejecución de mi programa
      |   |   |- webapp/
      |   |- test/                  Código de los programas de prueba
      |       |- java/              Código java de las pruebas unitarias (u otro tipo de pruebas)
      |       |- resources/         Archivos de configuración y otros que puedan ser necesarios para la correcta ejecución de mis pruebas
      |- target/
      |   |- classes/
      |   |- test-classes/
      |   |- surefire-reports/
      |   |- artefacto
      |- pom.xml                    Configuración de las automatizaciones que voy a hacer sobre el proyecto

---

# J2EE > JEE

Java Enterprise Edition > Jakarta Enterprise Edition

Qué es esto? Especificación de cómo usar java para montar apps de caracter empresarial.
             + Librerias
                JMS
                JDBC
                JPA
                ...