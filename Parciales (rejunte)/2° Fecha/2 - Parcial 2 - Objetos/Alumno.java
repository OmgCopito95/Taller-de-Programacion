package parcial.pkg2;

public class Alumno {
    private String nombre;
    private int edad;
    private String instrumento;
    private double puntaje;
    
    public Alumno(String unNombre , int unaEdad , String unInstrumento){
        this.nombre = unNombre;
        this.edad = unaEdad;
        this.instrumento = unInstrumento;
        this.puntaje = -1;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(String instrumento) {
        this.instrumento = instrumento;
    }

    public double getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(double puntaje) {
        this.puntaje = puntaje;
    }
    
    
    
}
