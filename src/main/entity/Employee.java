package main.entity;

public class Employee {
    private int id;

    private String firstName;

    private String lastName;
    private String department;
    public Employee(int id, String firstName, String lastName, String department) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }
    @Override
    public String toString() {
        return firstName + " " + lastName + " - " + department ;
    }
}
