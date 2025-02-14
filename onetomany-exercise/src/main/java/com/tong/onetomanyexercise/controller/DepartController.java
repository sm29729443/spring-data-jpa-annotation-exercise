package com.tong.onetomanyexercise.controller;


import com.tong.onetomanyexercise.entity.EmployeeEntity;
import com.tong.onetomanyexercise.service.DepartmentService;
import com.tong.onetomanyexercise.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class DepartController {
    private final DepartmentService departmentService;

    public DepartController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/createDepartmentWithEmployees")
    public String createDepartmentWithEmployees(){
        departmentService.createDepartmentWithEmployees();
        return "success";
    }

    @GetMapping("/deleteDepartmentWithEmployees")
    public String deleteDepartmentWithEmployees(){
        departmentService.deleteDepartmentWithEmployees();
        return "success";
    }

    @GetMapping("/deleteDepartment")
    public String deleteDepartment(){
        departmentService.deleteDepartment();
        return "success";
    }



}
