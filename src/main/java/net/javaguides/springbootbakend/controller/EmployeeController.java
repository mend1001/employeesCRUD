package net.javaguides.springbootbakend.controller;


import net.javaguides.springbootbakend.exception.ResourceNotFoundException;
import net.javaguides.springbootbakend.model.Employee;
import net.javaguides.springbootbakend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable  long id){
        Employee employee = employeeRepository.findById(id);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(employee);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employeeDetails) {
        Employee updateEmployee = employeeRepository.findById(id);
        if (updateEmployee == null) {
            return ResponseEntity.notFound().build();
        }

        // Actualizar solo los campos proporcionados en employeeDetails
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

        employeeRepository.save(updateEmployee);

        return ResponseEntity.ok(updateEmployee);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){
        Employee employee = employeeRepository.findById(id);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }

        employeeRepository.delete(employee);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/sum-salaries")
    public ResponseEntity<?> sumSalaries() {
        try {
            BigDecimal sum = employeeRepository.sumSalaries();
            return ResponseEntity.ok(sum);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/employee-with-lowest-salary")
    public ResponseEntity<?> findEmployeeWithLowestSalary() {
        try {
            Employee employee = employeeRepository.findEmployeeWithLowestSalary();

            if (employee == null) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok(employee);
            }
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}





