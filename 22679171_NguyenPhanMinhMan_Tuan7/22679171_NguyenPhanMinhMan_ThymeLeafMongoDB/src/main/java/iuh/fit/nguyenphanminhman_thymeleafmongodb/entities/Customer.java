package iuh.fit.nguyenphanminhman_thymeleafmongodb.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "customers")

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "customer_since")
    private Date customerSince;

}
