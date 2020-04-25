import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ParImpar extends Remote{
    public boolean isPar(int number) throws RemoteException;
}