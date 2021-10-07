package OMAR.practica_1; 
import PaqueteLectura.Lector;

public class Punto1 {

    public static void main(String[] args) {
        
        System.out.print("INGRESE UN NUMERO: ");
        
        int n = Lector.leerInt();
        int factorial = 1;
        
        for (int i = n; i > 0; i--) {
            factorial = factorial * i;
        }
        
        System.out.println(n + "! = " + factorial);
        
    }
}
