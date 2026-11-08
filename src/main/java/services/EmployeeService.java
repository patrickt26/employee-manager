package main.java.services;

import main.java.domain.Employee;

public interface EmployeeService {
  Employee findEmployeeById(int id);
}
