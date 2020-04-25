 
import java.rmi.Naming; 
import java.rmi.RemoteException; 
import java.net.MalformedURLException; 
import java.rmi.NotBoundException; 
 import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ParImparClient { 
 
    public static void main(String[] args) { 
        try { 
		
            Registry registry = LocateRegistry.getRegistry(3099);
            ParImpar parImpar = (ParImpar) registry.lookup("ParImpar");
		        
	       	System.out.println("Ingrese el numero: ");
            int numero = Integer.parseInt(System.console().readLine());
	
		    System.out.println("Resultado: " +parImpar.isPar(numero));

        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
} 

