class p1{

}

class p2 extends p1{

}
class p3 extends p1{}


public class Testing3 {
    public static void main(String args[]){  
         p1 t = new p2(); 
        p3 p = (p3) t;
    }
}
