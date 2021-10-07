package CARO_SANTA_MARIA.practica_1;
import PaqueteLectura.Lector;
import PaqueteLectura.GeneradorAleatorio;
/*
Escriba un programa que simule el ingreso de personas a un banco. Cada
persona que ingresa indica la operación que desea realizar (0: “cobro de cheque” 1:
“depósito/ extracción en cuenta” 2: “pago de impuestos o servicios” 3: “cobro de
jubilación” 4: “cobro de planes”). La recepción de personas culmina cuando un
empleado ingresa la operación 5 (cierre del banco). Informar la cantidad de
personas atendidas por cada operación y la operación más solicitada. 
 */
public class Ej06 {
    public static void main (String[] args) {
        // genero vector contador
        int [] operaciones = new int[5];
        
        // inicializo contadores
        for (int i = 0; i <= 4; i++) {
                operaciones[i] = 0; 
            }
        
        // recepción:
        System.out.println("Operaciones disponibles: ");
        System.out.println("0: Cobro de cheques");
        System.out.println("1: Depósito / extracción en cuenta");
        System.out.println("2: Pago de impuestos o servicios");
        System.out.println("3: Cobro de jubilación");
        System.out.println("4: Cobro de planes");
        System.out.println("");
        System.out.print("Indique operación que desea realizar: ");
        int o = Lector.leerInt();
        
        // loop de recepción:
        while (o != 5) {
            operaciones[o]++;
            System.out.println("");
            System.out.print("Indique operación que desea realizar: ");
            o = Lector.leerInt();
        }
        
        int mayor = -1;
        int masSolicitada = 0;
        for (int i = 0; i <= 4; i++) {
            if (operaciones[i] > mayor) {
                mayor = operaciones[i];
                masSolicitada = i;
            }
            System.out.println("");
            System.out.println("La operación " + i + " se solicitó " + operaciones[i] + " veces.");
        }
        System.out.println("");
        System.out.println("La operación más solicitada fue la " + masSolicitada);
    }
}
