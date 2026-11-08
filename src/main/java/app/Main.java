package main.java.app;

import main.java.domain.Employee;

public class Main {
  public static void main(String[] args) {
    Employee employee01 = new Employee("John Doe", "john.doe@example.com");
    Employee employee02 = new Employee("Jane Smith", "jane.smith@example.com");

    System.out.println("### Initializing salaries for both employees ###");
    System.out.println("");

    // Display initial employee information
    employee01.displayEmployeeInfo();
    employee02.displayEmployeeInfo();

    System.out.println("");
    System.out.println("### Updating salaries for both employees ###");
    System.out.println("");

    // Update salaries for both employees
    employee01.updateEmployeeSalary(5000.00);
    employee02.updateEmployeeSalary(10000.00);

    // Display updated employee information
    employee01.displayEmployeeInfo();
    employee02.displayEmployeeInfo();
  }
}