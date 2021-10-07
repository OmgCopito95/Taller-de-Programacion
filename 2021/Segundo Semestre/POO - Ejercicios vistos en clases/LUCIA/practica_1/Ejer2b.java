/* Escriba un programa que imprima en consola el factorial de todos los números
entre 1 y 9. ¿Qué modificación debe hacer para imprimir el factorial de los
números impares solamente? */
package LUCIA.practica_1;

public class Ejer2b {

    public static void main(String[] args) {

        int j;
        
        int factorial = 1;
        
        int aux = 1;

        for (j = 1; j <= 9; j++) {
            if ((j % 2) != 0) {
                factorial = factorial * aux * j;
                System.out.println("El valor del factorial " + j + "! es " + factorial);
            }
            aux = j;
        }
    }
}
