package main.java.app;

import java.util.Scanner;

import main.java.domain.Employee;
import main.java.services.EmployeeService;
import main.java.services.EmployeeServiceImpl;

public class Main {
  public static void main(String[] args) {
    Employee employee01 = new Employee("John Doe", "john.doe@example.com");
    Employee employee02 = new Employee("Jane Smith", "jane.smith@example.com");

    System.out.println("### Initializing salaries for both employees ###");
    System.out.println("");

    // Display initial employee information
    // employee01.displayEmployeeInfo();
    // employee02.displayEmployeeInfo();

    System.out.println("");
    System.out.println("### Updating salaries for both employees ###");
    System.out.println("");

    // Update salaries for both employees
    employee01.updateEmployeeSalary(5000.00);
    employee02.updateEmployeeSalary(10000.00);

    // Display updated employee information
    // employee01.displayEmployeeInfo();
    // employee02.displayEmployeeInfo();

    Employee[] employees = { employee01, employee02 };
    EmployeeService service = new EmployeeServiceImpl(employees);

    try {
      searchEmployeeById(service);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void searchEmployeeById(EmployeeService service) {
    try (Scanner keyboard = new Scanner(System.in)) {
      System.out.print("Digite o ID do funcionário a ser pesquisado: ");
      int employeeIdToSearch = keyboard.nextInt();

      Employee found = service.findEmployeeById(employeeIdToSearch);
      found.displayEmployeeInfo();
    }
  }
}