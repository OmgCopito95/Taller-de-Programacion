package JOAQUINA.practica_1;

import PaqueteLectura.Lector;

public class Ejercicio6P {

    /*Se dispone de la clase Partido (ya implementada en la carpeta tema2). Un objeto
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
    getGanador() retorna el nombre (String) del ganador del partido (si no hubo retorna un String vacío).
    hayEmpate() retorna un boolean que indica si hubo (true) o no hubo (false) empate
    
    Implemente un programa que cargue un vector con a lo sumo 20 partidos disputados en el
    campeonato. La información de cada partido se lee desde teclado hasta ingresar uno con
    nombre de visitante “ZZZ” o alcanzar los 20 partidos. Luego de la carga informar:
    - La cantidad de partidos que ganó River.
    - El total de goles que realizó Boca jugando de local.
    - El porcentaje de partidos finalizados con empate.     
     */
    public static void main(String[] args) {

        int cons = 3;
        Partido partido; //----->NO HACE FALTA ESTA VARIABLE
        Partido[] vector;
        vector = new Partido[cons];

        int golV, golL, contador = 0;
        String nombreV = " ", nombreL;
        while ((!"ZZZ".equals(nombreV)) && (contador != cons)) {
            if (contador < cons) { //----------> ESTA CONDICION PODRIAS PONERLA EN EL WHILE DIRECTAMENTE
                System.out.println("Ingrese el Visitante");
                nombreV = Lector.leerString();
                if (!"ZZZ".equals(nombreV)) { //----------> NO HACE FALTA SI LO PREGUNTAS EN EL WHILE
                    System.out.println("Ingrese el  Local");
                    nombreL = Lector.leerString();
                    System.out.println("Ingrese los goles Local");
                    golL = Lector.leerInt();
                    System.out.println("Ingrese los goles visitante");
                    golV = Lector.leerInt();
                    vector[contador] = new Partido(nombreL, nombreV, golL, golV);
                    contador = contador + 1;
                }
            }
        }
        int i, partidosR = 0, golesB = 0, contE = 0;
        for (i = 0; i < cons; i++) {
            /*if(vector[i].getGanador().equals("River")) {  /me tira error no me da el nombre de river.
                partidosR = partidosR + 1;      //DEBERIAS PREGUNTAR PRIMERO SI HAY GANADOR Y DESPUES PEDIR EL NOMBRE
            } */
            if (vector[i].getLocal().equals("Boca")) {
                golesB = golesB + vector[i].getGolesLocal();
            }
            if (vector[i].hayEmpate()) { //---->TENE EN CUENTA QUE SI EL GANADOR ES RIVER, NO HACE FALTA PREGUNTAR POR EMPATE
                contE = contE + 1;
            }
        }
        System.out.println("River gano: " + partidosR + " partidos");
        System.out.println("Boca hizo " + golesB + " de local");
        System.out.println("El porcentaje de partidos que terminaron en empate son: "+contE*100/cons);
    }

}
