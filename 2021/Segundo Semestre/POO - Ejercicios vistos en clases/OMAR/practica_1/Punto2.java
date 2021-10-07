package OMAR.practica_1; 
import PaqueteLectura.Lector;

public class Punto2 {

    public static void main(String[] args) {
            
        for (int i = 1; i < 10; i++) {
            int factorial = 1; 
            for (int j = i; j > 0; j--) {
                factorial = factorial * j;
            }
            System.out.println(i + "! = " + factorial);
        }
        
        System.out.println("NÚMEROS FACTORIALES PARES");
        
        for (int i = 1; i < 10; i++) {
            if ((i % 2) == 0) {
                int factorialPar = 1;
                for (int j = i; j > 0; j--) {
                    factorialPar = factorialPar * j;
                }
                System.out.println(i + "! = " + factorialPar);
            }
        }
    }
}
