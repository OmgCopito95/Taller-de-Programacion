package BRENDA.practica_1;

import PaqueteLectura.Lector;

/*Implemente un programa que cargue un vector con a lo sumo 20 partidos disputados en el
campeonato. La información de cada partido se lee desde teclado hasta ingresar uno con
nombre de visitante “ZZZ” o alcanzar los 20 partidos. Luego de la carga informar:
- La cantidad de partidos que ganó River.
- El total de goles que realizó Boca jugando de local.
- El porcentaje de partidos finalizados con empate.
 */
public class Ej06Partido {

    public static void main(String[] args) {
        final int dimF = 20;
        Partido[] partidos = new Partido[dimF];

        String local;
        String visitante;
        int golesLocal;
        int golesVisitante;
        Partido partido;

        System.out.println("Ingrese el equipo visitante: ");
        visitante = Lector.leerString();

        int i = 0; //declaro el indice del vector

        while (!visitante.equals("ZZZ") && i < dimF) {
            System.out.println("Ingrese el equipo local: ");
            local = Lector.leerString();
            System.out.println("Ingrese la cantidad de goles del equipo visitante: ");
            golesVisitante = Lector.leerInt();
            System.out.println("Ingrese la cantidad de goles del equipo local: ");
            golesLocal = Lector.leerInt();

            partido = new Partido(local, visitante, golesLocal, golesVisitante);

            partidos[i] = partido;
            i++;

            //ingreso un nuevo partido
            System.out.println("Ingrese el equipo visitante: ");
            visitante = Lector.leerString();
        }

        int cantGanaRiver = 0;
        int golesBocaLocal = 0;
        int partidosEmpate = 0;
        i = 0; //reinicializo el indice del vector   //---------->SI FUISTE USANDO I COMO DIML, PODRIAS HACER UN FOR EN EL WHILE DE ABAJO

        while (i < dimF && partidos[i] != null) {
            if (partidos[i].getGanador().equals("River")) { //SI EL GANADOR ES RIVER ENTONCES SEGURO NO HAY EMPATE. EL TERCER IF PONELO EN UN ELSE
                cantGanaRiver++;
            }
            if (partidos[i].getLocal().equals("Boca")) {
                golesBocaLocal = golesBocaLocal + partidos[i].getGolesLocal();
            }
            if (partidos[i].hayEmpate()) {
                partidosEmpate++;
            }
            i++; //actua de indice y me suma la cantidad total de partidos
        }

        System.out.println(partidosEmpate);
        System.out.println(i);
        System.out.println("Cantidad de partidos que gano River: " + cantGanaRiver);
        System.out.println("Total de goles que realizo Boca jugando de local: " + golesBocaLocal);
        System.out.println("Porcentaje de partidos finalizados con empate: " + ((double) partidosEmpate / i * 100)); //casteo partidosEmpate para que el resultado de la division de enteros no me de 0.
    }
}
