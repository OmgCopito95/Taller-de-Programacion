/*/* 4- Se realizará un casting para un programa de TV. El casting durará a lo sumo 5 días y en
cada día se entrevistarán a 8 personas en distinto turno.

a) Simular el proceso de inscripción de personas al casting. A cada persona se le pide
nombre, DNI y edad y se la debe asignar en un día y turno de la siguiente manera: las
personas primero completan el primer día en turnos sucesivos, luego el segundo día y así
siguiendo.
La inscripción finaliza al llegar una persona con nombre “ZZZ” o al cubrirse los 40 cupos de casting.

Una vez finalizada la inscripción:
b) Informar para cada día y turno el nombre de la persona a entrevistar.
 */
package CHECHU.practica_2;

import BRENDA.practica_1.Persona;
import PaqueteLectura.Lector; //importo paquete de lectura para leer

public class Ejer4SegParteChechu {

    public static final int DIMF = 5; // DIAS - DIMF DE FILAS
    public static final int DIMC = 8; // TURNOS - DIMF DE COLUMNAS
    public static final String FIN = "ZZZ"; // CONDICION DE CORTE 

    public static void main(String[] args) {
        Persona matriz[][] = new Persona[DIMF][DIMC]; //declaro la matriz que contiene en cada celda el objeto PERSONA

        for (int i = 0; i < DIMF; i++) // FILAS
        {
            for (int j = 0; j < DIMC; j++) // COLUMNAS
            {
                matriz[i][j] = null; // inicializo cada celda en null = "VACIO"
            }
        }
        //------INSCRIPCION DE LOS PARTICIPANTES--------
        System.out.println("NOMBRE: ");
        String nombre = Lector.leerString();
        int dimLC = -1, dimLF = -1; // INICIALIZO DIMENSIONES LOGICAS (INDICES)
        while (!nombre.equals(FIN) && (dimLF < DIMF)) { // EL STRING NO SE COMPARA COMO EL RESTO, SE DEBE USAR EL METODO EQUALS, QUE COMPARA SI EL CONTENIDO DE AMBOS STRINGS SON IGUALES
            dimLF++; // INCREMENTO EL DIA CADA VEZ QUE TERMINO UNA COLUMNA
            dimLC = 0; // VUELVO A INICIALIZAR LAS COLUMNAS

            while (!nombre.equals(FIN) && (dimLC < DIMC)) //MIENTRAS EL NOMBRE ES VÁLIDO Y DA LA CANTIDAD DE PERSONAS POR DIA
            {
                matriz[dimLF][dimLC] = new Persona(); // RESERVO ESPACIO PARA EL OBJETO, LLAMO AL CONSTRUCTOR Persona (); 

                matriz[dimLF][dimLC].setNombre(nombre); // EL NOMBRE NO ES "ZZZ", LO INGRESO EN LA MATRIZ
                System.out.print("DNI:");
                matriz[dimLF][dimLC].setDNI(Lector.leerInt());
                System.out.print("EDAD");
                matriz[dimLF][dimLC].setEdad(Lector.leerInt());
                dimLC++;  // INCREMENTO CANTIDAD DE PARTICIPANTES

                System.out.print("NOMBRE:");// SE INGRESA OTRO PARTICIPANTE
                nombre = Lector.leerString();

            }// del while  

            System.out.println("FIN DEL DIA" + (dimLF + 1)); // PARA CHEQUEAR
            System.out.println("DIMLF: " + dimLF);

        }//del WHILE DE FILAS

        //b) Informar para cada día y turno el nombre de la persona a entrevistar.
        for (int i = dimLF; i >= 0; i--) { // FILAS-dias                                //---------REVISAR
            for (int j = dimLC; j >= 0; j--) { // COLUMNAS - turnos de los participantes
                System.out.println("Participantes en el día: " + (i + 1) + ":");
                for (int h = 0; h < dimLC; h++) {
                    System.out.println(" Se entevista al participante: " + (h + 1) + ": " + matriz[i][h].getNombre());
                }
            }
        }

    }//del main

} //de la clase
