package main.java.domain;

public class Employee {
  private static int idCounter = 1;

  public int id;
  public String name;
  public String email;
  public double salary;

  public Employee(String name, String email) {
    this.id = idCounter++;
    this.name = name;
    this.email = email;
  }

  public void updateEmployeeSalary(double newSalary) {
    this.salary = newSalary;
  }

  public void displayEmployeeInfo() {
    System.out.println("----- Employee Information -----");
    System.out.println("ID: " + this.id);
    System.out.println("Name: " + this.name);
    System.out.println("Email: " + this.email);
    System.out.println("Salary: " + this.salary);
    System.out.println("--------------------------------");
  }
}
