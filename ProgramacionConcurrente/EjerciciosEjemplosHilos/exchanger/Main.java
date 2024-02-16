package exchanger;

import java.util.concurrent.Exchanger;

public class Main {

    public static void main(String[] args) {
        
        Exchanger<String> v_exchanger = new Exchanger<>();
        
        Amigo amigo1 = new Amigo("Amigo 1", v_exchanger);
        Amigo amigo2 = new Amigo("Amigo 2", v_exchanger);
        
        amigo1.start();
        amigo2.start();           
    } 
}


