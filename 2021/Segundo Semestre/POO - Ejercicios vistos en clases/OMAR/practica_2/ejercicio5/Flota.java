
public class Flota {

    private final Micro[] m;
    private int cantMicros;
    private final int dimF = 5;

    public Flota() {
        this.cantMicros = 0;
        this.m = new Micro[dimF];
        this.inicializarVectorMicros();
    }

    public boolean getEstaCompleta() {
        return this.cantMicros == this.dimF;
    }

    public void agregarAFlota(Micro micrito) {
        if (this.cantMicros < this.dimF) {
            m[this.cantMicros] = micrito;
            this.cantMicros++;
        }
    }

    public boolean eliminarMicro(String patente) {
        int pos = 0;
        while ( (this.m[pos] != null) && (pos < this.cantMicros) && (!m[pos].getPatente().equals(patente))) {
            pos++;
        }
        if ( (this.m[pos] != null) && (this.m[pos].getPatente().equals(patente)) ) {
            for (int i = (pos+1); i < this.dimF; i++) {
                m[i-1] = m[i];
            }
            this.cantMicros--;
            return true;
        } else {
            return false;
        }
    }

    public Micro buscarMicroPatente(String patente) {
        int pos = 0;
        while ( (this.m[pos] != null) && (pos < this.cantMicros) && (!this.m[pos].getPatente().equals(patente)) ) {
            pos++;
        }
        if ( (this.m[pos] != null) && (this.m[pos].getPatente().equals(patente))) {
            return this.m[pos];
        } else {
            return null;
        }
    }

    public Micro buscarMicroDestino(String destino) {
        int pos = 0;
        
        while ( (this.m[pos] != null) && (pos <= this.cantMicros) && (!this.m[pos].getDestino().equals(destino))) {
            pos++;
        }
        if ( (this.m[pos] != null) && (this.m[pos].getDestino().equals(destino)) ) {
            return this.m[pos];
        } else {
            return null;
        }
    }

    private void inicializarVectorMicros() {
        for (int i = 0; i < this.m.length; i++) {
            m[i] = null;
        }
    }

    public void mostrarVectorMicros() {  //prueba
        for (int i = 0; i < this.cantMicros; i++) {
            System.out.println(i + ". " + this.m[i].toString());
        }
    }
}
