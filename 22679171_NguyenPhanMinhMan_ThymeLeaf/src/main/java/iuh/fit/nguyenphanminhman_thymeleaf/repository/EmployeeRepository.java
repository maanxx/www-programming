package iuh.fit.nguyenphanminhman_thymeleaf.repository;

import iuh.fit.nguyenphanminhman_thymeleaf.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    List<Employee> findByEmpNameContainingIgnoreCase(String name);

    List<Employee> findByAge(int age);

    List<Employee> findBySalary(double salary);

    void deleteByEmpId(String empId);

    List<Employee> findByDepartment_DeptId(String deptId);
}
