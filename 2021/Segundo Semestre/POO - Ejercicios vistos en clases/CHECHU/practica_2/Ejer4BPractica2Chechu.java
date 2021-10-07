/*B- Realizar un programa principal que instancie un círculo, le cargue información leída
de teclado e informe en consola el perímetro y el área.
 */
package CHECHU.practica_2;
import BRENDA.practica_2.Circulo;
import PaqueteLectura.Lector; //importo paquete de lectura
public class Ejer4BPractica2Chechu {

    public static void main(String[] args) {
        Circulo circle = new Circulo(); //Construc NULO
        System.out.print("RADIO DEL CÍRCULO: ");
        circle.setRadio(Lector.leerDouble());
        System.out.print("COLOR DE RELLENO: ");
        circle.setColorRelleno(Lector.leerString());
        System.out.print("COLOR DE LÍNEA: ");
        circle.setColorLinea(Lector.leerString());
        
        System.out.println("EL PERÍMETRO DEL CÍRCULO ES: "+ circle.calcularPerimetro());
        System.out.println("EL ÁREA DEL CÍRCULO ES: "+circle.calcularArea());
    }//del MAIN
    
}// del CLASS
