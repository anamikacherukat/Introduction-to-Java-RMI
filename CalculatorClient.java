import java.rmi.registry.LocateRegistry; 
import java.rmi.registry.Registry;  

public class CalculatorClient {
    private CalculatorClient() {}  
   public static void main(String[] args) {  
      try {  
         // Getting the registry 
         System.out.println("Welcome to Calculator application ");
         Registry registry = LocateRegistry.getRegistry(null); 
    
         // Looking up the registry for the remote object 
         Calculator stub = (Calculator) registry.lookup("Calculator"); 
        
        // Test case 1 - Test min operation with values {10,30,50}
        System.out.println(" Test Case 1 - ");
        System.out.println(" Minimum of 10, 20, 30 -> ");
        stub.createNewClientID(0);
        stub.createNewClientStack(0);
        stub.pushValue(10,0);
        stub.pushValue(30,0);
        stub.pushValue(50,0);
        stub.pushOperation("min", 0);
        System.out.println(stub.pop(0));
        System.out.println("\n");
        
        // Test case 2 - Test max operation with values {-9,0,50}
        System.out.println(" Test Case 2 - ");
        System.out.println(" Maximum of -9, 0, 50 -> ");
        stub.createNewClientID(0);
        stub.createNewClientStack(0);
        stub.pushValue(-9,0);
        stub.pushValue(0,0);
        stub.pushValue(50,0);
        stub.pushOperation("max", 0);
        System.out.println(stub.pop(0));
        System.out.println("\n");


        // Test case 3 - Test min operation with values {10,-30,-50}
        System.out.println(" Test Case 3 - ");
        System.out.println(" Minimum of -10, -30, -50 -> ");
        stub.createNewClientID(0);
        stub.createNewClientStack(0);
        stub.pushValue(10,0);
        stub.pushValue(-30,0);
        stub.pushValue(-50,0);
        stub.pushOperation("min", 0);
        System.out.println(stub.pop(0));
        System.out.println("\n");


        // Test case 4 - Test min operation with values {3,2}
        System.out.println(" Test Case 4 - ");
        System.out.println(" Minimum of 3, 2 -> ");
        stub.createNewClientID(0);
        stub.createNewClientStack(0);
        stub.pushValue(3,0);
        stub.pushValue(2,0);
        stub.pushOperation("min", 0);
        System.out.println(stub.pop(0));
        System.out.println("\n");

        // Test case 5 - Test max operation with values {10000, 67, -34 , 0}
        System.out.println(" Test Case 5 - ");
        System.out.println(" Maximum of 10000, 67, -34, 0  -> ");
        stub.createNewClientID(0);
        stub.createNewClientStack(0);
        stub.pushValue(10000,0);
        stub.pushValue(67,0);
        stub.pushValue(34,0);
        stub.pushValue(0,0);       
        stub.pushOperation("max", 0);
        System.out.println(stub.pop(0));
        System.out.println("\n");

        // Test case 6  - Test gcd operation with values {6, 9}
        System.out.println(" Test Case 6 - ");
        System.out.println(" GCD of 6, 9 -> ");
        stub.createNewClientID(0);
        stub.createNewClientStack(0);
        stub.pushValue(6,0);
        stub.pushValue(9,0);
        stub.pushOperation("gcd", 0);
        System.out.println(stub.pop(0));
        System.out.println("\n");

        // Test case 7  - Test gcd operation with values {8}
        System.out.println(" Test Case 7 - ");
        System.out.println(" GCD of 8 -> ");
        stub.createNewClientID(0);
        stub.createNewClientStack(0);
        stub.pushValue(8,0);
        stub.pushOperation("gcd", 0);
        if(stub.stackSize(0)<2){ 
            System.out.println(" Error - Cannot calculate GCD since stack has only one value");
        }
        System.out.println("\n");

        // Test case 8  - Test gcd operation with values empty stack 
        System.out.println(" Test Case 8 - ");
        System.out.println(" GCD of empty stack -> ");
        stub.createNewClientID(0);
        stub.createNewClientStack(0);
        stub.pushValue(0,0);
        if(stub.checkforZero(0))
        {
            System.out.println(" Cannot perform GCD since stack contains 0");
        }
        else
        {
            stub.pushOperation("gcd", 0);
        }
        
        //System.out.println(stub.delayPop(2000, 0));

        System.out.println("\n");

        // Test case 9  - Test lcm operation with values {10}
        System.out.println(" Test Case 9 - ");
        System.out.println(" LCM of 10 -> ");
        stub.createNewClientID(0);
        stub.createNewClientStack(0);
        stub.pushValue(10,0);
        stub.pushOperation("lcm", 0);
        if(stub.stackSize(0)<2){ 
            System.out.println(" Error - Cannot calculate LCM since stack has only one value");
        }
        System.out.println("\n");

        // Test case 10  - Test lcm operation with values {20, 40}
        System.out.println(" Test Case 10 - ");
        System.out.println(" LCM of 20, 40  -> ");
        stub.createNewClientID(0);
        stub.createNewClientStack(0);
        stub.pushValue(20,0);
        stub.pushValue(40,0);
        stub.pushOperation("lcm", 0);
        System.out.println(stub.pop(0));
        
        System.out.println("\n");

        // Test case 11  - Test lcm operation with values empty stack 
        System.out.println(" Test Case 11 - ");
        System.out.println(" LCM of empty stack -> ");
        stub.createNewClientID(0);
        stub.createNewClientStack(0);
        stub.pushValue(0,0);
        if(stub.checkforZero(0))
        {
            System.out.println(" Cannot perform LCM since stack contains 0");
        }
        //System.out.println(stub.isEmpty(0));
        else{
        stub.pushOperation("lcm", 0);
        }
        //System.out.println(stub.delayPop(2000, 0));
        
        System.out.println("\n");

        // Test case 12  - Test lcm operation with values {27, 0} 
        System.out.println(" Test Case 12 - ");
        System.out.println(" LCM of 27, 0 -> ");
        stub.createNewClientID(0);
        stub.createNewClientStack(0);
        stub.pushValue(27,0);
        stub.pushValue(0,0);
        if(stub.checkforZero(0))
        {
            System.out.println(" Cannot perform LCM since stack contains 0");
        }
        else
        {
            stub.pushOperation("lcm", 0);
        }

        System.out.println("\n");


        // Test case 13  - Test Invalid operation  
        System.out.println(" Test Case 13 - ");
        System.out.println(" Test Invalid Operation -> ");
        stub.createNewClientID(0);
        stub.createNewClientStack(0);
        stub.pushValue(34,0);
        stub.pushValue(76,0);
        stub.pushOperation("add", 0);
        if(stub.invalidOperator(0))
        {
            System.out.println(" Invalid Operator! Cannot perform the calculation ");
        }
        //System.out.println(stub.delayPop(2000, 0));

        System.out.println("\n");

        // Test case 14  - Pop method on empty stack  
        System.out.println(" Test Case 14 - ");
        System.out.println(" Pop Method on empty stack -> ");
        stub.createNewClientID(0);
        stub.createNewClientStack(0);
        //System.out.println(stub.pop(0));
        if(stub.stackSize(0)<2){ 
            System.out.println(" Error - Cannot pop values since stack is empty");
        System.out.println("\n");
        }
        // Test case 15  - Pop method on values {1,4,7}  
        System.out.println(" Test Case 15 - ");
        System.out.println(" Pop Method on 1, 4, 7 -> ");
        stub.createNewClientID(0);
        stub.createNewClientStack(0);
        stub.pushValue(1,0);
        stub.pushValue(4,0);
        stub.pushValue(7, 0);
        System.out.println(stub.pop(0));

        System.out.println("\n");

        // Test case 16  - isEmpty method on empty stack  
        System.out.println(" isEmpty method on empty stack - ");
        stub.createNewClientID(0);
        stub.createNewClientStack(0);
        System.out.println(stub.isEmpty(0));

        System.out.println("\n");

        // Test case 17  - isEmpty method on values {80,3,7}  
        System.out.println(" Test Case 17 - ");
        System.out.println(" IsEmpty Method on 80, 3, 7 -> ");
        stub.createNewClientID(0);
        stub.createNewClientStack(0);
        stub.pushValue(80,0);
        stub.pushValue(3,0);
        stub.pushValue(7, 0);
        System.out.println(stub.isEmpty(0));

        System.out.println("\n");

        // Test case 18  - test delayPop on {10,20} for client 1 and pop {3,5} for client id 2 
        System.out.println(" Test Case 18 - ");
        System.out.println(" Multiple Clients - Test delayPop on {10,20} for client 1 and pop {3,5} for client Id 2 -> ");
        stub.createNewClientID(1);
        stub.createNewClientStack(1);
        stub.createNewClientID(2);
        stub.createNewClientStack(2);
        stub.pushValue(10,1);
        stub.pushValue(20,1);
        stub.pushValue(3, 2);
        stub.pushValue(5, 2);
        System.out.println(stub.delayPop(2000, 1));
        System.out.println(stub.pop(0));

        System.out.println("\n");

        // Test case 19  - test max on {40,240} for client id 1 and pop {3,5} for client id 2 
        System.out.println(" Test Case 19 - ");
        System.out.println(" Multiple Clients - Test max on {40,20} for Client ID 1 and {3,5} for Client ID 2 -> ");
        stub.createNewClientID(1);
        stub.createNewClientStack(1);
        stub.createNewClientID(2);
        stub.createNewClientStack(2);
        stub.pushValue(40,1);
        stub.pushValue(20,1);
        stub.pushValue(3, 2);
        stub.pushValue(5, 2);
        stub.pushOperation("max", 1);
        System.out.println(stub.pop(2));

        System.out.println("\n");

      } catch (Exception e) {
         System.err.println("Client exception: " + e.toString()); 
         e.printStackTrace(); 
      } 
   } 
}