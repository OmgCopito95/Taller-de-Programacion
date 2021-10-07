/* Definir una clase para representar micros. Un micro conoce su patente, destino, hora salida, 
el estado de sus 20 asientos (es decir si está o no ocupado) y la cantidad de asientos ocupados al momento. 
Lea detenidamente a) y b) y luego implemente.

A) Implemente un constructor que permita iniciar el micro con una patente,
un destino y una hora de salida (recibidas por parámetro) y sin pasajeros.

B) Implemente métodos para:
  i). devolver/modificar patente, destino y hora de salida
  ii). devolver la cantidad de asientos ocupados
  iii). devolver si el micro está lleno
  iv). validar un número de asiento recibido como parámetro 
       (es decir, devolver si está en rango o no).
  v). devolver el estado de un nro. de asiento válido recibido como parámetro
  vi). ocupar un nro. de asiento válido recibido como parámetro
  vii). liberar un nro. de asiento válido recibido como parámetro
  viii). devolver el nro. del primer asiento libre
 */
package tema4;

public class Micro {

    private String patente;
    private String destino;
    private double HoraSalida;
    private boolean[] vAsiento;
    private int cantAsientosOcupados;      // cantidad de pasajeros
    private int dimF = 20;                  //Constante

    public void InicializarVector() {         //INICIALIZO VECTOR EN FALSE
        int i;
        for (i = 0; i < this.dimF; i++) {
            vAsiento[i] = false;
        }
    }

    public Micro() {   //CONSTRUCTOR NULO

    }

    //=============  INCISO A =============//
    public Micro(String patente, String destino, double HoraSalida) {    //INCISO A
        this.patente = patente;
        this.destino = destino;
        this.HoraSalida = HoraSalida;
        this.cantAsientosOcupados = 0;
        this.vAsiento = new boolean[this.dimF];          //HABRIA QUE INICIALIZAR EL VECTOR EN FALSE ACA
    }

    //=============  INCISO B i =============//
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

    public double getHoraSalida() {
        return HoraSalida;
    }

    public void setHoraSalida(double HoraSalida) {
        this.HoraSalida = HoraSalida;
    }

    //=============  INCISO B ii =============//    
    public int getCantAsientosOcupados() {
        return cantAsientosOcupados;
    }

    //=============  INCISO B iii =============// 
    public boolean microLleno() {
        return this.cantAsientosOcupados == this.dimF;
    }

    //=============  INCISO B iv =============// 
    public boolean validarAsiento(int asiento) {
        return asiento < this.dimF;                 //retorna verdadero si el asiento existe
    }

    //=============  INCISO B v =============// 
    public boolean estadoAsiento(int asiento) {    //Devuelve TRUE si esta ocupado o FALSE si esta desocupado
        return this.vAsiento[asiento];
    }

    //=============  INCISO B vi =============// 
    public void ocuparAsiento(int asiento) {   //VOID???????????  SI
        this.vAsiento[asiento] = true;   //Ocupa asiento
        this.cantAsientosOcupados++;    //suma un pasajero
    }

    //=============  INCISO B vii =============// 
    public void liberarAsiento(int asiento) {   //VOID???????????   SI
        this.vAsiento[asiento] = false;          //Desocupa asiento
        this.cantAsientosOcupados--;           //resta un pasajero
    }

    //=============  INCISO B viii =============// 
    public int primerAsientoLibre(int pos) {            //Si no hay asiento libre, retorna -1
                                                                        //EN REALIDAD NO RECIBE POS POR PARAMETRO, VOS TENES QUE DEVOLVERLO
        while ((pos < this.dimF) && (this.estadoAsiento(pos))) {
            pos++;
        }
        if (pos > this.dimF) {
            return -1;

        } else {
            return pos;

        }
    }
}
