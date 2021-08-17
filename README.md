## **Escuela Colombiana de Ingeniería**
## **Arquitecturas de Software - ARSW**
#### Ejercicio Introducción al paralelismo - Hilos - Caso BlackListSearch

### Integrantes:

|     Nombre    |     Git         |
|--------------|------------- | 
| Camilo Rincón|[Rincon10](https://github.com/Rincon10 )  |
|Galeano Garzón |[Ersocaut](https://github.com/Ersocaut)   |

#### **Parte I - Introducción a Hilos en Java**

1. De acuerdo con lo revisado en las lecturas, complete las clases CountThread, para que las mismas definan el ciclo de vida de un hilo que imprima por pantalla los números entre A y B.
    * Se completo la clase <b>CountThread</b> de tal manera que la clase tenga como atributos el limite superior e inferior del intervalo a imprimir, además de esto la clase debe heredar de la clase <i><b>Thread</b></i>.

![CountTHread](https://github.com/Ersocaut/ARSW-Lab01/blob/master/img/CountThread.jpg)

2. Complete el método __main__ de la clase CountMainThreads para que:

	- Cree 3 hilos de tipo CountThread, asignándole al primero el intervalo [0..99], al segundo [99..199], y al tercero [200..299].
        * Creacion de los tres hilos
        
    ![Hilos](https://github.com/Ersocaut/ARSW-Lab01/blob/master/img/hilos.jpg)
            	
	- Inicie los tres hilos con 'start()'.
	
	- Ejecute y revise la salida por pantalla: 
	    - Para la ejecución del programa se utilizo la siguiente linea de comandos:
	    ```
	    mvn package -U
	    mvn exec:java -Dexec.mainClass="edu.eci.arsw.threads.CountThreadsMain"
	    ```
	
	La ejecución de los hilos realizando <b>.start()<b/> resulta en una salida de números desordenada.
	
	![start](https://github.com/Ersocaut/ARSW-Lab01/blob/master/img/ThreadStart.png)

	- Cambie el incio con 'start()' por 'run()'.¿Cómo cambia la salida?¿Por qué?: 
	
	La salida cambia completamente, pues al iniciarse un Thread con start() sí se genera un hilo como tal, mientras que al hacerlo con run() únicamente se llama a ese método, no se inicia un hilo como tal.
	
	![run](https://github.com/Ersocaut/ARSW-Lab01/blob/master/img/ThreadRun.png)
	
	**Al iniciarse con start():** <br> 
	Inicia un Thread1 y su tarea, en los pocos milisegundos se inicia también el Thread2, asímismo el Thread3, lo que hace que los 3 esten funcionando al mismo tiempo, generando el cambio en la salida, esto se debe a que se esta creando un nuevo hilo, este se vuelve ejecutable y comienza su vida.
	
	**Al llamarse el método run():** <br>
	se ejecuta Thread1.run() se espera a que termina, llama a Thread2.run() este termina y finalmente llama a Thread3.run(), esto a que no se esta creando directamente un hilo.
	
	
#### **Parte II - Ejercicio Black List Search**

Como se puede observar se modificó el código de tal forma que fueran los threads los cuales revisaran en un rango específico de las diferentes listas negras, para esto se creó una nueva clase llamada <b><i>BlackListThread</i></b>.

##### Clase Thread
![threadClass](https://github.com/Ersocaut/ARSW-Lab01/blob/master/img/threadClass.jpg)

##### Metodo Check
En este metodo se utiliza la solucion "divide y venceras",esto ya que se esta haciendo que no sea el metodo el que revise todas las listas existentes, si no que sean los threads los que revisen de manera concurrente diferentes rangos de todas las listas negras. 

![checkMethod](https://github.com/Ersocaut/ARSW-Lab01/blob/master/img/checkMethod.jpg)


#### **Parte II.I Discusión**
<p style="text-align:justify">
La estrategia de paralelismo antes implementada es ineficiente en ciertos casos, pues la búsqueda se sigue realizando aún cuando los N hilos (en su conjunto) ya hayan encontrado el número mínimo de ocurrencias requeridas para reportar al servidor como malicioso. Cómo se podría modificar la implementación para minimizar el número de consultas en estos casos?, qué elemento nuevo traería esto al problema?
</p>

<p style="text-align:justify">
Para evitar que se sigan realizando validaciones de manera innecesaria se podría colocar una variable común (global) entre los threads, ya que esta permitiría que todos los threads sepan y puedan verificar dicha variable y parar cuando se encuentre el número mínimo de ocurrencias requeridas para reportar al servidor como malicioso, claramente no es tan sencillo, ya que para que esta nueva idea funcione se debe garantizar siempre <b>la exclusión mutua</b> la cual dice que se puede usar un recurso por un thread a la vez, cuando el recurso es solicitado de forma simultánea por varios threads este debe ser concedido a uno de ellos en un tiempo finito y liberarlo para que el siguiente en la fila lo tome.
</p>>

       

#### **Parte III - Evaluación de Desempeño**

* Para la ejecución del programa se utilizo la siguiente linea de comandos:
	```
	mvn package -U
        mvn exec:java -Dexec.mainClass="edu.eci.arsw.blacklistvalidator.Main"
        ```

1.    1 solo hilo.

![1ThreadExec](https://github.com/Ersocaut/ARSW-Lab01/blob/master/img/Exec1Thread.jpg)
<br>
![1ThreadA](https://github.com/Ersocaut/ARSW-Lab01/blob/master/img/1ThreadA.png)

2.    Tantos hilos como núcleos de procesamiento (haga que el programa determine esto haciendo uso del [API Runtime](https://docs.oracle.com/javase/7/docs/api/java/lang/Runtime.html).
	
En este caso para saber cuantos nucleos de procesamiento tenemos usaremos la clase Runtime y con el metodo <i> <b> availableProcessors() </i> </b> sabremos el numero de nucleos de procesamiento que hay disponible en la maquina virtual de java  
    
![Runtime](https://github.com/Ersocaut/ARSW-Lab01/blob/master/img/RunTime.jpg)
<br>    
![availableProcessors](https://github.com/Ersocaut/ARSW-Lab01/blob/master/img/aP.jpg) <br>
<br>
    8 hilos                                                                                                             
<br>
![8ThreadsExec](https://github.com/Ersocaut/ARSW-Lab01/blob/master/img/Exec8Threads.jpg)
<br> 
![CoreThreadA](https://github.com/Ersocaut/ARSW-Lab01/blob/master/img/CoreThreadA.png)
    
3.    Tantos hilos como el doble de núcleos de procesamiento, 16 hilos.
	
![16ThreadsExec](https://github.com/Ersocaut/ARSW-Lab01/blob/master/img/Exec16Threads.jpg)
<br>
![DobleCoreThreadA](https://github.com/Ersocaut/ARSW-Lab01/blob/master/img/DobleCoreThreadA.png)

4.    50 hilos.

![50ThreadsExec](https://github.com/Ersocaut/ARSW-Lab01/blob/master/img/Exec50Threads.jpg)
<br>
![50Threads](https://github.com/Ersocaut/ARSW-Lab01/blob/master/img/50Threads.png)

5.    100 hilos.

![100ThreadsExec](https://github.com/Ersocaut/ARSW-Lab01/blob/master/img/Exec100Threads.jpg)
<br>
![100Threads](https://github.com/Ersocaut/ARSW-Lab01/blob/master/img/100Threads.png)

Con lo anterior, y con los tiempos de ejecución dados, haga una gráfica de tiempo de solución vs. número de hilos. Analice y plantee hipótesis con su compañero para las siguientes preguntas (puede tener en cuenta lo reportado por jVisualVM):
#### **Parte IV - Ejercicio Black List Search**

