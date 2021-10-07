
public class Autor {

    private String nombreAutor;
    private String biografiaAutor;

    public Autor() {
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getBiografiaAutor() {
        return biografiaAutor;
    }

    public void setBiografiaAutor(String biografiaAutor) {
        this.biografiaAutor = biografiaAutor;
    }

    @Override
    public String toString() {
        return "Autor{" + "nombreAutor=" + nombreAutor + ", biografiaAutor=" + biografiaAutor + '}';
    }
    
}
