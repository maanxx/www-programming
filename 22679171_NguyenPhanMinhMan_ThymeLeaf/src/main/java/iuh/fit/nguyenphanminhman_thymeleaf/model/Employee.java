package iuh.fit.nguyenphanminhman_thymeleaf.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "employees")
public class Employee {
    @Id
    @Column(name = "empId")
    private String empId;

    @Column(name = "empName")
    private String empName;

    @Column(name = "email")
    private String email;

    @Column(name = "age")
    private int age;

    @ManyToOne
    @JoinColumn(name = "deptId")
    private Department department;

    @Column(name = "salary")
    private double salary;
}
