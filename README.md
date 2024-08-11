# Introduction to Java RMI - Calculator Application

To gain an understanding of how remote method invocation in Java works, synchronisation, and to develop a working example of a Java RMI system.

<b> Description<b>

To understand the working of a distributed system by developing a Java RMI application. It includes both the server and the client side. 
It is built using a stack into which the client pushes the values and also the operations.
The operations denote the calculation to be performed which includes - min, max, lcm and gcd in this case. 

A hashmap is implemented in the server which links each client's id to their respective stacks.

<b>Methods Implemented for Calculator Operations<b> 

1. boolean NewClientID(int clientID) - Checks if a clientID is unique in stack 
2. void createStack(int clientID) - Creates a new stack for each clientID
3. void pushValue(int value, int clientID) - This method adds an integer value into the client's stack with the associated client ID.
4. void pushOperation(String operator, int ClientID)
This method removes all the values in the client stack and performs either of the 4 operations according to the argument passed - {min, max, gcd, lcm}.
To perform an operation, the client stack must have at least 2 values otherwise an error message is displayed. 
Operators LCM and GCD consider all as absolute values.
4. int pop(int clientID) - Returns the top most value of the stack 
5. boolean isEmpty(int clientID) - Returns true if the client stack is empty
6. int delayPop(int millis, int clientID)  - Waits milliseconds before popping from the stack 
7. int stackSize(int clientID) - 
Returns the size of the stack 
8. boolean isEmpty(int clientID) - 
Returns True if the stack is empty
9. boolean checkforZero(int clientID) - 
Checks if integer 0 is present in the stack 
10. boolean  invalidOperator(int clientID) - 
Checks if the operator passed is a valid one i.e. if it comes under either of {min, max, lcm, gcd}

<b>Compilation<b>

1.⁠ ⁠*Compile the Java Files*:

----
    Javac *.java
---

2.⁠ ⁠*Start the RMI Registry*:
  
---
    rmiregistry &
---


3.⁠ ⁠*Run the Server*:
    

---  
     java CalculatorServer

4.⁠ ⁠*Run the Client*:
--- 
    java CalculatorClient
---
<b>Testing<b>

For Testing, several test cases of including edge cases have been added in the CalculatorClient file. The tests will be run automatically with the file. 

A preview of the test cases is shown below 

```
Test Case 1 - 
 Minimum of 10, 20, 30 -> 
10


 Test Case 2 - 
 Maximum of -9, 0, 50 -> 
50


 Test Case 3 - 
 Minimum of -10, -30, -50 -> 
-50


 Test Case 4 - 
 Minimum of 3, 2 -> 
2


 Test Case 5 - 
 Maximum of 10000, 67, -34, 0  -> 
10000


 Test Case 6 - 
 GCD of 6, 9 -> 
3


 Test Case 7 - 
 GCD of 8 -> 
 Error - Cannot calculate GCD since stack has only one value


 Test Case 8 - 
 GCD of empty stack -> 
 Cannot perform GCD since stack contains 0


 Test Case 9 - 
 LCM of 10 -> 
 Error - Cannot calculate LCM since stack has only one value


 Test Case 10 - 
 LCM of 20, 40  -> 
40


 Test Case 11 - 
 LCM of empty stack -> 
 Cannot perform LCM since stack contains 0


 Test Case 12 - 
 LCM of 27, 0 -> 
 Cannot perform LCM since stack contains 0


 Test Case 13 - 
 Test Invalid Operation -> 
 Invalid Operator! Cannot perform the calculation 


 Test Case 14 - 
 Pop Method on empty stack -> 
 Error - Cannot pop values since stack is empty


 Test Case 15 - 
 Pop Method on 1, 4, 7 -> 
7


 isEmpty method on empty stack - 
true


 Test Case 17 - 
 IsEmpty Method on 80, 3, 7 -> 
false


 Test Case 18 - 
 Multiple Clients - Test delayPop on {10,20} for client 1 and pop {3,5} for client Id 2 -> 
20
7


 Test Case 19 - 
 Multiple Clients - Test max on {40,20} for Client ID 1 and {3,5} for Client ID 2 -> 
5
```

<b>References<b>

https://www.tutorialspoint.com/java_rmi/java_rmi_application.htm

https://github.com/clariechek/JavaRMI/tree/main/src