/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AGUSTIN.practica_1;

/**
 *
 * @author Peirano-PC
 */
import PaqueteLectura.Lector;

public class Ejercicio6 {

    /**
     * @param args the command line arguments
     */
    /*
    Implemente un programa que cargue un vector con a lo sumo 20 partidos disputados en el
    campeonato. La información de cada partido se lee desde teclado hasta ingresar uno con
    nombre de visitante “ZZZ” o alcanzar los 20 partidos. Luego de la carga informar:
    - La cantidad de partidos que ganó River.
    - El total de goles que realizó Boca jugando de local.
    - El porcentaje de partidos finalizados con empate. 
     */
    public static void main(String[] args) {
        Partido[] partidos = new Partido[20];
        String CORTE_NOMBRE = "ZZZ";
        int CONT = 0;
        int empate = 0;
        int GanoRiver = 0;
        int BocaLocal = 0;

        partidos[CONT] = new Partido();

        //Cargamos el equipo local para luego preguntar si es ZZZ
        System.out.println("Ingrese el nombre del equipo VISITANTE");
        partidos[CONT].setVisitante(Lector.leerString());   //LO IDEAL SERIA HACER ESTO UNA VEZ QUE SE QUE EL VISITANTE NO ES EL CORTE!

        while (CONT != 20 && !partidos[CONT].getVisitante().equals(CORTE_NOMBRE)) {

            // SI ENTRA EN EL WHILE, EMPEZAMOS A CARGAR LOS DATOS
            System.out.println("Ingrese el nombre del equipo LOCAL");
            partidos[CONT].setLocal(Lector.leerString());

            System.out.println("Ingrese los goles del equipo VISITANTE");
            partidos[CONT].setGolesVisitante(Lector.leerInt());

            System.out.println("Ingrese los goles del equipo LOCAL");
            partidos[CONT].setGolesLocal(Lector.leerInt());

            //PREGUNTAMOS SI BOCA JUGO DE LOCAL
            if (partidos[CONT].getLocal().equals("Boca")) {
                BocaLocal = BocaLocal + partidos[CONT].getGolesLocal();
            }

            //PREGUNTAMOS SI EL PARTIDO TUVO DE RESULTADO EMPATE
            if (partidos[CONT].hayEmpate()) {
                empate++;
            }

            //PREGUNTAMOS SI JUGO RIVER PARA LUEGO PREGUNTAR SI GANÓ
            if (partidos[CONT].getLocal().equals("River") || partidos[CONT].getVisitante().equals("River")) {
                if (partidos[CONT].getGanador().equals("River")) {
                    GanoRiver++;
                }
            }
            CONT++;
        }

        if (!partidos[0].getVisitante().equals("ZZZ")) {
            double porcentaje = empate / CONT;

            //INFORMAR GOLES DE BOCA
            System.out.println("Los goles realizados por Boca de Local: " + BocaLocal);

            //INFORMAR PARTIDOS GANADOS DE RIVER
            System.out.println("Los partidos que gano River: " + GanoRiver);

            //INFORMAR PORCENTAJE DE PARTIDOS EMPATADOS
            System.out.println("El porcentaje de los partidos que terminaron en empate: " + porcentaje);
        } else {
            System.out.println("Se ingreso como primer dato ZZZ");
        }
    }

}


//VARIAS COSAS PARA ACOMODAR:
//1- SEPARAR LA CARGA DEL PROCESAMIENTO DE DATOS
//2- EL NEW DE CADA POSICION DEL VECTOR HACELO ADENTRO DEL WHILE, NO ESTA DEL TODO BIEN QUE PRIMERO HAGAS UN NEW PARA GUARDAR EL NOMBRE
//DEL VISITANTE. HABRIA QUE REACOMODAR EL PRINCIPIO
//3- TENE EN CUENTA QUE SI EL GANADOR ES RIVER, ENTONCES LA PREGUNTA DE SI HAY EMPATE NO DEBERIA HACERSE