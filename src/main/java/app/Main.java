package main.java.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.java.domain.Employee;
import main.java.exceptions.EmployeeNotFoundException;
import main.java.services.EmployeeService;
import main.java.services.EmployeeServiceImpl;

public class Main {
  public static void main(String[] args) {
    List<Employee> employeeList = new ArrayList<>(List.of(
      new Employee("John Doe", "john.doe@example.com", 3000.00),
      new Employee("Jane Smith", "jane.smith@example.com", 10000.00),
      new Employee("Alice Johnson", "alice.johnson@example.com", 7000.00),
      new Employee("Bob Brown", "bob.brown@example.com", 1000.00),
      new Employee("Charlie Wilson", "charlie.wilson@example.com", 2000.00),
      new Employee("Diana Lee", "diana.lee@example.com", 8000.00),
      new Employee("Eve Davis", "eve.davis@example.com", 4000.00),
      new Employee("Frank Miller", "frank.miller@example.com", 5050.00)
    ));

    System.out.println("### Initializing salaries for both employees ###");
    System.out.println("");

    // Exibe os dados iniciais dos funcionários
    // employee01.displayEmployeeInfo();
    // employee02.displayEmployeeInfo();

    System.out.println("");
    System.out.println("### Updating salaries for both employees ###");
    System.out.println("");

    // Atualiza o salário dos funcionários
    employeeList.get(0).updateEmployeeSalary(5000.00);

    // Exibe os dados atualizados dos funcionários
    // employee01.displayEmployeeInfo();
    // employee02.displayEmployeeInfo();

    // Cria uma instância de EmployeeServiceImpl com a lista de funcionários
    EmployeeService employeeService = new EmployeeServiceImpl(employeeList);
    
    System.out.println("");
    System.out.println("### Filtering Employee by Id ###");
    System.out.println("");
    // Busca um funcionário pelo ID
    try {
      searchEmployeeById(employeeService);
    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println("");
    System.out.println("### Filtering Employees by Salary ###");
    System.out.println("");

    // Filtra os funcionários com salário maior que 5000.00
    List<Employee> higherPaidEmployees = employeeService.filterEmployees(employee -> employee.salary > 5000.00);

    List<String> employeeNames = higherPaidEmployees.stream()
      .map(employee -> employee.name)
      .toList();

    // Exibe os nomes dos funcionários com salário maior que 5000.00
    System.out.println("Funcionários com salário maior que 5000.00:");
    for (String employeeName : employeeNames) {
      System.out.println(employeeName);
    }
  }

  // Método para buscar um funcionário pelo ID
  public static void searchEmployeeById(EmployeeService employeeService) {
    try (Scanner keyboard = new Scanner(System.in)) {
      System.out.print("Digite o ID do funcionário a ser pesquisado: ");
      int employeeIdToSearch = keyboard.nextInt();

      // Busca o funcionário pelo ID e lança uma exceção se não for encontrado
      Employee found = employeeService.findEmployeeById(employeeIdToSearch).orElseThrow(() -> new EmployeeNotFoundException());
      found.displayEmployeeInfo();
    }
  }
}