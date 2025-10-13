package iuh.fit.nguyenphanminhman_thymeleafmongodb.repositories;

import iuh.fit.nguyenphanminhman_thymeleafmongodb.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT DISTINCT p FROM Product p LEFT JOIN FETCH p.comments")
    List<Product> findAllWithComments();


}
