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

    // lay theo id
    public Employee findById(String id) {return employeeRepository.findById(id).orElse(null);};

    // add / update
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    // delete
    public void deleteById(String id) {
        employeeRepository.deleteById(id);
    }

    // tim theo ten
    public List<Employee> findByEmpNameContainingIgnoreCase(String name) {
        return employeeRepository.findByEmpNameContainingIgnoreCase(name);
    }

    // tim theo age
    public List<Employee> findByAge(int age) {
        return employeeRepository.findByAge(age);
    }

    //tim theo khoang salry
    public List<Employee> findBySalary(double salary) {
        return employeeRepository.findBySalary(salary);
    }


}
