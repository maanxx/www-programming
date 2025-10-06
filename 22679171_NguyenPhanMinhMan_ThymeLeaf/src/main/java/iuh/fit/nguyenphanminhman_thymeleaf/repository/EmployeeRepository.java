package iuh.fit.nguyenphanminhman_thymeleaf.repository;

import iuh.fit.nguyenphanminhman_thymeleaf.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
