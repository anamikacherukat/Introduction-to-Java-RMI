import java.rmi.RemoteException;
import java.util.*;

public class CalculatorImplementation implements Calculator{

    int flag = 0;
    // Map of clientID to client stack
    private Map<Integer, Stack<Integer>> clientStacks = new HashMap<>();

    // Check if clientID is unique
    public boolean createNewClientID(int clientID) throws RemoteException {
        if (clientStacks.containsKey(clientID)) {
            return false;
        }
        System.out.println("Created new client ");
        return true;
    }

    // Create a new stack for the client
    public void createNewClientStack(int clientID) throws RemoteException {
        
       
        Stack<Integer> newStack = new Stack<>();
        clientStacks.put(clientID, newStack);
    }

      //Stack<Integer> STACK = new Stack<Integer>();

//  Define pushValue function to push value into the stack
    public void pushValue(int a, int clientID) 
        throws java.rmi.RemoteException { 
        System.out.println("Pushing value " + a);
        clientStacks.get(clientID).push(a);
        System.out.println("Pushed value " + a + " into stack ");
        //STACK.push(a);
    } 
// Define pushOperation function to push operator into the stack it checks using if else loop if the operator matches with either of min, max, lcm or gcd
    public void pushOperation(String operator, int clientID) 
        throws java.rmi.RemoteException { 
             
        if(operator.equals("min"))
        {
            int minimumVal = clientStacks.get(clientID).peek();
            clientStacks.get(clientID).pop();
            while (!clientStacks.get(clientID).empty()) {
                minimumVal = Math.min(minimumVal, clientStacks.get(clientID).peek());
                clientStacks.get(clientID).pop();
            }
            // Push the minimum value to the client stack
            clientStacks.get(clientID).push(minimumVal);
        }
        else if (operator.equals("max"))
        {
            int maximumVal = clientStacks.get(clientID).peek();
            clientStacks.get(clientID).pop();
            while (!clientStacks.get(clientID).empty()) {
                maximumVal = Math.max(maximumVal, clientStacks.get(clientID).peek());
                clientStacks.get(clientID).pop();
            }
            // Push the maximum value to the client stack
            clientStacks.get(clientID).push(maximumVal);
        }
        else if(operator.equals("gcd"))
        {
            if (clientStacks.get(clientID).size() < 2) {
                System.out.println("Error: At least two values are required to perform an operation.");
                return;
            }
            if (clientStacks.get(clientID).contains(0)) {
                System.out.println("The stack contains 0");
                return;
                }
            while (clientStacks.get(clientID).size() > 1) {
                int var1 = clientStacks.get(clientID).pop();
                int var2 = clientStacks.get(clientID).pop();
                // Push the greatest common divisor into the stack
                clientStacks.get(clientID).push(gcd(var1 , var2));
                }
        }
        else if(operator.equals("lcm"))
        {
            if (clientStacks.get(clientID).size() < 2) {
                System.out.println("Error: At least two values are required to perform an operation.");
                return;
            }
            while (clientStacks.get(clientID).size() > 1) {
                int a = Math.abs(clientStacks.get(clientID).peek());
                clientStacks.get(clientID).pop();
                int b = Math.abs(clientStacks.get(clientID).peek());                    clientStacks.get(clientID).pop();
                // Push the least common multiple into the stack
                clientStacks.get(clientID).push(lcm(a, b));
            }
        }

        else
        {
            flag = 1;

            System.out.println("Invalid operator. ");
        }
    } 
 
    // Define lcm function which calculates the lcm of two variables, by calling the gcd function. 
    private int lcm(int a, int b)
    {
        if(a == 0|| b==0) return 0;
        return Math.abs(a*b)/gcd(a,b);
    }
    // Define gcd function to calculate the gcd of two variables
    private int gcd(int a,int b)
    {
        int gcd = 1;
        for(int i=1;i<=a && i<=b;i++)
        {
            if(a%i ==0 && b%i ==0)
            {
                gcd = i;

            }
        }
        return gcd;
    }
    // Define pop function to pop the values of the stack 
    public int pop(int clientID) throws RemoteException
    {
        if(isEmpty(clientID))
        {
            System.out.println("Error: Stack is empty. ");
            return -1;
        }
        System.out.println("Popping value");
        int val = clientStacks.get(clientID).peek();
        clientStacks.get(clientID).pop();
        return val;
    }

    // Define isEmpty function to check if stack is empty 
    public boolean isEmpty(int clientID) throws RemoteException{
        System.out.println("Checking if stack is empty");
        return (clientStacks.get(clientID).isEmpty());
    }
    // Define function delayPop to delay the pop for milliseconds
    public int delayPop(int millis, int clientID) throws RemoteException
    {
        int val = 0;
        System.out.println("Delaying pop for " + millis + " milliseconds");

        try {
            System.out.println("Delaying pop for " + millis + " milliseconds");
            // Wait for 'millis' milliseconds before poping
            Thread.sleep(millis);
            //val = clientStacks.get(clientID).peek();
            val = clientStacks.get(clientID).pop();
            System.out.println("Delayed pop for " + millis + " milliseconds");
            //return val;

        } catch (InterruptedException e) {
            System.out.println("Interrupted exception: " + e.toString());
            e.printStackTrace();
        }
        return val;
    }

    public boolean checkforZero(int clientID) throws RemoteException {
        System.out.println("Checking if client stack has value 0");
        // If the client stack contains 0, remove all values from the stack
        if (clientStacks.get(clientID).contains(0)) {
            return true;
        }
        return false;
    }
    public boolean invalidOperator(int clientID) throws RemoteException {
        
        return true;
    }
    public int stackSize(int clientID) throws RemoteException {
        return clientStacks.get(clientID).size();
    }





} 

