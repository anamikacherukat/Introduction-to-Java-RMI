import java.rmi.Remote; 
import java.rmi.RemoteException;  

// Creating Remote interface for our application 
public interface Calculator extends Remote {  

    boolean createNewClientID(int clientID)
    throws java.rmi.RemoteException;

    void createNewClientStack(int clientID)
    throws java.rmi.RemoteException;

    void pushValue(int val, int clientID)
    throws java.rmi.RemoteException; 

    void pushOperation(String operator, int clientID) 
    throws java.rmi.RemoteException; 

    int pop(int clientID)
    throws java.rmi.RemoteException; 

    int stackSize(int clientID)
    throws java.rmi.RemoteException; 

    boolean isEmpty(int clientID)
    throws java.rmi.RemoteException; 

    boolean checkforZero(int clientID)
    throws java.rmi.RemoteException; 

    boolean  invalidOperator(int clientID)
    throws java.rmi.RemoteException; 

    int delayPop(int millis, int clientID)
    throws java.rmi.RemoteException; 
} 