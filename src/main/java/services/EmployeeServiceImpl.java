package main.java.services;

import java.util.Arrays;

import main.java.domain.Employee;
import main.java.exceptions.EmployeeNotFoundException;

public class EmployeeServiceImpl implements EmployeeService {
  private Employee[] employees;

  public EmployeeServiceImpl(Employee[] employees) {
    this.employees = employees;
  }

  @Override
  public Employee findEmployeeById(int id) {
    return Arrays.stream(this.employees)
      .filter(employee -> employee.id == id)
      .findFirst()
      .orElseThrow(() -> new EmployeeNotFoundException());
  }
}
