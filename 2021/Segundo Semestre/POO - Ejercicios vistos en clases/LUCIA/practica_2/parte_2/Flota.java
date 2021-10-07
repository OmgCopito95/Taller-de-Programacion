/*Definir una clase para representar flotas de micros. Una flota se caracteriza por conocer 
a los micros que la componen (a lo sumo 15). Defina un constructor para crear una flota vacía (sin micros).
Implemente métodos para:

  i). devolver si la flota está completa (es decir, si tiene 15 micros o no).
  ii). agregar a la flota un micro recibido como parámetro.
  iii). eliminar de la flota el micro con patente igual a una recibida como parámetro,
        y retornar si la operación fue exitosa.
  iv). buscar en la flota un micro con patente igual a una recibida como parámetro
       y retornarlo (en caso de no existir dicho micro, retornar null).
  v). buscar en la flota un micro con destino igual a uno recibido como parámetro
     y retornarlo (en caso de no existir dicho micro, retornar null).
 */
package tema4;

public class Flota {

    private Micro[] vFlota;
    private int dimF = 15;

    //================ CONSTRUCTOR FLOTA VACIA ================//
    public Flota() {
        int i;
        this.vFlota = new Micro[this.dimF];
        for (i = 0; i < dimF; i++) {
            vFlota[i] = null;
        }
    }

    //================ INCISO A i ================//
    public int cantMicros() {   //TE CONVIENE TENER UNA VARIABLE QUE SEA LA DIML DEL VECTOR DE MICROS ASI NO HACES TODO ESTO
        int i = 0;
        while ((i < dimF) && (this.vFlota[i] != null)) {
            i++;
        }
        if (i > this.dimF) {
            return -1;
        } else {
            return i;
        }
    }

    //================ INCISO A ii ================// 
    public void AgregarMicro(Micro m) {  //TENDRIAS QUE AGREGARLO EN UN ESPACIO LIBRE, PARA ESTO TE VA A SERVIR LA DIML
        int pos = 0;  //SIEMPRE QUE ENTRA SE PONE EN CERO, ESTAS PISANDO DATOS
        this.vFlota[pos] = m;
        pos++;
    }

    //================ INCISO A iii ================// 
    public boolean EliminarMicroPatente(String patente) {      //DEBERIAS HACER UN CORRIMIENTO DE DATOS PARA QUE EL VECTOR NO QUEDE CON UN HUECO Y PUEDAS USAR DIML
        int pos = 0;
        while ((pos < this.dimF) && (!this.vFlota[pos].getPatente().equals(patente))) {
            pos++;
        }
        if (pos > this.dimF) {
            return false;
        } else {
            this.vFlota[pos] = null;
            return true;
        }

    }

    //================ INCISO A iv ================// 
    public String buscarPatente(String patente) { //NO DEVUELVE UN STRING, DEVUELVE UN OBJETO
        int pos = 0;
        while ((pos < this.dimF) && (!this.vFlota[pos].getPatente().equals(patente))) {
            pos++;
        }
        if (pos > this.dimF) {
            return "null";  
        } else {
            return patente;
        }
    }

    //================ INCISO A v ================// 
    public String buscarDestino(String destino) { //NO DEVUELVE UN STRING, DEVUELVE UN OBJETO
        int pos = 0;
        while ((pos < this.dimF) && (!this.vFlota[pos].getDestino().equals(destino))) {
            pos++;
        }
        if (pos > this.dimF) {
            return "null";
        } else {
            return destino;
        }
    }
}
