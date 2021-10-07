/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AGUSTIN.practica_1;

import PaqueteLectura.Lector;

/**
 *
 * @author Peirano-PC
 */
public class Ejercicio6 {

    /**
     * @param args the command line arguments
     */
    /*
    Escriba un programa que simule el ingreso de personas a un banco. Cada
    persona que ingresa indica la operación que desea realizar (0: “cobro de cheque” 1:
    “depósito/ extracción en cuenta” 2: “pago de impuestos o servicios” 3: “cobro de
    jubilación” 4: “cobro de planes”). La recepción de personas culmina cuando un
    empleado ingresa la operación 5 (cierre del banco). Informar la cantidad de
    personas atendidas por cada operación y la operación más solicitada
     */
    public static void main(String[] args) {
        int[] banco = new int[5]; //0 - 4
        int personas = 0;
        int max = 0;
        System.out.println("Ingrese la operacion que desea hacer: ");
        int operacion = Lector.leerInt();
        if (operacion >= 0 && operacion < 5) {
            personas++;
        }
        while (operacion > 0 && operacion < 5) {
            banco[operacion]++;
            System.out.println("Ingrese la operacion que desea hacer");
            operacion = Lector.leerInt();
            if (operacion > 0 && operacion < 5) {
                personas++;
            }
        }
        if (operacion < 0 && operacion > 5) {
            System.out.println("Se ha ingresado una operacion invalida");
        }

        for (int i = 0; i < 5; i++) {       //mal calculado el maximo
            if (banco[i] > banco[max]) {
                max = i;
            }
        }
        System.out.println("La cantidad de personas atendidas fue: " + personas);
        System.out.println("La operacion mas realizada fue la " + max);
    }

}
