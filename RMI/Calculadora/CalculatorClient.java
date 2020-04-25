 
import java.rmi.Naming; 
import java.rmi.RemoteException; 
import java.net.MalformedURLException; 
import java.rmi.NotBoundException; 
 import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorClient { 
 
    public static void main(String[] args) { 

		int option, firstNumber, secondNumber;

        try { 
		
			Registry registry = LocateRegistry.getRegistry(3099);
			Calculator calculator = (Calculator) registry.lookup("Calculator");
		        
			System.out.println("Seleccione una Operaci\u00f3n:");
			System.out.println("1- Suma");
			System.out.println("2- Resta");
			System.out.println("3- Division");
			System.out.println("4- Multiplicaci\u00f3n");
			System.out.print(" #> ");
			option = Integer.parseInt(System.console().readLine());
			System.out.print("Ingrese el primer n\u00famero: ");
			firstNumber = Integer.parseInt(System.console().readLine());
			System.out.print("Ingrese el segundo n\u00famero: ");
			secondNumber = Integer.parseInt(System.console().readLine());

			switch(option){

				case 1: 
					System.out.println("El resultado de la suma es: "+ calculator.suma(firstNumber, secondNumber) ); 
				break;

				case 2:
					System.out.println("El resultado de la resta es: "+ calculator.resta(firstNumber, secondNumber) ); 
				break;

				case 3:
					System.out.println("El resultado de la divisi\u00f3n es: "+ calculator.divide(firstNumber, secondNumber) ); 
				break;

				case 4:
					System.out.println("El resultado de la multiplicaci\u00f3n es: "+ calculator.multiplica(firstNumber, secondNumber) ); 
				break;
			}
        } catch (Exception e) {
			e.printStackTrace();
		}
       
    } 
} 

