package com.tong.onetomanyexercise.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employee")
@Getter
@Setter
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    // 多對一，表示每個員工屬於一個部門
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")  // 外鍵欄位名稱
    private DepartmentEntity department;

}
