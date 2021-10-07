package BRENDA.practica_1;

import BRENDA.practica_1.Persona;
import PaqueteLectura.Lector;

/*Utilizando la clase Persona (ya implementada). Realice un programa que almacene en
un vector 15 personas. La información de cada persona debe leerse de teclado. Luego de
almacenar la información:
- Informe la cantidad de personas mayores de 65 años.
- Muestre la representación de la persona con menor DNI
 */
public class Ej02Persona {

    public static void main(String[] args) {
        final int dimF = 15;
        Persona[] personas = new Persona[dimF];

        for (int i = 0; i < dimF; i++) {
            System.out.println("Ingrese su nombre: ");
            String nombre = Lector.leerString();
            System.out.println("Ingrese su dni: ");
            int dni = Lector.leerInt();
            System.out.println("Ingrese su edad: ");
            int edad = Lector.leerInt();

            personas[i] = new Persona(nombre, dni, edad);
        }

        int cantMayores = 0;
        int dniMin = 99999999;
        Persona personaMenorDni = null; //-----> EN VEZ DE ESTO PODES GUARDARTE LA POSICION DEL MINIMO Y ACCEDER AL VECTOR

        for (int i = 0; i < dimF; i++) {
            if (personas[i].getEdad() > 65) {
                cantMayores++;
            }
            if (personas[i].getDNI() < dniMin) {
                dniMin = personas[i].getDNI();
                personaMenorDni = personas[i];
            }
        }
        System.out.println("La cantidad de personas mayores de 65 anios es: " + cantMayores);
        System.out.println("Persona con menor DNI: " + personaMenorDni);
    }                       //LO IDEAL SERIA QUE LLAMES AL METODO TOSTRING PARA MOSTRAR LA REPRESENTACION
}
