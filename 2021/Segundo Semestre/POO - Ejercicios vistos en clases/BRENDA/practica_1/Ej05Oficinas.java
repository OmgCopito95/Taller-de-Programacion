package BRENDA.practica_1;

import PaqueteLectura.Lector;

/*Un edificio de oficinas está conformado por 8 pisos y 4 oficinas por piso. Realice
un programa que permita informar la cantidad de personas que concurrieron a
cada oficina de cada piso. Para esto, simule la llegada de personas al edificio de la
siguiente manera: a cada persona se le pide el nro. de piso y nro. de oficina a la cual
quiere concurrir. La llegada de personas finaliza al indicar un nro. de piso 9. Al
finalizar la llegada de personas, informe lo pedido.
 */
public class Ej05Oficinas {

    public static void main(String[] args) {
        final int pisos = 8;
        final int oficinas = 4;

        int piso;
        int oficina;

        int[][] edificio = new int[pisos][oficinas];

        // inicializo los contadores en 0
        for (piso = 0; piso < pisos; piso++) {
            for (oficina = 0; oficina < oficinas; oficina++) {
                edificio[piso][oficina] = 0;
            }
        }

        System.out.println("Ingrese el numero de piso al que quiere concurrir [1..8]: ");
        piso = Lector.leerInt() - 1;  // Le resto 1 porque si ingresan piso 1 correspondera a la fila 0 de mi matriz.

        while (piso >= 0 && piso < pisos) {
            System.out.println("Ingrese el numero de oficina al que quiere concurrir [1..4]: ");
            oficina = Lector.leerInt() - 1;  // Le resto 1 porque si ingresan oficina 1 correspondera a la columna 0 de mi matriz.

            if (oficina >= 0 && oficina < oficinas) {
                edificio[piso][oficina]++;
            } else {
                System.out.println("Ingreso una oficina incorrecta. Intente nuevamente.");
            }

            System.out.println("Ingrese el numero de piso al que quiere concurrir: ");
            piso = Lector.leerInt() - 1;
        }

        //informo resultado
        for (piso = 0; piso < pisos; piso++) {
            for (oficina = 0; oficina < oficinas; oficina++) {
                System.out.println("Cantidad de personas que concurrieron la oficina " + (oficina + 1) + " del piso " + (piso + 1) + " :" + edificio[piso][oficina]);
            }
        }
    }
}
