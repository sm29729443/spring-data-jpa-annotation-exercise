package com.tong.onetomanyexercise.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "employee")
@Getter
@Setter
@ToString
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    // 多對一，表示每個員工屬於一個部門
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id") // 告訴 JPA 維護聯繫的方式是透過 FK，而不是中間表
    private DepartmentEntity department;

}
