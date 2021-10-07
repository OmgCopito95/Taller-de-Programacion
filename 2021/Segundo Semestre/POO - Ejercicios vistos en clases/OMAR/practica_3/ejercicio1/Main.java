public class Main {

    public static void main(String[] args) {
        
        Figura f = new Triangulo("Rojo", "Verde", 2, 6, 4);
        System.out.println(f);
        
        Figura f2 = new Circulo("Violeta", "Celeste", 5);
        System.out.println(f2);
        
        Figura f3 = new Cuadrado("Amarillo", "Naranja", 5);
        System.out.println(f3);
    }
    
}
