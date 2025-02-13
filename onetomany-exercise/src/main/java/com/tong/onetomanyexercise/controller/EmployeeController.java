package com.tong.onetomanyexercise.controller;

import com.tong.onetomanyexercise.entity.EmployeeEntity;
import com.tong.onetomanyexercise.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/getEmployeesWithDepartment")
    public String getEmployeesWithDepartment(){
        List<EmployeeEntity> employeeEntityList =  employeeService.getEmployeesWithDepartment();
        employeeEntityList.forEach(employeeEntity -> log.info("employeeEntity:{}, depart:{}",employeeEntity, employeeEntity.getDepartment()));
        return "success";
    }

    @GetMapping("/createEmployeesWithDepartments")
    public String createEmployeesWithDepartments(){
        employeeService.createEmployeesWithDepartments();
        return "success";
    }

}

