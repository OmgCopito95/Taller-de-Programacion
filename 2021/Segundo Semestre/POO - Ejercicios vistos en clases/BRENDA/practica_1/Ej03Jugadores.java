package BRENDA.practica_1;

//Paso 1: Importar la funcionalidad para lectura de datos
import PaqueteLectura.Lector;

/* Escriba un programa que lea las alturas de los 15 jugadores de un equipo de
básquet y las almacene en un vector. Luego informe:
- la altura promedio
- la cantidad de jugadores con altura por encima del promedio */
public class Ej03Jugadores {

    public static void main(String[] args) {
        //Paso 2: Declarar la variable vector de double
        double[] alturas;

        //Paso 3: Crear el vector para 15 double 
        int dimF = 15;
        alturas = new double[dimF];

        //Paso 4: Declarar indice 
        int i;

        //Paso 6: Ingresar 15 numeros (altura), cargarlos en el vector, ir calculando la suma de alturas
        double suma = 0;
        for (i = 0; i < dimF; i++) {
            System.out.println("Ingrese la altura del jugador " + (i + 1));
            alturas[i] = Lector.leerDouble();
            suma = suma + alturas[i];
        }

        //Paso 7: Calcular el promedio de alturas, informarlo
        double promedio = suma / dimF;
        System.out.println("El promedio de alturas es: " + promedio);

        //Paso 8: Recorrer el vector calculando lo pedido (cant. alturas que están por encima del promedio)
        int cantidadSobrePromedio = 0;

        for (i = 0; i < dimF; i++) {
            if (alturas[i] > promedio) {
                cantidadSobrePromedio++;
            }
        }

        //Paso 9: Informar la cantidad.
        System.out.println("La cantidad de jugadores con altura por encima del promedio es: " + cantidadSobrePromedio);
    }

}
