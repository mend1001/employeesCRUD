package co.com.mend1001.springbootbakend.services;

import co.com.mend1001.springbootbakend.model.Employee;

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