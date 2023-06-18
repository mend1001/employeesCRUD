package co.com.mend1001.springbootbakend.repository;

import co.com.mend1001.springbootbakend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findAll();

    Employee findById(long id);

    Employee save(Employee employee);

    void delete(Employee employee);
    @Query("SELECT SUM(e.salary) FROM Employee e")
    BigDecimal sumSalaries();

    @Query("SELECT e FROM Employee e WHERE e.salary = (SELECT MIN(e.salary) FROM Employee e)")
    Employee findEmployeeWithLowestSalary();
}
