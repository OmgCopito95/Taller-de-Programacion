/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CHECHU.practica_1;

/**
 *
 * @author july-
 */
public class ejercicios {

    /*
 *1- Escriba un programa que imprima en consola el factorial de un número N
(ingresado por teclado, N > 0). Ejemplo: para N=5 debería imprimir 5! = 120
 */
package tema1;

/**
 *
 * @author Cecilia Marfia
 */

public class Ejer1Practica {

    /**
     * @param args the command line arguments
     */
        public static void main(String[] args) {
    int factorial;
        for (int i = 1; i <= 9; i++) { //desde 1 hasta 9
            factorial = 1; //inicializo el factorial
            for (int j = i; j > 0; j--) //dentro de este for voy a ir calculando los factorial
                factorial = factorial * j;
            System.out.println("Factorial de " + i + ": " + factorial);
        }
    }
}
    
/* Para imprimir solo numeros impares:

    public static void main(String[] args) {
        int i, factorial = 1;
        for (i = 1; i <= 9; i++) {
            for (int j = i ; j > 0 ; j-2)
                factorial = factorial * j;
            System.out.println("Factorial de " + i + ": " + factorial);
        }
    }
*/


/////////////////////////////////////EJERCICIO 2//////////////////////////////////////////////////

/*
 * 2- Escriba un programa que imprima en consola el factorial de todos los números
entre 1 y 9. ¿Qué modificación debe hacer para imprimir el factorial de los
números impares solamente?

 */
package tema1;

import PaqueteLectura.Lector;

/**
 *
 * @author Martin Marfia
 */
public class Ejer2Practica {
    public static void main(String[] args) {
    int factorial;
        for (int i = 1; i <= 9; i++) {
            factorial = 1;
            for (int j = i; j > 0; j--)
                factorial = factorial * j;
            System.out.println("Factorial de " + i + ": " + factorial);
        }
    }
}
    
/* Para imprimir solo numeros impares:

    public static void main(String[] args) {
        int factorial;
        for (int i = 1; i <= 9; i++) {
            factorial = 1;
            for (int j = i; j > 0; j--) //desde i voy bajando hasta llegar a 1
                factorial = factorial * j; //calculo del factorial
            if (i % 2 != 0) //si no es par... que imprima
                System.out.println("Factorial de " + i + ": " + factorial);
        }
    }
*/
//////////////////////////EJERCICIO 3 ////////////////////////////////////////
 

/*
3- Escriba un programa que lea las alturas de los 15 jugadores de un equipo de
básquet y las almacene en un vector. Luego informe:
- la altura promedio
- la cantidad de jugadores con altura por encima del promedio
NOTA: Dispone de un esqueleto para este programa en Ej03Jugadores.java
 */
package tema1;

/**
 *
 * @author Cecilia Marfia
 */
import PaqueteLectura.GeneradorAleatorio; //importo paquete de lectura para que me genere los numeros
public class Ejer3Practica { 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        final int DIMF = 15; // DIMF es una constante para la dimension fisica
        double [] vectorAlturas; // declaro el vector que contendra valores reales, por eso double
        vectorAlturas = new double [DIMF]; // creo el vector de alturas con DIMF posiciones que guarda reales
        int nRandom, cantJugadores = 0; //inicializo las variables en 0
        double sumaAlturas =0, promedio;
        GeneradorAleatorio.iniciar(); //iniciali generador de aleatorios
        for(int i = 0; i < DIMF; i++){ //voy contando desde n hasta 1   
            nRandom = GeneradorAleatorio.generarInt(10);
            System.out.println("ALTURA DEL JUGADOR " + i + ": " + nRandom);
            vectorAlturas[i] = nRandom; //guardo la altura en la posicion i
            sumaAlturas += vectorAlturas[i]; // seria como sumaAlturas = sumaAlturas+ vectorAlturas[i];   //HACERLO CUANDO SE VA A PROCESAR LA INFO
        } 
        
        i=i+1
        i+=1
        i++
        
        System.out.println("SUMA TOTAL DE LAS ALTURAS: " + sumaAlturas);
        promedio = sumaAlturas/DIMF; //calculo el promedio
        System.out.println("ALTURA PROMEDIO: " + promedio);
        for(int i=0; i<DIMF;i++){ //acá voy a ir comparando si las alturas superan el promedio para informarlas
            if ( vectorAlturas[i] > promedio){
                cantJugadores ++; }
      
            
    }
        System.out.println("CANTIDAD DE JUGADORES CON ALTURA POR ENCIMA DEL PROMEDIO: "+cantJugadores);} //imprime cantidad de jugadores con altura por encima del promedio
    }   
    
//////////////////////////////////EJERCICIO 4///////////////////////////////////////////
 

package tema1;

/*
4- Escriba un programa que defina una matriz de enteros de tamaño 10x10.
Inicialice la matriz con números aleatorios entre 0 y 200.
Luego realice las siguientes operaciones:
- Mostrar el contenido de la matriz en consola.
- Calcular e informar la suma de todos los elementos almacenados entre las
filas 2 y 9 y las columnas 0 y 3
- Generar un vector de 10 posiciones donde cada posición i contiene la suma
de los elementos de la columna i de la matriz.
- Lea un valor entero e indique si se encuentra o no en la matriz. En caso de
encontrarse indique su ubicación (fila y columna) en caso contrario
imprima “No se encontró el elemento”.
NOTA: Dispone de un esqueleto para este programa en Ej04Matrices.java
package tema1; */

/**
 *
 * @author Cecilia Marfia
 */
