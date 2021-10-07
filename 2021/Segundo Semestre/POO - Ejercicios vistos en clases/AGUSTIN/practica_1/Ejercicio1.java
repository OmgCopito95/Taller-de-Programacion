/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AGUSTIN.practica_1;
import PaqueteLectura.Lector;
/**
 *
 * @author Peirano-PC
 */
public class Ejercicio1
{

 
    public static void main(String[] args)
    {
        System.out.println("Escriba el valor para convertir en factorial: ");
        int N = Lector.leerInt(); //Lee por teclado la variable Integer N
        int aux = 1; //Iniciar la variable en 1 para ir multiplicando por el valor
        for (int i = 1; i <= N; i++){
            aux = aux * i; // Multiplicamos aux por i hasta llegar al numero ingresado en N
        }
        System.out.println("El factorial es: "+aux); //Imprime el valor 
        
        //DUDA: Cuando pongo   System.out.println("El factorial de: "+N+"es: "+aux); Me tira error

    }
    
}

