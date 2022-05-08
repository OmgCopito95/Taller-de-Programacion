package parcial5;

public class Main {
    public static void main(String[] args) {
        LibroElectronico l1 = new LibroElectronico("Titulo1",1.0,"Formato",1);
        
        LibroImpreso l2 = new LibroImpreso("Titulo2",2.0,true);
        
        l1.agregarAutor("Autor1");
        l1.agregarAutor("Autor2");
        l1.agregarAutor("Autor3");
        
        l2.agregarAutor("Autor4");
        l2.agregarAutor("Autor5");
        l2.agregarAutor("Autor6");
        
        System.out.println(l1.toString());
        
        System.out.println(l2.toString());
    }
    
}