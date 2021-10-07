/* Genere un programa que cree una flota vacía. Cargue micros (sin pasajeros) 
a la flota con información leída desde teclado (hasta que se ingresa la patente “ZZZ000”
o hasta completar la flota). Luego lea una patente y elimine de la flota el micro con esa patente; 
busque el micro con dicha patente para comprobar que ya no está en la flota. 
Para finalizar, lea un destino e informe la patente del micro que va a dicho destino.
 */
package tema4;

import PaqueteLectura.Lector;

public class Ejer5Practica2Parte2 {

    public static void main(String[] args) {
        
        String patente= new String();
        
        int cant=0;
        
        String destino= new String();
        
        double salida;
        
        Flota f= new Flota();
        
        System.out.print("Ingrese patente: ");
        patente = Lector.leerString();
        while ((!patente.equals("ZZZ000")) && (cant < 15)){
            System.out.print("Ingrese destino: ");
            destino = Lector.leerString();
            System.out.print("Ingrese hora de salida: ");
            salida = Lector.leerDouble();
            Micro m= new Micro(patente,destino,salida);
            f.AgregarMicro(m);
            System.out.print("Ingrese patente: ");
            patente = Lector.leerString();
        }    
            
        System.out.print("Ingrese una patente a eliminar: ");
        patente = Lector.leerString();
        if  (f.EliminarMicroPatente(patente)){  //SE ROMPE
            System.out.println("Se encontro la patente"+patente+" en la flota de micros");
            if (f.buscarPatente(patente).equals("null")){
                System.out.println("Se elimino la patente");
            }
        }else{
            System.out.println("NO se encontro la patente"+patente+" en la flota de micros");
        }
  //      System.out.print("Ingrese un destino para retornar una patente: ");
  //      destino = Lector.leerString();        
       // if (f.buscarDestino(destino).equals(destino)){
       //     f.
       // }
       
        
        
        
        
    }
    
}
