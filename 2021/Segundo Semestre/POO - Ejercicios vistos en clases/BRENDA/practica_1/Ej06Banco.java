/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BRENDA.practica_1;

import PaqueteLectura.Lector;

/*Escriba un programa que simule el ingreso de personas a un banco. Cada
persona que ingresa indica la operación que desea realizar (0: “cobro de cheque” 1:
“depósito/ extracción en cuenta” 2: “pago de impuestos o servicios” 3: “cobro de
jubilación” 4: “cobro de planes”). La recepción de personas culmina cuando un
empleado ingresa la operación 5 (cierre del banco). Informar la cantidad de
personas atendidas por cada operación y la operación más solicitada.
 */
public class Ej06Banco {
    
    public static void mostrar_menu(){
      System.out.println("Indique la operacion que desea realizar");
        System.out.println("0: cobro de cheque");
        System.out.println("1: deposito/ extraccion en cuenta");
        System.out.println("2: pago de impuestos o servicios");
        System.out.println("3: cobro de jubilacion");
        System.out.println("4: cobro de planes");  
    }
    

    public static void main(String[] args) {
        final int dimF = 5;
        int[] atendidos = new int[dimF];

        //inicializo vector contador
        for (int i = 0; i < dimF; i++) {
            atendidos[i] = 0;
        }

        mostrar_menu();

        int operacion = Lector.leerInt();
        while (operacion != 5) {
            if (operacion >= 0 && operacion < 5) {
                atendidos[operacion]++;
            } else {
                System.out.println("La opcion ingresada es incorrecta. Intente nuevamente");
            }
            mostrar_menu();
            operacion = Lector.leerInt();
        }

        int atendidosMax = -1;
        int operacionMax = -1;
        for (int i = 0; i < dimF; i++) {
            if (atendidos[i] > atendidosMax) {
                atendidosMax = atendidos[i];
                operacionMax = i;
            }
            System.out.println("Personas atendidas para la opcion " + i + ": " + atendidos[i]);
        }
        System.out.println("La operacion mas solicitada fue la " + operacionMax);
    }
}
