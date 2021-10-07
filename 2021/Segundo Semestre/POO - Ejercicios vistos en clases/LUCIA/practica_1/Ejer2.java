package LUCIA.practica_1;

/* Escriba un programa que imprima en consola el factorial de todos los números
entre 1 y 9. ¿Qué modificación debe hacer para imprimir el factorial de los
números impares solamente? */
public class Ejer2 {

    public static void main(String[] args) {

        int j;

        int aux = 1;

        for (j = 1; j <= 9; j++) {
            aux = aux * j;
            System.out.println("El valor del factorial " + j + "! es " + aux);
        }
    }
}
