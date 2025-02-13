package com.tong.onetomanyexercise.service.impl;

import com.tong.onetomanyexercise.dao.DepartmentRepository;
import com.tong.onetomanyexercise.dao.EmployeeRepository;
import com.tong.onetomanyexercise.entity.DepartmentEntity;
import com.tong.onetomanyexercise.entity.EmployeeEntity;
import com.tong.onetomanyexercise.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    /*
    *
    *
    *
    * */
    @Override
    public void createDepartmentWithEmployees() {
        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.setDeptName("部門 1");

        EmployeeEntity employeeEntity1 = new EmployeeEntity();
        employeeEntity1.setName("員工 1");

        EmployeeEntity employeeEntity2 = new EmployeeEntity();
        employeeEntity2.setName("員工 2");

        ArrayList<EmployeeEntity> employeeEntityArrayList = new ArrayList<>();
        employeeEntityArrayList.add(employeeEntity1);
        employeeEntityArrayList.add(employeeEntity2);

        departmentEntity.setEmployees(employeeEntityArrayList);
        departmentRepository.save(departmentEntity);
    }
}
