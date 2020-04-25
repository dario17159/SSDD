import java.io.Console;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.*;

public class ServidorMaterias implements Materias{

 public ServidorMaterias() {}
 @Override
 public String consultarMateria(int dia){
   String materias ="";

        switch(dia){

            case 1:
                /*materias.add(6103);
                materias.add(7540);*/
                    materias="IS3";
                    return materias;
                //break;

            case 2:
          //materias.add(5068);
                    materias="Web";
                    return materias;
                    //break;

            case 3:
                //materias.add(6103);
                //materias.add(7540);
                      materias="Web, IS3";                
                      return materias;
                //break;

            case 4:
          //materias.add(5068);
                      materias="SSDD";
                      return materias;
                      //break;

            case 5:
          //materias.add(6201);
                      materias="Día libre";
                      return materias;
                      //break;

            default:
		materias="Ninguna,se cursa de lunes a viernes";
                return materias;
                //break;
        }
 }

  public static void main(String args[]){

    try {
      ServidorMaterias server = new ServidorMaterias();
      Materias materias = (Materias) UnicastRemoteObject.exportObject(server, 0);

      Registry registry = LocateRegistry.createRegistry(5099);
      registry.bind("Materias",materias);

      System.err.println("Ready Server");
    } catch (Exception e) {
      e.printStackTrace();
    }
 }
}
