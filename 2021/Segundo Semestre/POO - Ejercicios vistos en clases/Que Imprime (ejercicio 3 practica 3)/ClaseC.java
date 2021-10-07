package tema5;

public class ClaseC extends ClaseB{

    public int uno() {
        System.out.println("claseC uno");
        return this.cuatro();
    }       

    public int dos() {
        System.out.println("claseC dos");
        this.siete();
        return 9;
    }

    public int cinco() {
        System.out.println("claseC ciinco");
        return super.seis();
    }
}
