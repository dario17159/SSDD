import java.rmi.Remote;
import java.rmi.RemoteException;
public interface Materias extends Remote{
    public String consultarMateria (int dia) throws RemoteException;
}
