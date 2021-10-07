package OMAR.practica_1; 
import PaqueteLectura.*;

public class Punto4 {

    public static void main(String[] args) {
        
        GeneradorAleatorio.iniciar();
        int matriz [][] = new int[10][10];
        int suma = 0;
        int arreglo [] = new int[10];
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                matriz[i][j] = GeneradorAleatorio.generarInt(201);
            }
        }
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print("[" + matriz[i][j] + "]");
            }
            System.out.println("");
        }
        
        for (int i = 2; i < 10; i++) {
            for (int j = 0; j < 4; j++) {
                suma += matriz[i][j];
            }
        }
        
        System.out.println("SUMA ENTRE LAS FILAS 2 Y 9 Y LAS COLUMAS 0 Y 3: " + suma);
        
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < 10; j++) {            
                arreglo[i]+=matriz[j][i];
            }
        }
        
        System.out.println("");
        System.out.println("SUMA DE CADA COLUMNA EN CADA ELEMENTO DEL ARREGLO");
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print("[" + arreglo[i] + "]");
        }
    }
}

//FALTA EL PUNTO DE BUSCAR EN LA MATRIZ
    
