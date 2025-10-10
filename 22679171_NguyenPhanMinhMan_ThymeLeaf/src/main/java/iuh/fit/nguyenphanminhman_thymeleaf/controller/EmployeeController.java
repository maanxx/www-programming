package iuh.fit.nguyenphanminhman_thymeleaf.controller;

import iuh.fit.nguyenphanminhman_thymeleaf.model.Employee;
import iuh.fit.nguyenphanminhman_thymeleaf.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class EmployeeController {

    private final EmployeeService repo;

    public EmployeeController(EmployeeService repo) {
        this.repo = repo;
    }

    // lay ds ra ngoai table
    @GetMapping
    public String findAll(Model model) {
        List<Employee> em = repo.findAll();
        model.addAttribute("employees", em);
        return "product/home";
    }

    // tim theo dang keyword: ten(tuong doi), luong, tuoi
    @GetMapping("/search")
    public String searchEmployees(@RequestParam(required = false) String keyword, Model model) {
        List<Employee> employees = repo.findAll();

        if (keyword != null && !keyword.isEmpty()) {
            String kw = keyword.trim().toLowerCase();

            if (kw.matches("\\d+")) {
                int value = Integer.parseInt(kw);
                employees = employees.stream()
                        .filter(e -> e.getAge() == value || e.getSalary() == value)
                        .toList();
            }
            else if (kw.matches("\\d+(\\.\\d+)?")) {
                double salaryValue = Double.parseDouble(kw);
                employees = employees.stream()
                        .filter(e -> e.getSalary() == salaryValue)
                        .toList();
            }
            else {
                employees = employees.stream()
                        .filter(e -> e.getEmpName().toLowerCase().contains(kw))
                        .toList();
            }
        }

        model.addAttribute("employees", employees);
        return "product/home";
    }
    // hien thi form
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("isEdit", false);
        return "product/form-employee";
    }
    // edit la true
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") String id, Model model) {
        Employee emp = repo.findById(id);
        model.addAttribute("employee", emp);
        model.addAttribute("isEdit", true);
        return "product/form-employee";
    }
    // xu ly them va edit
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        repo.save(employee);
        return "redirect:/product";
    }

    @GetMapping("/department/{deptId}")
    public String findByDeptId(@PathVariable("deptId") String deptId, Model model) {
        List<Employee> employees = repo.findByDeptId(deptId);
        model.addAttribute("employees", employees);
        model.addAttribute("selectedDept", deptId);
        return "product/home";
    }
}
