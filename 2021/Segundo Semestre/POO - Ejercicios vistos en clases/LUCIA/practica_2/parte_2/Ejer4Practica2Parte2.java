/*Realice un programa que cree un micro con patente “ABC123”, destino “Mar del Plata” 
y hora de salida 5:00. Cargue pasajeros al micro de la siguiente manera.
Leer nros. de asientos desde teclado que corresponden a pedidos de personas.
La lectura finaliza cuando se ingresa el nro. de asiento -1 o cuando se llenó el micro.
Para cada nro. de asiento leído debe: validar el nro; en caso que esté libre, 
ocuparlo e informar a la persona el éxito de la operación; 
en caso que esté ocupado informar a la persona la situación y
mostrar el nro. del primer asiento libre. Al finalizar, informe la cantidad de asientos ocupados
del micro.
 */
package tema4;

import PaqueteLectura.Lector;

public class Ejer4Practica2Parte2 {

    public static void main(String[] args) {

        int asiento;

        int pos = 0;  

        Micro m = new Micro("ABC123", "MAR DEL PLATA", 5.00);
        
        System.out.print("Ingrese numero de asiento: ");
        asiento = Lector.leerInt();
        while ((asiento != -1) && (!m.microLleno())) {   //Mientras asiento  <> -1 y el micro no este lleno
            if (m.validarAsiento(asiento)) {
                if (! m.estadoAsiento(asiento)) { //COMO SON LOS CORCHETES DEL IF Y ELSE
                    m.ocuparAsiento(asiento);
                    System.out.println("Se ocupo con exito el asiento " + asiento);
                } else 
                    System.out.println("El asiento " + asiento + " esta ocupado");//. El primer asiento libre para ocupar es ");
                    if (m.primerAsientoLibre(pos) != -1) {  //NO SE LO PASES POR PARAMETRO. TE LO DEVUELVE EL MÉTODO
                        System.out.println("El primer asiento libre a ocupar es " + pos);
                        
                    } else {
                        System.out.println("No hay asiento libre");

                    }
                    System.out.print("Ingrese numero de asiento: ");
                    asiento = Lector.leerInt();
                
            }
        }
        System.out.println("");
        System.out.println("La cantidad de asientos ocupados es de "+m.getCantAsientosOcupados());        
    }
}
