
package CARO_SANTA_MARIA.practica_1;

//Paso 1: Importar la funcionalidad para lectura de datos
import PaqueteLectura.Lector;

/*
Escriba un programa que lea las alturas de los 15 jugadores de un equipo de
básquet y las almacene en un vector. Luego informe:
- la altura promedio
- la cantidad de jugadores con altura por encima del promedio
*/

public class Ej03Jugadores {

  
    public static void main(String[] args) {
        //Paso 2: Declarar la variable vector de double 
        double [] vAlturas;
        //Paso 3: Crear el vector para 15 double 
        vAlturas = new double[15];  //0-14
        //Paso 4: Declarar indice 
        double sumaTotal = 0;
        //Paso 6: Ingresar 15 numeros (altura), cargarlos en el vector, ir calculando la suma de alturas
        for (int i = 0; i <= 14; i++) {
            System.out.print("Ingrese altura del jugador " + i + ": ");
            vAlturas[i] = Lector.leerDouble();
            sumaTotal = sumaTotal + vAlturas[i];
        }
        //Paso 7: Calcular el promedio de alturas, informarlo
        double promedio = sumaTotal / 15;
        System.out.println("El promedio de alturas es de " + promedio);
        //Paso 8: Recorrer el vector calculando lo pedido (cant. alturas que están por encima del promedio)
        int mayorQuePromedio = 0;
        for (int i = 0; i < 15; i++) {
            if (vAlturas[i] > promedio) {
                mayorQuePromedio++;
            }
        }
        //Paso 9: Informar la cantidad.
        System.out.println(mayorQuePromedio + " jugadores tienen una altura mayor que el promedio");
    }
    
}
