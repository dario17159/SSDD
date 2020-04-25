  
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote { 
    public int suma(int a, int b) 
        throws RemoteException; 
 
    public int resta(int a, int b) 
        throws RemoteException; 
 
    public int divide(int a, int b) 
        throws RemoteException; 
 
    public int multiplica(int a, int b) 
        throws RemoteException; 
} 

 