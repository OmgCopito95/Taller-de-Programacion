package tema5;

public class ClaseA {

    public int dos() {
        System.out.println("claseA dos");
        return 2;
    }

    public int tres() {
        System.out.println("claseA tres");
        return this.dos() + this.siete();
    }
               
    public int siete() {
        System.out.println("claseA siete");
        return 9;
    }
    
    /*public int seis() {
        System.out.println("claseA seis");
        return this.dos();
    }*/
}
