package OMAR.practica_2.ejercicio5;


public class Micro {

    private String patente;
    private String destino;
    private String horaSalida;
    private final boolean[] vAsientos;
    private int cantAsientosOcupados;
    private final int dimf = 20;

    public Micro(String patente, String destino, String horaSalida) {
        this.patente = patente;
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.vAsientos = new boolean[this.dimf];
        this.cantAsientosOcupados = 0;
        this.inicializarVector(); //Digo que el micro va a empezar totalmente vacío
    }

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

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setSalida(String salida) {
        this.horaSalida = salida;
    }

    public final void inicializarVector() {
        for (int i = 0; i < this.vAsientos.length; i++) {
            this.vAsientos[i] = true; //Digo que el micro va a empezar totalmente vacío
        }
    }

    public int getCantAsientosOcupados() {
        return cantAsientosOcupados;
    }

    public boolean getMicroLleno() {
        return this.getCantAsientosOcupados() == this.dimf;
    }

    public boolean getRango(int nAsiento) {
        return (nAsiento >= 0) && (nAsiento < this.dimf);
    }

    public boolean getEstadoAsiento(int nAsiento) {
        return this.vAsientos[nAsiento] == true;
    }


    public void ocuparAsiento(int nAsiento) {
        if (this.vAsientos[nAsiento] == true) {
            this.vAsientos[nAsiento] = false;
            this.cantAsientosOcupados++;
        }
    }

    public void desocuparAsiento(int nAsiento) {
        if (this.vAsientos[nAsiento] == false) {
            vAsientos[nAsiento] = true;
            this.cantAsientosOcupados--;
        }
    }

    public int getPrimerAsientoLibre() {
        int pos = 0;
        while ( (pos < this.vAsientos.length) && (vAsientos[pos] == false) ) {
            pos++;
        }
        if (vAsientos.length != pos) {
            return pos;
        } else {
            return -1;
        }
    }

    public void mostrarMicro() {
        for (int i = 0; i < this.vAsientos.length; i++) {
            if (vAsientos[i] == true) {
                System.out.println(i + ". [ASIENTO LIBRE]");
            } else {
                System.out.println(i + ". [ASIENTO OCUPADO]");
            }
        }
    }

    @Override
    public String toString() {
        return "Patente " + this.getPatente() + " - Destino " + this.getDestino() + " - Hora de salida " + this.getHoraSalida();
    }
    
    

}
