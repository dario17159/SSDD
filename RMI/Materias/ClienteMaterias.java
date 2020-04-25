import java.io.Console;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClienteMaterias {
 
  private ClienteMaterias() {}
 
  public static void main(String[] args){
  
    try {
      System.out.println("Ingrese Dia de la semana");
      System.out.println("1- Lunes");
      System.out.println("2- Martes");
      System.out.println("3- Miercoles");
      System.out.println("4- Jueves");
      System.out.println("5- Viernes");
      System.out.print(" #> ");
      int dia = Integer.parseInt(System.console().readLine());
   
      Registry registry = LocateRegistry.getRegistry(5099);
      Materias materias = (Materias) registry.lookup("Materias");
      String respuesta = materias.consultarMateria(dia);
      System.out.println("Las materias a cursar son: " + respuesta);
   
   
    } catch (Exception e) {
   
      e.printStackTrace();
    }
  }
}
