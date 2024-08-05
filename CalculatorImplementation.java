import java.rmi.RemoteException;
import java.util.Stack;
import java.util.*;

public class CalculatorImplementation implements Calculator{
        Stack<Integer> STACK = new Stack<Integer>();

 
    public void pushValue(int a) 
        throws java.rmi.RemoteException { 
        System.out.println("Pushing value " + a);
        STACK.push(a);
    } 
 
    public void pushOperation(String operator) 
        throws java.rmi.RemoteException { 
        if(operator.equals("min"))
        {
            int minVal = STACK.pop();
            while(!STACK.empty())
            {
                minVal = Math.min(minVal, STACK.peek());
                STACK.pop();
            }
            STACK.push(minVal);
        }
        else if (operator.equals("max"))
        {
            int maxValue = STACK.pop();
            while(!STACK.empty())
            {
                maxValue = Math.max(maxValue, STACK.peek());
            }
            STACK.push(maxValue);
        }
        else if(operator.equals("gcd"))
        {
            if(STACK.size()<2)
            {
                System.out.println(" At least 2 values are required to perform this operation. ");
            }
            while(STACK.size()>1)
            {
                int a = Math.abs(STACK.peek());
                STACK.pop();
                int b = Math.abs(STACK.peek());
                STACK.pop();
                STACK.push(gcd(a,b));
            }
        }
        else if(operator.equals("lcm"))
        {
            if(STACK.size()<2)
            {
                System.out.println(" At least 2 values are required to perform this operation. ");
            }
            while(STACK.size()>1)
            {
                int a = Math.abs(STACK.peek());
                STACK.pop();
                int b = Math.abs(STACK.peek());
                STACK.pop();
                STACK.push(lcm(a,b));
            }
        }

        else
        {
            System.out.println("Invalid operator. ");
        }
    } 
 
    private int lcm(int a, int b)
    {
        if(a == 0|| b==0) return 0;
        return Math.abs(a*b)/gcd(a,b);
    }
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
    public int pop() throws RemoteException
    {
        if(STACK.isEmpty())
        {
            System.out.println("Error: Stack is empty. ");
            return -1;
        }
        System.out.println("Popping value");
        int val = STACK.peek();
        STACK.pop();
        return val;
    }

    public boolean isEmpty() throws RemoteException{
        System.out.println("Checking if client stack is empty");
        return (STACK.isEmpty());
    }
    public int delayPop(int millis) throws RemoteException
    {
        int val = 0;
        try {
            System.out.println("Delaying pop for " + millis + " milliseconds");
            // Wait for 'millis' milliseconds before poping
            Thread.sleep(millis);
            val = STACK.peek();
            STACK.pop();
        } catch (InterruptedException e) {
            System.out.println("Interrupted exception: " + e.toString());
            e.printStackTrace();
        }
        return val;
    }
} 

