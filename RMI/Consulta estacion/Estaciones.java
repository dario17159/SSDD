import java.rmi.Remote;
import java.rmi.RemoteException;
public interface Estaciones extends Remote{

    public String consultarEstacion (String fecha) throws RemoteException;
}
