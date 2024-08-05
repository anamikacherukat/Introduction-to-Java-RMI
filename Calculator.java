import java.rmi.Remote; 
import java.rmi.RemoteException;  

// Creating Remote interface for our application 
public interface Calculator extends Remote {  
    void pushValue(int val)
    throws java.rmi.RemoteException; 

    void pushOperation(String operator) 
    throws java.rmi.RemoteException; 

    int pop()
    throws java.rmi.RemoteException; 

    boolean isEmpty()
    throws java.rmi.RemoteException; 

    int delayPop(int millis)
    throws java.rmi.RemoteException; 
} 