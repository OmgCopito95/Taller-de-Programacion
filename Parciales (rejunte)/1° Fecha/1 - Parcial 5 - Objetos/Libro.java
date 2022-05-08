package parcial5;

public abstract class Libro {
    private String titulo;
    private double precioBase;
    private String autores[];
    
    private final int DIMF = 8;
    private int dimL;
    
    public Libro(String unTitulo , double unPrecioBase){
        this.setTitulo(unTitulo);
        this.setPrecioBase(unPrecioBase);
        autores = new String[DIMF];
        this.dimL = 0;
        for (int i=0 ; i<DIMF ; i++){
            autores[i] = null;
        }
    }
    
    public void agregarAutor(String unAutor){
        autores[dimL] = unAutor;
        dimL++;
    }
    
    public abstract double calcularPrecioFinal();

    public String toString() {
        return "titulo: " + this.getTitulo() +
               " precio final: " + this.calcularPrecioFinal() +
               " autores: " + this.imprimirAutores();
    }
    
    private String imprimirAutores(){
        String aux = "";
        for (int i=0;i<dimL;i++){
            aux += autores[i] + " - ";
        }
        return aux;
    }
    
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }
    
    
}
