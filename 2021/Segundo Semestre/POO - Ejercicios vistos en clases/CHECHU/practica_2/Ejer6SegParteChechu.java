/*
Se dispone de la clase Partido (ya implementada en la carpeta tema2). Un objeto
partido representa un encuentro entre dos equipos (local y visitante). Un objeto partido
puede crearse sin valores iniciales o enviando en el mensaje de creación el nombre del
equipo local, el nombre del visitante, la cantidad de goles del local y del visitante (en ese
orden). Un objeto partido sabe responder a los siguientes mensajes:

getLocal() retorna el nombre (String) del equipo local
getVisitante() retorna el nombre (String) del equipo visitante
getGolesLocal() retorna la cantidad de goles (int) del equipo local
getGolesVisitante() retorna la cantidad de goles (int) del equipo visitante
setLocal(X) modifica el nombre del equipo local al “String” pasado por parámetro (X)
setVisitante(X) modifica el nombre del equipo visitante al “String” pasado por parámetro (X)
setGolesLocal(X) modifica la cantidad de goles del equipo local “int” pasado por parámetro (X)
setGolesVisitante(X) modifica la cantidad de goles del equipo visitante “int” pasado por parámetro (X)
hayGanador() retorna un boolean que indica si hubo (true) o no hubo (false) ganador
getGanador() retorna el nombre (String) del ganador del partido (si no hubo retorna un String
vacío).
hayEmpate() retorna un boolean que indica si hubo (true) o no hubo (false) empate

Implemente un programa que cargue un vector con a lo sumo 20 partidos disputados en el
campeonato. La información de cada partido se lee desde teclado hasta ingresar uno con
nombre de visitante “ZZZ” o alcanzar los 20 partidos. Luego de la carga informar:
- La cantidad de partidos que ganó River.
- El total de goles que realizó Boca jugando de local.
- El porcentaje de partidos finalizados con empate
 */
package CHECHU.practica_2;

import PaqueteLectura.Lector; //importo paquete de lectura para leer
import java.util.logging.Logger;

public class Ejer6SegParteChechu {

    public static final int DIMF = 20; // DIMF PARTIDOS - revisar porque es con A LO SUMO
    public static final String FIN = "ZZZ"; // CONDICION DE CORTE 

    public static void main(String[] args) {
        Partido[] vector; // DECLARO Y CREO UN VECTOR DE A LO SUMO 20 PARTIDOS
        vector = new Partido[DIMF];

        int dimL = 0; // VARIABLE INDICE
        String nombreVisitante; // DECLARO VARIABLE PARA EL CORTE DE CONTROL

        // SE LEE EL PRIMER NOMBRE DE VISITANTE
        System.out.println("Nombre del equipo visitante: ");
        nombreVisitante = Lector.leerString();

        // SE INGRESAN LOS DATOS DE LOS EQUIPOS QUE PARTICIPAN DEL CAMPEONATO
        while ((dimL < DIMF) && (!nombreVisitante.equals(FIN))) { // MIENTRAS NO SE INGRESE EL NOMBRE DE VISITANTE = CORTE DE CONTROL
            vector[dimL] = new Partido();
            System.out.println("Nombre del equipo local: ");
            vector[dimL].setLocal(Lector.leerString());
            vector[dimL].setVisitante(nombreVisitante); // SE INGRESA EL NOMBRE QUE SE LEYO ANTES, DE ESTA FORMA PORQUE DEBE CUMPLIR ESTE ORDEN SEGUN LA CONSIGNA
            System.out.println("Cantidad de goles del equipo local: ");
            vector[dimL].setGolesLocal(Lector.leerInt());
            System.out.println("Cantidad de goles del equipo visitante: ");
            vector[dimL].setGolesVisitante(Lector.leerInt());
            System.out.println("Nombre del equipo visitante: ");
            nombreVisitante = Lector.leerString();
            dimL++;
        }//del while
    //---------INFORMAR------------
    int ganoRiver = 0, totalBoca = 0, totalEmpate = 0;

    for (int i = 0; i< dimL ;i++) {
            if (vector[i].getGanador().equals("RIVER")) { //cantidad de partidos que ganó River.
            ganoRiver++;
        }

        if (vector[i].getLocal().equals("BOCA")) {
                totalBoca += vector[i].getGolesLocal(); // CUENTA CANTIDAD DE GOLES DE BOCA DE LOCAL
        }

        if (vector[i].hayEmpate()) { // total de partidos con empate.
            totalEmpate++;
        }
    }// del FOR

   System.out.print ( "Cantidad de partidos que ganó River: " + ganoRiver);
   System.out.print ("Total de goles que realizó Boca jugando de local: " + totalBoca);
   System.out.print ("Porcentaje de partidos finalizados con empate: " + (totalEmpate / dimL)*100 + " %");

    }//del MAIN
    //private static final Logger LOG = Logger.getLogger(Ejer6SegParteChechu.class.getName());

}// de la CLASE


//      OBSERVACIONES
//    si ganó river seguro no hay empate asique tendrias que usar else
//    lo ideal seria que primero preguntes si hay un ganador si no pones el else del empate, y despues pidas el ganador
