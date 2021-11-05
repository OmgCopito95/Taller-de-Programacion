/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial;

import PaqueteLectura.Lector;


public class modeloParcial2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        Teatro teatro = new Teatro("cazafantasmas","20:00","22-10-2018");
                                                      
        System.out.print(" ingrese dni: ");
        int dni = Lector.leerInt();
        System.out.println(" el ingreso de espectadores termina con dni = 0 ");
        while (dni != 0  && (teatro.hayEspacio())){
           if (!(teatro.estaRegistrado(dni))){
               System.out.print(" ingrese numero de fila (1..20) :");        
               int fila = Lector.leerInt();  
               if (teatro.validarFila(fila-1)) {
                   if (teatro.hayButacaLibreEnFila(fila-1)){
                       System.out.print(" nombre: ") ;
                       String nombre = Lector.leerString();            
                       System.out.print(" edad: ");
                       int edad = Lector.leerInt();
                       Espectador E = new Espectador (nombre,dni,edad);
                       teatro.agregarEspectadorAFila(fila-1, E);
                       System.out.println(" se le asigno el asiento: " + teatro.devolverButaca(fila-1));
                   }                                  
               }                                                             
           }           
           else {
               System.out.println("el dni ya se encuentra registrado");
           }  
               
           System.out.print(" ingrese dni: ");
           dni = Lector.leerInt();           
          }
       System.out.println(teatro.calcularEdadPromEspectadores());
       System.out.println(teatro.calcularButacasLibres());
        }
       
       
    }






















