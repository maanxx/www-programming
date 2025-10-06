package iuh.fit.nguyenphanminhman_thymeleaf.controller;

import iuh.fit.nguyenphanminhman_thymeleaf.model.Employee;
import iuh.fit.nguyenphanminhman_thymeleaf.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class EmployeeController {

    private final EmployeeService repo;

    public EmployeeController(EmployeeService repo) {
        this.repo = repo;
    }

    @GetMapping
    public String findAll(Model model) {
        List<Employee> em = repo.findAll();
        model.addAttribute("employees", em);
        return "product/home";
    }
}
