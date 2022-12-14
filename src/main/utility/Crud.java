package main.utility;

import main.entity.Employee;
import main.exception.EmployeeNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class Crud {
    private static final Map<Integer, Employee> employeeMap = new HashMap<>();

    public static void run() {
        int selection;
        int searchId;

        do {
            selection = select();

            switch (selection) {
                case 1 -> insertEmployeeRecord();
                case 2 -> displayEmployeeRecords();
                case 3 -> {
                    int employeeIdToSearch = searchEmployeeId();
                    try {
                        searchEmployeeRecord(employeeIdToSearch);
                    } catch (EmployeeNotFoundException e) {
                        System.out.println(e.getMessage());;
                    }
                }
                case 4 -> {
                    int employeeIdToDelete = searchEmployeeId();
                    try {
                        deleteEmployeeRecord(employeeIdToDelete);
                    } catch (EmployeeNotFoundException e) {
                        System.out.println(e.getMessage());;
                    }
                }
                case 5 -> {
                    int employeeIdToUpdate = searchEmployeeId();
                    try {
                        updateEmployeeRecord(employeeIdToUpdate);
                    } catch (EmployeeNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }

        } while (selection != 0);
    }

    private static int select() {
        System.out.println("0. END SESSION");
        System.out.println("1. INSERT RECORD");
        System.out.println("2. DISPLAY RECORDS");
        System.out.println("3. SEARCH A RECORD");
        System.out.println("4. DELETE A RECORD");
        System.out.println("5. UPDATE A RECORD");
        return InputReader.readNumber("Enter your selection here: ", 0, 5);
    }

    private static int searchEmployeeId() {
        return InputReader.readNumber("Enter employee id: ");
    }
    private static void insertEmployeeRecord() {
        int employeeId = InputReader.readNumber("Enter employee id: ");
        String firstName = InputReader.readString("Enter first name: ");
        String lastName = InputReader.readString("Enter last name: ");
        String department = InputReader.readString("Enter department: ");

        employeeMap.put(employeeId,
                new Employee(employeeId, firstName, lastName, department ));
    }
    private static void displayEmployeeRecords() {
        System.out.println("----Employee Records----");
        for (var employee: employeeMap.values()) {
            System.out.println(employee);
        }
        System.out.println("------------------------");
    }
    private static void searchEmployeeRecord(int employeeId) throws EmployeeNotFoundException {
        if (employeeMap.containsKey(employeeId)) {
            System.out.println(employeeMap.get(employeeId));
        } else {
            throw new EmployeeNotFoundException();
        }
    }
    private static void deleteEmployeeRecord(int employeeId) throws EmployeeNotFoundException {
        if (employeeMap.containsKey(employeeId)) {
            employeeMap.remove(employeeId);
            System.out.println("Employee record successfully deleted.");
        } else {
            throw new EmployeeNotFoundException();
        }
    }
    private static void updateEmployeeRecord(int employeeId) throws EmployeeNotFoundException {
        if (employeeMap.containsKey(employeeId)) {
            String updatedFirstName = InputReader.readString("Enter new first name: ");
            String updatedLastName = InputReader.readString("Enter new last name: ");
            String updatedDepartment = InputReader.readString("Enter new deparment: ");

            employeeMap.replace(employeeId,
                    new Employee(employeeId, updatedFirstName, updatedLastName, updatedDepartment));
            System.out.println("Employee record successfully updated.");
        } else {
            throw new EmployeeNotFoundException();
        }
    }
}
