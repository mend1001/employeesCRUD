package net.javaguides.springbootbakend;

import net.javaguides.springbootbakend.model.Employee;
import net.javaguides.springbootbakend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBakendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBakendApplication.class, args);
	}


}
