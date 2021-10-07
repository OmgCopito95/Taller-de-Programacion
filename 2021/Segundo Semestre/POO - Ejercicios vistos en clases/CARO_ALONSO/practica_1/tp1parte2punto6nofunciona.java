/*
Se dispone de la clase Partido (ya implementada en la carpeta tema2).
Un objeto partido representa un encuentro entre dos equipos (local y visitante).
Un objeto partido 
puede crearse sin valores iniciales o enviando en el mensaje de creación el nombre del equipo local,
el nombre del visitante,la cantidad de goles del local y del visitante(en ese orden).
Un objeto partido sabe responder a los siguientes mensajes:

getLocal() retorna el nombre (String) del equipo local 

getVisitante() retorna el nombre (String) del equipo visitante .

getGolesLocal() retorna la cantidad de goles (int) del equipo local. 

getGolesVisitante() retorna la cantidad de goles (int) del equipo visitante.

setLocal(X)  modifica el nombre del equipo local al “String” pasado por parámetro(X).

setVisitante(X) modifica el nombre del equipo visitante al “String” pasado por parámetro(X).

setGolesVisitante(X) modifica la cantidad de goles del equipo visitante “int” pasado por parámetro(X).

hayGanador() retorna un boolean que indica si hubo (true) o no hubo (false) ganador.

getGanador() retorna el nombre (String) del ganador del partido (si no hubo retorna un String vacio).

hayEmpate() retorna un boolean que indica si hubo (true) o no hubo (false) empate.

* Implemente un programa que cargue un vector con a lo sumo 20 partidos disputados en el campeonato.
La información de cada partido se lee desde teclado hasta ingresar uno con nombre de visitante “ZZZ” 
o alcanzar los 20 partidos. Luego de la carga informar:

- La cantidad de partidos que ganó River.
- El total de goles que realizó Boca jugando de local. 
- El porcentaje de partidos finalizados con empate.

 */
package CARO_ALONSO.practica_1;

import CARO_ALONSO.practica_1.Partido;
import PaqueteLectura.Lector;

public class tp1parte2punto6nofunciona {

    public static void main(String[] args) {

        final int dimf = 1;

        Partido p = new Partido();

        Partido vector[] = new Partido[dimf];

        int pos = 0;

        System.out.println("ingrese nombre de equipo visitante:");
        String equipovisitante = (Lector.leerString()); // declaro y le doy valor a la variable string por primeva vez.

        
        //NO ESTA GUARDANDO AL EQUIPO VISITANTE POR ESO SE ROMPE!
        while (((pos < dimf) && (!equipovisitante.equals("zzz")))) {     // inicio de carga       
            vector[pos] = new Partido();

            System.out.println("ingrese nombre de equipo local:");
            vector[pos].setLocal(Lector.leerString());

            System.out.println("ingrese cantidad de goles de equipo local:");
            vector[pos].setGolesLocal(Lector.leerInt());

            System.out.println("ingrese cantidad de goles de equipo visitante:");
            vector[pos].setGolesVisitante(Lector.leerInt());

            System.out.println("ingrese nombre de equipo visitante:");
            equipovisitante = (Lector.leerString());

            pos++;
        } // fin de carga

        int ganados_river = 0;
        int goles_boca = 0;
        int cant_empate = 0;

        for (int i = 0; i < pos; i++) { // recorrido del vector de objetos partidos.

            System.out.println(vector[i].getLocal());
            System.out.println(vector[i].getVisitante());
            if (vector[i].hayEmpate()) {
                cant_empate++;
            } else if (vector[i].hayGanador()) {
                System.out.println(vector[i].getGanador());
                if (vector[i].getGanador().equals("river")) {
                    ganados_river++;
                }
            }

            if (vector[i].getLocal().equals("boca")) {
                goles_boca += vector[i].getGolesLocal();
            }

        }

        double porcentaje = (double) (cant_empate * dimf / 100);
        System.out.println("-----------------------------------------------------");
        System.out.println("Porcentaje de empates: " + String.format("%.2f", porcentaje));
        System.out.println("Cantidad de partidos ganados por river : " + ganados_river);
        System.out.println("El total de goles que realizó Boca jugando de local: " + goles_boca);
        System.out.println("-----------------------------------------------------");
    }

}
