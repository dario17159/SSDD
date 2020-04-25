
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServidorEstaciones implements Estaciones{

  public ServidorEstaciones() {}

  @Override
 public String consultarEstacion(String fecha) throws RemoteException {
   /* 
    Primavera: 21 septiembre hasta 20 diciembre
    Verano: 21 diciembre hasta 20 marzo
    Otoño: 21 marzo hasta 20 junio
    Invierno: 21 junio hasta 20 septiembre
 */
  String[] numeros = fecha.split("/");
  int dia = Integer.parseInt(numeros[0]);
  int mes = Integer.parseInt(numeros[1]);
  String estacion ="No existe!";
  System.out.println(" dia: "+ Integer.parseInt(numeros[0])+" mes: "+ Integer.parseInt(numeros[1]));
  
  switch(mes){
    case 9:
      if(dia >= 1 && dia <=20){
        estacion ="Invierno";
      }else if(dia >= 21 && dia <= 30 ){
        estacion = "Primavera";
      }
      break;
    case 10:
      if(dia >=1 && dia <= 31){
        estacion = "Primavera";
      }
      break;
    case 11:
      if(dia >= 1 && dia <= 30){
        estacion ="Primavera";
      }
      break;
    case 12:
      if(dia >=1 && dia <=20){
        estacion ="Primavera";
      }else if(dia>=21 && dia<=31){
        estacion = "Verano";
      }
      break;
    case 1:
      if(dia>= 1 && dia <= 31){
        estacion = "Verano";
      }
      break;
    case 2:
      if(dia >= 1 && dia <=29){
        estacion = "Verano";
      }
      break;
    case 3:
      if(dia>=1 && dia <= 20){
        estacion ="Verano";
      }else if( dia >=21 && dia <= 31){
        estacion = "Otoño";
      }
      break;
    case 4:
      if(dia>=1 && dia <=30){
        estacion ="Otoño";
      }
      break;
    case 5:
      if(dia >= 1 && dia <= 31){
        estacion ="Otoño";
      }
      break;
    case 6:
      if(dia >=1 && dia <= 20){
        estacion ="Otoño";
      }else if( dia >=21 && dia <=30){
        estacion = "Invierno";
      }break;
    case 7:
      if(dia >= 1 && dia <= 31){
        estacion ="Invierno";
      }
      break;
    case 8: 
      if(dia >= 1 && dia <= 31){
        estacion ="Invierno";
      }   
      break;
  }

  
   return estacion;
 }

  public static void main(String args[]){

  try {
    ServidorEstaciones servidor = new ServidorEstaciones();
    Estaciones estaciones = (Estaciones) UnicastRemoteObject.exportObject(servidor, 0);

    Registry registry = LocateRegistry.createRegistry(5999);
    registry.bind("Estaciones",estaciones);

    System.err.println("Ready Server");
  } catch (Exception e) {
    e.printStackTrace();
  }
 }

 
}
