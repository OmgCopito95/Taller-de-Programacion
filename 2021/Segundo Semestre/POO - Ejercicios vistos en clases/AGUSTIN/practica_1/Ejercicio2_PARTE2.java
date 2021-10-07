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
public class Ejercicio2 {

    /**
     * @param args the command line arguments
     */
    /*
    Utilizando la clase Persona (ya implementada). Realice un programa que almacene en
    un vector 15 personas. La información de cada persona debe leerse de teclado. Luego de
    almacenar la información:
     - Informe la cantidad de personas mayores de 65 años.
     - Muestre la representación de la persona con menor DNI.
     */
    public static void main(String[] args) {
        Persona[] vector = new Persona[15];
        int Menor = 9999;
        int GUARDAR_INDICE = 0;
        int Cant_Mayores = 0;
        int j = 0;
        for (int i = 0; i < 15; i++) {
            vector[i] = new Persona();

            System.out.println("Ingrese el nombre de la persona: ");
            vector[i].setNombre(Lector.leerString());

            System.out.println("Ingrese el DNI de la persona: ");
            vector[i].setDNI(Lector.leerInt());

            System.out.println("Ingrese la edad de la persona: ");
            vector[i].setEdad(Lector.leerInt());
//----> OJO QUE EL ENUNCIADO DICE QUE CARGUES EL VECTOR Y LUEGO INFORMES. LO IDEAL SERIA SEPARAR LA CARGA DEL PROCESAMIENTO DE DATOS            
            if (vector[i].getDNI() < Menor) //ES DECIR, ESTO EN OTRO FOR
            {
                GUARDAR_INDICE = i;
                Menor = vector[i].getDNI();
            }

            if (vector[i].getEdad() == 65) //ES DECIR, ESTO EN OTRO FOR
            {
                Cant_Mayores++;
            }
            System.out.println(vector[i].toString());
        }
        System.out.println(vector[GUARDAR_INDICE].toString());
        System.out.println("La cantidad de adultos mayores a 65 años son de " + Cant_Mayores);
    }
}
