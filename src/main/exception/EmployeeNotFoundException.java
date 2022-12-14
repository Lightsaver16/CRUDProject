package main.exception;

public class EmployeeNotFoundException extends Exception{
    public EmployeeNotFoundException() {
        super("Employee not found.");
    }
}
