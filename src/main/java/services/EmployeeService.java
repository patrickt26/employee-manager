package main.java.services;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import main.java.domain.Employee;

public interface EmployeeService {
  List<Employee> filterEmployees(Predicate<Employee> criterion);

  Optional<Employee> findEmployeeById(int employeeIdToSearch);
}
