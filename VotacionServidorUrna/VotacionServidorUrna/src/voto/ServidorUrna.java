package voto;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServidorUrna {
    
            public static void main(String[] args) {
        try{
            
            Registry register=LocateRegistry.createRegistry(4070);
            register.rebind("urna", new ImplementarVoto());
            
            System.out.println("servidor urna en linea");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
