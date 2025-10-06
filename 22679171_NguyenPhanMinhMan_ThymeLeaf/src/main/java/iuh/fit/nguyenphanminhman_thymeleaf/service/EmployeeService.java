package iuh.fit.nguyenphanminhman_thymeleaf.service;

import iuh.fit.nguyenphanminhman_thymeleaf.model.Employee;
import iuh.fit.nguyenphanminhman_thymeleaf.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // lay ds
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

}
