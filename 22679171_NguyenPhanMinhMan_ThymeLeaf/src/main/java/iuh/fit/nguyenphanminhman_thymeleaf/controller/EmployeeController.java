package iuh.fit.nguyenphanminhman_thymeleaf.controller;

import iuh.fit.nguyenphanminhman_thymeleaf.model.Employee;
import iuh.fit.nguyenphanminhman_thymeleaf.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/search")
    public String searchEmployees(@RequestParam(required = false) String keyword, Model model) {
        List<Employee> employees = repo.findAll();

        if (keyword != null && !keyword.isEmpty()) {
            String kw = keyword.trim().toLowerCase();

            // Nếu keyword là số → kiểm tra xem là tuổi hay lương
            if (kw.matches("\\d+")) {
                int value = Integer.parseInt(kw);
                employees = employees.stream()
                        .filter(e -> e.getAge() == value || e.getSalary() == value)
                        .toList();
            }
            // Nếu keyword là số thực (ví dụ 1200.5)
            else if (kw.matches("\\d+(\\.\\d+)?")) {
                double salaryValue = Double.parseDouble(kw);
                employees = employees.stream()
                        .filter(e -> e.getSalary() == salaryValue)
                        .toList();
            }
            // Nếu keyword là chữ → tìm theo tên
            else {
                employees = employees.stream()
                        .filter(e -> e.getEmpName().toLowerCase().contains(kw))
                        .toList();
            }
        }

        model.addAttribute("employees", employees);
        return "product/home";
    }


}
