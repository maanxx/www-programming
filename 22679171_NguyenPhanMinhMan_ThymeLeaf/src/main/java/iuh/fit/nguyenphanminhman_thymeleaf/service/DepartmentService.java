package iuh.fit.nguyenphanminhman_thymeleaf.service;


import iuh.fit.nguyenphanminhman_thymeleaf.model.Department;
import iuh.fit.nguyenphanminhman_thymeleaf.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentRepository repo;

    public DepartmentService(DepartmentRepository repo) {
        this.repo = repo;
    }

    public List<Department> findAll() {
        return repo.findAll();
    }

    public Department findById(String id) {
        return repo.findById(id).orElse(null);
    }

    public void save(Department dept) {
        repo.save(dept);
    }

    public void delete(String id) {
        repo.deleteById(id);
    }
}
