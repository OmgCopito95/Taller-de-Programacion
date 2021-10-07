package OMAR.practica_1; 
import PaqueteLectura.GeneradorAleatorio;

public class Punto6 {

    public static void main(String[] args) {
        
        GeneradorAleatorio.iniciar();
        int operacion = GeneradorAleatorio.generarInt(6);
        int pAtendidas[] = new int[5];
        int max = -1;
        int indice = -1;
        
        System.out.println("INGRESAR OPERACIÓN: " + operacion);
        
        while(operacion != 5) { 
            if(operacion == 0) {        //INNECESARIO, SE PUEDE ACCEDER DIRECTAMENTE A LA POS Y SUMAR UNO
                pAtendidas[operacion]+= 1;
            } else if(operacion == 1) {
                pAtendidas[operacion]+= 1;
            } else if(operacion == 2) {
                pAtendidas[operacion]+= 1;
            } else if(operacion == 3) {
                pAtendidas[operacion]+= 1;
            } else if(operacion == 4) {
                pAtendidas[operacion]+= 1;
            }           
            operacion = GeneradorAleatorio.generarInt(6);
            System.out.println("INGRESAR OPERACIÓN: " + operacion);
        }
        
        for (int i = 0; i < pAtendidas.length; i++) {
            if (pAtendidas[i] > max) {
                max = pAtendidas[i];
                indice = i;
            }
        }
        
        System.out.println("");
        System.out.println("CANTIDAD DE PERSONAS ATENDIDAS POR CADA OPERACIÓN");
        for (int i = 0; i < pAtendidas.length; i++) {
            System.out.println("OPERACIÓN " + i + ": " + pAtendidas[i]);
        }
        
        System.out.println("");
        System.out.println("LA OPERACIÓN MÁS SOLICITADA ES LA OPERACIÓN: " + indice);
    }

}
