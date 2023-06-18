package net.javaguides.springbootbakend.services;

import net.javaguides.springbootbakend.model.Employee;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee createEmployee(Employee employee);

    Employee getEmployeeById(long id);

    Employee updateEmployee(long id, Employee employeeDetails);

    String deleteEmployee(long id);

    BigDecimal sumSalaries();

    Employee findEmployeeWithLowestSalary();
}