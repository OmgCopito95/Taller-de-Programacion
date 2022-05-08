package parcial6;

public class Main {

    public static void main(String[] args) {
        CompraMayorista c1 = new CompraMayorista(1,10,1234);
        
        CompraMinorista c2 = new CompraMinorista(2,20,true);
        
        Producto p1 = new Producto(1,2.0,1.0);
        Producto p2 = new Producto(2,2.0,1.0);
        Producto p3 = new Producto(3,2.0,1.0);
        
        Producto p4 = new Producto(4,2.0,1.0);
        Producto p5 = new Producto(5,2.0,1.0);
        Producto p6 = new Producto(6,2.0,1.0);
        
        c1.agregarCompra(p1);
        c1.agregarCompra(p2);
        c1.agregarCompra(p3);
        
        c2.agregarCompra(p4);
        c2.agregarCompra(p5);
        c2.agregarCompra(p6);
        
        System.out.println(c1.toString());
        System.out.println(c2.toString());
    }
    
}
