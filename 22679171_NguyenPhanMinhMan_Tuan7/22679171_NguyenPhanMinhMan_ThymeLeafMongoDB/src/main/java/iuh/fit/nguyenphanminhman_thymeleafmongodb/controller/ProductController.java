package iuh.fit.nguyenphanminhman_thymeleafmongodb.controller;

import iuh.fit.nguyenphanminhman_thymeleafmongodb.entities.Product;
import iuh.fit.nguyenphanminhman_thymeleafmongodb.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }


    @GetMapping
    public String showAllProducts(Model model) {
        List<Product> products = service.findAll();
        model.addAttribute("products", products);
        return "product/list";
    }

    @GetMapping("/{id}")
    public String showProduct(@PathVariable("id") int id, Model model) {

        Product product = service.findById(id);
        model.addAttribute("product", product);
        return "product/productdetail";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("product", new Product());
        return "product/add";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute("product") Product product) {
        service.save(product);
        return "redirect:/product";
    }
}
