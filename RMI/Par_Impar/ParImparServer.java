import java.rmi.Naming;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ParImparServer implements ParImpar {
    public ParImparServer(){}

    @Override
    public boolean isPar(int number) throws RemoteException{
        return ((number % 2) == 0);
    }

    public static void main(String[] args){

        try{
            ParImparServer server = new ParImparServer();
            ParImpar parImpar = (ParImpar) UnicastRemoteObject.exportObject(server,0);

            Registry registry = LocateRegistry.createRegistry(3099);
            registry.bind("ParImpar", parImpar);

            System.err.println("Server Ready");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}