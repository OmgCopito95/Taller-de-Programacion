package BRENDA.practica_1;

import BRENDA.practica_1.Persona;
import PaqueteLectura.Lector;

/*Se realizará un casting para un programa de TV. El casting durará a lo sumo 5 días y en
cada día se entrevistarán a 8 personas en distinto turno.
a) Simular el proceso de inscripción de personas al casting. A cada persona se le pide
nombre, DNI y edad y se la debe asignar en un día y turno de la siguiente manera: las
personas primero completan el primer día en turnos sucesivos, luego el segundo día y así
siguiendo. La inscripción finaliza al llegar una persona con nombre “ZZZ” o al cubrirse los
40 cupos de casting.
Una vez finalizada la inscripción:
b) Informar para cada día y turno el nombre de la persona a entrevistar.
 */
public class Ej04Casting {

    public static void main(String[] args) {
        final int dias = 2;
        final int turnos = 2;

        Persona[][] casting = new Persona[dias][turnos];

        //declaro indices de matriz
        int dia = 0;
        int turno = 0;

        Persona persona;
        String nombre;
        int dni = 0; //me obliga a inicializar
        int edad = 0; //me obliga a inicializar

        System.out.println("Ingrese su nombre: ");
        nombre = Lector.leerString();
        if (!nombre.equals("ZZZ")) {
            System.out.println("Ingrese su dni: ");
            dni = Lector.leerInt();
            System.out.println("Ingrese su edad: ");
            edad = Lector.leerInt();
        }
        persona = new Persona(nombre, dni, edad);   //--------> LA CARGA PODRIAS HACERLA MAS SENCILLA LEYENDO UN NOMBRE Y LUEGO CARGANDO LA PERSONA. ASI NO TENES QUE REPETIR EL CASO AL PRINCIPIO


        while (!persona.getNombre().equals("ZZZ") && dia < dias) {

            while (!persona.getNombre().equals("ZZZ") && turno < turnos) {
                casting[dia][turno] = persona;
                turno++; //paso al turno siguiente

                //ingreso otra persona de teclado
                System.out.println("Ingrese su nombre: ");
                nombre = Lector.leerString();
                if (!nombre.equals("ZZZ")) {
                    System.out.println("Ingrese su dni: ");
                    dni = Lector.leerInt();
                    System.out.println("Ingrese su edad: ");
                    edad = Lector.leerInt();
                }
                persona = new Persona(nombre, dni, edad);
            }
            dia++; //paso a la fila siguiente de la matriz
            turno = 0; //reinicio a 0 las columnas para la siguiente fila de la matriz
        }

        dia = 0;
        turno = 0;

        while (dia < dias) {

            while (turno < turnos && casting[dia][turno] != null) {
                System.out.println("Dia: " + dia + ", turno: " + turno + ", persona a entrevistar: " + casting[dia][turno].getNombre());
                turno++; //paso al turno siguiente
            }
            dia++; //paso a la fila siguiente de la matriz
            turno = 0; //reinicio a 0 las columnas para la siguiente fila de la matriz
        }
    }
}