import PaqueteLectura.GeneradorAleatorio; //importo paquete de lectura para que me genere los numeros enteros
import PaqueteLectura.Lector; //importo paquete de lectura para leer
public class Ejer4Practica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int DIMF= 10;  // defino constante para cantidad de filas
        int DIMC = 10; // defino constante para cantidad de columnas
        int [][] matriz; // declaro la matriz de enteros de 10x10
        matriz = new int [DIMF][DIMC]; // creo la matriz con DIMF filas y DIMC columnas que guardan enteros
        
        GeneradorAleatorio.iniciar(); //inicializo generador de aleatorios
        
        int i,j; //indice para los for
        for(i=0;i<DIMF;i++){ //para recorrer la fila
            for(j=0;j<DIMC;j++){ //para recorrer la columna
                matriz[i][j]=GeneradorAleatorio.generarInt(201); //cargo la matriz con numeros random e/0 y 200
                System.out.println ("FILA " + i + " COLUMNA " + j + ": " + matriz[i][j]); //imprimo la matriz
            }
            System.out.println ("_________________________");
        }
        int sumaElementos =0; //declaro variable para la suma en 0 de todos los elementos almacenados entre las filas 2 y 9 y las columnas 0 y 3
        for(i=2;i<DIMF;i++){ //para recorrer la fila
            for(j=0;j<4;j++){ //para recorrer la columna
                sumaElementos += matriz[i][j];
                
            }
        }
        System.out.println ("LA SUMA DE ENTRE FILAS 2 Y 9 Y LAS COLUMNAS 0 Y 3 ES : " + sumaElementos); //imprimo la suma
        
        int [] vector; // declaro el vector que contendra valores enteros
        vector = new int [DIMF]; // creo el vector con DIMF(10) posiciones
        
        for (j = 0; j < DIMC; j++) { //Me paro en la columna J y sumo todo lo que hay en I
            int sumaColumna=0; //en esta variable sumo los elementos de la columna 
            for (i = 0; i < DIMF; i++) { //me muevo en i para ir sumando
                sumaColumna = sumaColumna + matriz[i][j];
            }
            vector[j] = sumaColumna; //Me paro en la columna J y sumo todo lo que hay en I
        }
        for (j = 0; i < DIMF; i++){
        System.out.println("El vector en " + j + "contiene: " + vector[j]);// imprimo el contenido del vector para comprobar si la carga se hizo bien, no lo pide la consigna
        }
         boolean found = false; // declaro variable booleana para indicar si se encontro un elemento o no
        System.out.print ("INGRESE UN NÚMERO ENTERO: " ); 
        int nEntero = Lector.leerInt();
        for(i=0;i<DIMF;i++){ //para recorrer la fila
            for(j=0;j<DIMC;j++){ //para recorrer la columna
                if (matriz[i][j]== nEntero){ // compruebo si encontre el numero que ingrese
                found = true; // actualizo booleano
                System.out.println ("FILA " + i + " COLUMNA " + j +"CONTIENE AL ENTERO: " + nEntero); //imprimo si la fila lo contiene
                }
            }
        }
             if (!found) //si no lo encontré informo que no se encontró el elemento
            System.out.println("No se encontro el elemento");
       
    }
    
}
    
}


/*- Un edificio de oficinas está conformado por 8 pisos y 4 oficinas por piso. Realice
un programa que permita informar la cantidad de personas que concurrieron a
cada oficina de cada piso. Para esto, simule la llegada de personas al edificio de la
siguiente manera: a cada persona se le pide el nro. de piso y nro. de oficina a la cual
quiere concurrir. La llegada de personas finaliza al indicar un nro. de piso 9. Al
finalizar la llegada de personas, informe lo pedido.
 */
package tema1;

import PaqueteLectura.GeneradorAleatorio; //importo paquete de lectura para que me genere los numeros enteros

/**
 *
 * @author Cecilia Marfia
 */
public class Ejer5Practica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int DIMF= 8;  // defino constante para cantidad de filas - PISOS
        int DIMC = 4; // defino constante para cantidad de columnas - OFICINAS
        int [][] matriz; // declaro la matriz de enteros de 8x4
        matriz = new int [8][4]; // creo la matriz con DIMF filas y DIMC columnas que guardan enteros
                    0-7     0-3
        
        matriz[8][2]   
        
        // inicializo la matriz, ES NECESARIO? 
        int i, j;
        for (i = 0; i <DIMF; i++){
            for (j = 0; j < DIMC; j++)
                matriz[i][j] = 0;
        } // del for
        
        
        GeneradorAleatorio.iniciar(); //inicializo generador de aleatorios
        
        int nroPiso = GeneradorAleatorio.generarInt(10); // incluyo el 9 para que ingrese la condicion de corte
        System.out.println("Piso: "+ nroPiso);
        int nroOfi = GeneradorAleatorio.generarInt(4); // de 0 a 4
        System.out.println("Oficina: "+ nroOfi);        
        
        while (nroPiso != 9) { 
            //VERIFICAR QUE NO SE INGRESE EL PISO 8
            matriz[nroPiso][nroOfi] += 1;
            nroPiso = GeneradorAleatorio.generarInt(10);  //para la siguiente iteracion
            System.out.println("Piso: "+ nroPiso);
            nroOfi = GeneradorAleatorio.generarInt(4); //para la siguiente iteracion
            System.out.println("Oficina: "+ nroOfi);  
        }  
        
            for (i=0; i<DIMF ;i++){  //Informo cantidad de personas que concurrieron a cada oficina de cada piso       
                for(j=0; j<DIMC ;j++){
                System.out.println("Cantidad de personas que concurrieron a la oficina " + j + " en el piso " + i + ": " + matriz[i][j]);            
                }
                System.out.println ("_________________________");
            
          }
    } // del main
    
} // de la clase