package CARO_SANTA_MARIA.practica_1;
import PaqueteLectura.Lector;
import PaqueteLectura.GeneradorAleatorio;

/*
Un edificio de oficinas está conformado por 8 pisos y 4 oficinas por piso. Realice
un programa que permita informar la cantidad de personas que concurrieron a
cada oficina de cada piso. Para esto, simule la llegada de personas al edificio de la
siguiente manera: a cada persona se le pide el nro. de piso y nro. de oficina a la cual
quiere concurrir. La llegada de personas finaliza al indicar un nro. de piso 9. Al
finalizar la llegada de personas, informe lo pedido. 
 */
public class Ej05 {
    public static void main (String[] args) {
        // genero matriz
        int [][] oficinas = new int[8][4];
        
        // inicializo contadores
        for (int piso = 0; piso <= 7; piso++) {
            for (int ofi = 0; ofi <= 3; ofi++) {
                oficinas[piso][ofi] = 0; 
            }
        }
        
        // entrada de personas:
        System.out.print("Ingrese piso al que quiere ir: ");
        int p = Lector.leerInt();
        System.out.print("Ingrese oficina: ");
        int o = Lector.leerInt();
        
        
        // loop de ingreso
        while (p != 9) {    //OJO CON EL CORTE Y LOS INDICES DE LA MATRIZ
            oficinas[p][o]++;
            System.out.print("Ingrese piso al que quiere ir: ");
            p = Lector.leerInt();
            if (p != 9) {
                System.out.print("Ingrese oficina: ");
                o = Lector.leerInt();
            }
        }
        
        // informo
        for (int piso = 0; piso <= 7; piso++) {     //OJO QUE NO NECESARIAMENTE ESTÁ LLENA LA MATRIZ
            for (int ofi = 0; ofi <= 3; ofi++) {
                System.out.println("Piso " + piso + ", Oficina " + ofi + ": " + oficinas[piso][ofi] + " persona(s)"); 
            }
        }
    }
}
