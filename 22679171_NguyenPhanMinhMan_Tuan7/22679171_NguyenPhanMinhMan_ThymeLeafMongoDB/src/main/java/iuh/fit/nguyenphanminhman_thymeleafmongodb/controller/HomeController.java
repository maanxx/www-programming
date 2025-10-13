package iuh.fit.nguyenphanminhman_thymeleafmongodb.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("/home")
public class HomeController {
    public HomeController() {
    }

    @GetMapping
    public String HomePage(Model model) {
        LocalDate date = LocalDate.now();
        String mess = "Welcome ThymeLeaf";
        model.addAttribute("message", mess);
        model.addAttribute("date", date.toString());
        return "home";
    }
}
