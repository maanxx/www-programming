package iuh.fit.nguyenphanminhman_thymeleafmongodb.services;

import iuh.fit.nguyenphanminhman_thymeleafmongodb.entities.Product;
import iuh.fit.nguyenphanminhman_thymeleafmongodb.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<Product> findAll() {
        return repo.findAllWithComments();
    }

    public Product findById(int id) {
        return repo.findById(id).orElse(null);
    }

    public void save(Product product) {
        repo.save(product);
    }

}
