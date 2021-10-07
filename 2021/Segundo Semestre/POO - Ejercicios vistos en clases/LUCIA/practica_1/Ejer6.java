/* Escriba un programa que simule el ingreso de personas a un banco. Cada
persona que ingresa indica la operación que desea realizar (0: “cobro de cheque” 1:
“depósito/ extracción en cuenta” 2: “pago de impuestos o servicios” 3: “cobro de
jubilación” 4: “cobro de planes”). La recepción de personas culmina cuando un
empleado ingresa la operación 5 (cierre del banco). Informar la cantidad de
personas atendidas por cada operación y la operación más solicitada. 
 */
package LUCIA.practica_1;

import PaqueteLectura.Lector;

public class Ejer6 {

    public static void main(String[] args) {

        int[] vector = new int[5];

        //====== COMIENZO DE CARGA DE VECTOR ======/
        System.out.println("PARA EL CIERRE DE BANCO INGRESE LA OPERACION NUMERO 5");
        System.out.println("");
        System.out.println("Ingrese del 0 a 4 la operacion que desea realizar");
        int num = Lector.leerInt();
        while (num != 5) {
            vector[num]++;
            System.out.println("");
            System.out.println("Ingrese del 0 a 4 la operacion que desea realizar");
            num = Lector.leerInt();
        }

        //====== COMIENZO DE CANT TOTAL DE PERSONAS POR OP Y MAXIMO ======/
        int i;
        int max = -999;
        int maxOp = 0;    //por que me hace inicializar maxOp???
        for (i = 0; i < 5; i++) {
            System.out.println("En la operacion " + i + " se atendieron a " + vector[i] + " personas");
            if (vector[i] > max) {
                max = vector[i];
                maxOp = i;
            }
        }
        System.out.println("");
        System.out.println("La operaion mas solicitada fue la numero " + maxOp);
    }
}
