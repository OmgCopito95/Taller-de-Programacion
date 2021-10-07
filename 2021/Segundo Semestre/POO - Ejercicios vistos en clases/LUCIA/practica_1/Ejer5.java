/* Un edificio de oficinas está conformado por 8 pisos y 4 oficinas por piso. Realice
un programa que permita informar la cantidad de personas que concurrieron a
cada oficina de cada piso. Para esto, simule la llegada de personas al edificio de la
siguiente manera: a cada persona se le pide el nro. de piso y nro. de oficina a la cual
quiere concurrir. La llegada de personas finaliza al indicar un nro. de piso 9. Al
finalizar la llegada de personas, informe lo pedido. 
 */

package LUCIA.practica_1;

import PaqueteLectura.Lector;

public class Ejer5 {

    public static void main(String[] args) {
      
        int dimF = 8 ;
        
        int dimC = 4 ;
        
        int[][] matriz = new int[dimF][dimC];
        
        
        //===== COMIENZO DE CONTADOR DE PERSONAS POR PISO Y OFICINA =====//
       
        System.out.println("PARA FINALIZAR CON LA CARGA INGRESE EL PISO NUMERO 9");
        System.out.println("<< Se recuerda que los pisos van del 0 a 9 y las oficinas de 0 a 4 >>");
        System.out.println(""); 
         
        System.out.println("Ingrese un numero de piso");
        int nroPiso = Lector.leerInt();
        while (nroPiso != 9){       //OJO CON EL CORTE Y LOS INDICES DE LA MATRIZ
          System.out.println("Ingrese un numero de oficina");
          int nroOfi = Lector.leerInt();
          matriz[nroPiso][nroOfi]++;
          
          System.out.println("");
          
          System.out.println("Ingrese un numero de piso");
          nroPiso = Lector.leerInt();
       }
        
      //===== COMIENZO IMPRIMIR MATRIZ =====// 
      int i;
      int j;
      for (i=0; i<8; i++ ){ //fila              //PUEDE QUE NO SE LLENE LA MATRIZ
        for (j=0; j<4; j++)  {
           System.out.println("En el piso "+i+", oficina "+j+" concurrieron "+matriz[i][j]+" personas");
        }
      }        
    }
}
