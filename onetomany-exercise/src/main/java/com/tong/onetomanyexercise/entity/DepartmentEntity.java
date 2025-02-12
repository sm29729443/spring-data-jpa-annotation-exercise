package com.tong.onetomanyexercise.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "department")
@Getter
@Setter
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dept_name", nullable = false)
    private String deptName;

    // 使用 mappedBy 表示 Employee 的 department 欄位是擁有關聯的一方
    @OneToMany(
            mappedBy = "department",            // 指定 Employee 中的 department 屬性作為關聯所有者
            cascade = CascadeType.ALL,           // 操作傳遞（例如 persist, remove 都會傳遞到員工）
            orphanRemoval = true,               // 移除部門時，若員工不再與任何部門關聯則自動刪除
            fetch = FetchType.LAZY               // 預設為延遲抓取，只有需要時才查詢員工
    )
    private List<EmployeeEntity> employees = new ArrayList<>();



    // 方便操作的輔助方法：添加員工
    public void addEmployee(EmployeeEntity employee) {
        employees.add(employee);
        employee.setDepartment(this);  // 保證雙向關聯同步
    }

    // 移除員工
    public void removeEmployee(EmployeeEntity employee) {
        employees.remove(employee);
        employee.setDepartment(null);
    }
}
