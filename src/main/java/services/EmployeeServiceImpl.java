package main.java.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import main.java.domain.Employee;

public class EmployeeServiceImpl implements EmployeeService {
  private List<Employee> employees;

  // Construtor para inicializar a lista de funcionários
  public EmployeeServiceImpl(List<Employee> employeeList) {
    this.employees = employeeList;
  }

  // Método para buscar um funcionário pelo ID
  @Override
  public Optional<Employee> findEmployeeById(int id) {
    return this.employees.stream().filter(employee -> employee.id == id).findFirst();
  }

  // Método para filtrar funcionários de acordo com o critério informado
  @Override
  public List<Employee> filterEmployees(Predicate<Employee> criterion) {
    List<Employee> result = new ArrayList<>();

    // Percorre a lista de funcionários e aplica o critério
    this.employees.stream().filter(criterion).forEach(result::add);

    return result;
  }
}
