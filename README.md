## **Escuela Colombiana de Ingeniería**
## **Arquitecturas de Software - ARSW**
#### Ejercicio Introducción al paralelismo - Hilos - Caso BlackListSearch

### Integrantes:

- Camilo Rincón
- Leonardo Galeano

#### **Parte I - Introducción a Hilos en Java**

1. De acuerdo con lo revisado en las lecturas, complete las clases CountThread, para que las mismas definan el ciclo de vida de un hilo que imprima por pantalla los números entre A y B.
2. Complete el método __main__ de la clase CountMainThreads para que:

	- Cree 3 hilos de tipo CountThread, asignándole al primero el intervalo [0..99], al segundo [99..199], y al tercero [200..299].
	
	- Inicie los tres hilos con 'start()'.
	
	- Ejecute y revise la salida por pantalla: 
	
	La ejecución de los hilos de esta forma resulta en una salida de números desordenada.
	
	![start](https://github.com/Ersocaut/ARSW-Lab01/blob/master/img/ThreadStart.png)

	- Cambie el incio con 'start()' por 'run()'.¿Cómo cambia la salida?¿Por qué?: 
	
	La salida cambia completamente, pues al iniciarse un Thread con start() sí se genera un hilo como tal, mientras que al hacerlo con run() únicamente se llama a ese método, no se inicia un hilo como tal.
	
	![run](https://github.com/Ersocaut/ARSW-Lab01/blob/master/img/ThreadRun.png)
	
