/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JOAQUINA.practica_2;

/**
Definir una clase para representar micros. Un micro conoce su patente, destino, hora
salida, el estado de sus 20 asientos (es decir si está o no ocupado) y la cantidad de asientos
ocupados al momento. Lea detenidamente a) y b) y luego implemente.
a) Implemente un constructor que permita iniciar el micro con una patente, un destino y
una hora de salida (recibidas por parámetro) y sin pasajeros.
b) Implemente métodos para:
i. devolver/modificar patente, destino y hora de salida
ii. devolver la cantidad de asientos ocupados
iii. devolver si el micro está lleno
iv. validar un número de asiento recibido como parámetro (es decir, devolver si está
en rango o no)
v. devolver el estado de un nro. de asiento válido recibido como parámetro
vi. ocupar un nro. de asiento válido recibido como parámetro
vii. liberar un nro. de asiento válido recibido como parámetro
viii. devolver el nro. del primer asiento libre

 *
 */
public class Micro_Joa {

    private String patente;
    private String destino;
    private String hora;
    private boolean[] asiento;                                                  
    private int cantOcupados;
    private final int fin = 5;                                                        //PARA NO CARGAR LOS 20 ASIENTOS

//------------------------------------------------------------------------------
    public Micro_Joa(String patente, String destino, String hora) {
        this.patente = patente;
        this.destino = destino;
        this.hora = hora;
        this.asiento = new boolean[fin];
        this.cantOcupados = 0;

        for (int i = 0; i < fin; i++) {                                         //INICIALIZO PORQUE EN LA TEORIA NOS DIJERON QUE LO HAGAMOS
            asiento[i] = false;
        }
    }

//------------------------------------------------------------------------------
    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getAsientosOcupados() {
        return cantOcupados;
    }

//------------------------------------------------------------------------------
    public boolean microLleno() {
        for (int i = 0; i < fin; i++) {
            if (asiento[i] == false) {
                return false;
            }
        }
        return true; 
        
        //return this.getAsientosOcupados() == fin; //OTRA OPCION
    }

    public boolean nroAsiento(int numero) {
        boolean aux=false;
        if ((numero >= 0) && (numero < fin)) {                                  
            aux = true;
        }
        return aux;
    }
    
    public boolean devolverEstado(int numero){
       return asiento[numero];
    }
    
    public void ocuparAsiento(int numero){
        asiento[numero]=true;
        cantOcupados++;
    }
    
    public void liberarAsiento(int numero){
        asiento[numero]=false;
        cantOcupados--;
    }
    
    public int primerAsiento(){
        int i=0;
        while((i<fin)&&(asiento[i] != true)){
            i++;                                                             
        }
        return i;
    }        
    

}
