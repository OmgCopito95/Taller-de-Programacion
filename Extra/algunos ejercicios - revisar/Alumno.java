package repaso;
/*
De cada alumno registra su nombre, edad, el instrumento que toca y puntaje obtenido.
Los alumnos deben instanciarse dando valor a todos sus atributos.
 */
public class Alumno {
  private String nombre;
  private int edad;
  private String instrumento;
  private double puntaje;
  
  //CONSTRUCTOR
  public Alumno (String nombre,int edad, String instrumento, double puntaje){
    setNombre (nombre);
    setEdad (edad);
    setInstrumento (instrumento);
    setPuntaje (puntaje);

  }
  
  //GETTER AND SETTER

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
