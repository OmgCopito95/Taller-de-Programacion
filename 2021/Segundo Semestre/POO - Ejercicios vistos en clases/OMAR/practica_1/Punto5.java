package OMAR.practica_1; 
import PaqueteLectura.GeneradorAleatorio;

public class Punto5 {

    public static void main(String[] args) {

        GeneradorAleatorio.iniciar();
        int edificio[][] = new int[8][4];
        int nPiso, nOficina;
        
        
        nPiso = GeneradorAleatorio.generarInt(9);
        System.out.println("PISO: " + nPiso);
        nOficina = GeneradorAleatorio.generarInt(4);
        System.out.println("OFICINA: " + nOficina);
        while (nPiso != 8) {        //OJO CON EL CORTE DE CONTROL Y LOS INDICES DE LA MATRIZ
            edificio[nPiso][nOficina]+= 1;
            nPiso = GeneradorAleatorio.generarInt(9);
            System.out.println("PISO: " + nPiso);
            nOficina = GeneradorAleatorio.generarInt(4);
            System.out.println("OFICINA: " + nOficina);
        }
        
        System.out.println("");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println("[" + i + "][" + j + "]: " + edificio[i][j] + " PERSONAS");
            }
        }
    }
}
