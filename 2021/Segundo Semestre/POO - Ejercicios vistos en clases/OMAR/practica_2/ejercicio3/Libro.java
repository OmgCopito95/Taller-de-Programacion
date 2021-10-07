
public class Libro {

    private String titulo;
    private Autor primerAutor; //Ahora, en vez de usar un tipo de dato String, voy a usar un tipo de dato Autor en donde éste tiene nombre y biografia
    private String editorial;
    private int añoEdicion;
    private String ISBN;
    private double precio;

    public Libro(String unTitulo, String unaEditorial, int unAñoEdicion, Autor unPrimerAutor, String unISBN, double unPrecio) {
        titulo = unTitulo;
        editorial = unaEditorial;
        añoEdicion = unAñoEdicion;
        primerAutor = unPrimerAutor;
        ISBN = unISBN;
        precio = unPrecio;
    }

    public Libro(String unTitulo, String unaEditorial, Autor unPrimerAutor, String unISBN) {
        titulo = unTitulo;
        editorial = unaEditorial;
        añoEdicion = 2015;
        primerAutor = unPrimerAutor;
        ISBN = unISBN;
        precio = 100;
    }

    public Libro() {

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getPrimerAutor() {
        return primerAutor;
    }

    public void setPrimerAutor(Autor primerAutor) {
        this.primerAutor = primerAutor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getAñoEdicion() {
        return añoEdicion;
    }

    public void setAñoEdicion(int añoEdicion) {
        this.añoEdicion = añoEdicion;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Libro{" + "titulo=" + titulo + ", primerAutor=" + primerAutor + ", editorial=" + editorial + ", a\u00f1oEdicion=" + añoEdicion + ", ISBN=" + ISBN + ", precio=" + precio + '}';
    }

    
}
