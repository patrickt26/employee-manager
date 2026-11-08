package main.java.exceptions;

public class EmployeeNotFoundException extends RuntimeException {
  public EmployeeNotFoundException() {
    super("Funcionário não encontrado!");
  }

  public EmployeeNotFoundException(String message) {
    super(message);
  }
}
