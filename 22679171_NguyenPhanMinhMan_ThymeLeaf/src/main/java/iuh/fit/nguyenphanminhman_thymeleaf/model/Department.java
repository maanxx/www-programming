package iuh.fit.nguyenphanminhman_thymeleaf.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "departments")
public class Department {
    @Id
    @Column(name = "deptId")
    private String deptId;

    @Column(name = "deptName")
    private String deptName;
}
