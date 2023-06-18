package net.javaguides.springbootbakend.EmployeeServiceImpl;

import net.javaguides.springbootbakend.exception.ResourceNotFoundException;
import net.javaguides.springbootbakend.model.Employee;
import net.javaguides.springbootbakend.repository.EmployeeRepository;
import net.javaguides.springbootbakend.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee updateEmployee(long id, Employee employeeDetails) {
        Employee updateEmployee = employeeRepository.findById(id);
        if (updateEmployee == null) {
            throw new ResourceNotFoundException("Employee not exist with id: " + id);
        }

        if (employeeDetails.getFirstName() != null) {
            updateEmployee.setFirstName(employeeDetails.getFirstName());
        }
        if (employeeDetails.getLastName() != null) {
            updateEmployee.setLastName(employeeDetails.getLastName());
        }
        if (employeeDetails.getEmailId() != null) {
            updateEmployee.setEmailId(employeeDetails.getEmailId());
        }
        if (employeeDetails.getSalary() != null) {
            updateEmployee.setSalary(employeeDetails.getSalary());
        }
        if (employeeDetails.getState() != null) {
            updateEmployee.setState(employeeDetails.getState());
        }

        return employeeRepository.save(updateEmployee);
    }

    @Override
    public String deleteEmployee(long id) {
        Employee employee = employeeRepository.findById(id);
        if (employee == null) {
            System.out.println("The employee dont exist");
             return "Employee not exist with id: " + id;
        }
        System.out.println("The employee was deleted");
        employeeRepository.delete(employee);
        return "Employee with ID " + id + " has been deleted";
    }

    @Override
    public BigDecimal sumSalaries() {
        return employeeRepository.sumSalaries();
    }

    @Override
    public Employee findEmployeeWithLowestSalary() {
        return employeeRepository.findEmployeeWithLowestSalary();
    }
}