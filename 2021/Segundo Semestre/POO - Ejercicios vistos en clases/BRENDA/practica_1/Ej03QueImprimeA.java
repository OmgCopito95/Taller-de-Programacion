
package BRENDA.practica_1;

/**
 *
 * @author vsanz
 */
public class Ej03QueImprimeA {
    public static void main(String[] args) {
        String saludo1=new String("hola");
        String saludo2=new String("hola");
        System.out.println(saludo1 == saludo2); //imprime false
        System.out.println(saludo1 != saludo2); //imprime true
        System.out.println(saludo1.equals(saludo2)); //imprime true
    } 
}
