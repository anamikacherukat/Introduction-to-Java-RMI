import java.rmi.registry.LocateRegistry; 
import java.rmi.registry.Registry;  

public class CalculatorClient {
    private CalculatorClient() {}  
   public static void main(String[] args) {  
      try {  
         // Getting the registry 
         Registry registry = LocateRegistry.getRegistry(null); 
    
         // Looking up the registry for the remote object 
         Calculator stub = (Calculator) registry.lookup("Calculator"); 
    
         // Calling the remote method using the obtained object 
         stub.pushValue(10);
         stub.pushValue(30);
         stub.pushValue(50);
         stub.pushOperation("min");

         System.out.println(stub.pop());
         //stub.mul(3, 4);
         
         // System.out.println("Remote method invoked"); 
      } catch (Exception e) {
         System.err.println("Client exception: " + e.toString()); 
         e.printStackTrace(); 
      } 
   } 
}
