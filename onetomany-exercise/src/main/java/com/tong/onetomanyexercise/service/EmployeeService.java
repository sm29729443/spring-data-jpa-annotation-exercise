package com.tong.onetomanyexercise.service;

import com.tong.onetomanyexercise.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {
    List<EmployeeEntity> getEmployeesWithDepartment();

    void createEmployeesWithDepartments();
}
