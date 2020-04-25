import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClienteEstaciones{
 
 private ClienteEstaciones() {}

 public static void main(String[] args){
    try {
      System.out.println("Consultar estacion del a\u00f1o");
      System.out.print("Ingrese la fecha (DD/MM/YYYY): ");
      String fecha = System.console().readLine();
          
      Registry registro = LocateRegistry.getRegistry(5999);
      Estaciones stub = (Estaciones) registro.lookup("Estaciones");

      String respuesta = stub.consultarEstacion(fecha);

      System.out.println("Se encuentra en la estacion: " + respuesta);
    
    } catch (Exception e) {
    
      e.printStackTrace();
    }
  }
}
