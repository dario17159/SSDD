
import java.rmi.Naming;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorServer implements Calculator {

    public CalculatorServer() {

    }

    @Override
    public int suma(int a, int b)
            throws RemoteException {
        return a + b;
    }

    @Override
    public int resta(int a, int b)
            throws RemoteException {
        return a - b;
    }

    @Override
    public int divide(int a, int b)
            throws RemoteException {
        return a / b;
    }

    @Override
    public int multiplica(int a, int b)
            throws RemoteException {
        return a * b;
    }

    public static void main(String args[]) {

        try {
            CalculatorServer server = new CalculatorServer();
            Calculator calculator = (Calculator) UnicastRemoteObject.exportObject(server, 0);

            // Liga los datos (calculator) del objeto remoto en el registro
            Registry registry = LocateRegistry.createRegistry(3099);
            registry.bind("Calculator", calculator);

            System.err.println("Server Ready");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


