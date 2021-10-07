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
public class Ejercicio4 {

    /**
     * @param args the command line arguments
     */
    /*
    Se realizará un casting para un programa de TV. El casting durará a lo sumo 5 días y en
    cada día se entrevistarán a 8 personas en distinto turno.
     */
    public static void main(String[] args) {

        Persona[][] casting = new Persona[5][8];
        String CORTE_NOMBRE = "ZZZ";
        int CUPOS = 0;
        int dia = 0;
        int P = 0;
        Persona persona = new Persona();
        System.out.println("Ingrese el nombre de la persona");
        persona.setNombre(Lector.leerString());

        while (CUPOS != 40 && !persona.getNombre().equals(CORTE_NOMBRE)) {
            if (P > 8) {
                dia++;
            }
            P++;
            CUPOS++; //PODRIAS HACERLO SIN USAR ESTA VARIABLE, CHEQUEANDO LAS FILAS Y LAS COLUMNAS, PERO IGUAL ESTA BIEN

            System.out.println("Ingrese el DNI de la persona: ");
            persona.setDNI(Lector.leerInt());

            System.out.println("Ingrese la edad de la persona: ");
            persona.setEdad(Lector.leerInt());

            casting[dia][P] = persona;

            System.out.println(casting[dia][P].toString());  //------> ESTO DEBERIA ESTAR APARTE DE LA CARGA DE LOS DATOS

        }

    }

}
