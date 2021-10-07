package CARO_SANTA_MARIA.practica_1;
import PaqueteLectura.Lector;

/*
Escriba un programa que imprima en consola el factorial de todos los números
entre 1 y 9. ¿Qué modificación debe hacer para imprimir el factorial de los
números impares solamente?
 */
public class Ej02 {
    public static void main (String[] args) {
        // para imprimir impares la última condicion debe ser: i = i + 2
        for (int i = 1; i < 10; i++) {
            int num = i;
            int factorial = 1;
            while (num != 0) {
                factorial = factorial * num;
                num--;
            }
            System.out.println("El factorial de " + i + " es " + factorial);
        }
    }
}
