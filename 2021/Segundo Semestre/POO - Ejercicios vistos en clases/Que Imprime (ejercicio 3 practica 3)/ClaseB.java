package tema5;

public class ClaseB extends ClaseA {

    public int dos() {
        System.out.println("claseB dos");
        return 5;
    }

    public int cuatro() {
        System.out.println("claseB cuatro");
        return this.dos() + super.tres();
    }
               
    public int seis() {
        System.out.println("claseB seis");
        return this.dos();
    }          
}
