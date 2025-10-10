package iuh.fit.nguyenphanminhman_thymeleaf.controller;

import iuh.fit.nguyenphanminhman_thymeleaf.model.Department;
import iuh.fit.nguyenphanminhman_thymeleaf.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {
        List<Department> depts = service.findAll();
        model.addAttribute("departments", depts);
        return "department/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("department", new Department());
        model.addAttribute("isEdit", false);
        return "department/form-add";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("department") Department dept) {
        service.save(dept);
        return "redirect:/departments";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, Model model) {
        Department dept = service.findById(id);
        model.addAttribute("department", dept);
        model.addAttribute("isEdit", true);
        return "department/form-add";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        service.delete(id);
        return "redirect:/departments";
    }
}
