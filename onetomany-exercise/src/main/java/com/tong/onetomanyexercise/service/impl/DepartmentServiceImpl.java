package com.tong.onetomanyexercise.service.impl;

import com.tong.onetomanyexercise.dao.DepartmentRepository;
import com.tong.onetomanyexercise.dao.EmployeeRepository;
import com.tong.onetomanyexercise.entity.DepartmentEntity;
import com.tong.onetomanyexercise.entity.EmployeeEntity;
import com.tong.onetomanyexercise.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

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
        departmentEntity.setDeptName("部門 1234");
//        departmentEntity.setId(2L);

        EmployeeEntity employeeEntity1 = new EmployeeEntity();
        employeeEntity1.setName("員工 1");
        employeeEntity1.setDepartment(departmentEntity);

        EmployeeEntity employeeEntity2 = new EmployeeEntity();
        employeeEntity2.setName("員工 2");
        employeeEntity2.setDepartment(departmentEntity);

        ArrayList<EmployeeEntity> employeeEntityArrayList = new ArrayList<>();
        employeeEntityArrayList.add(employeeEntity1);
        employeeEntityArrayList.add(employeeEntity2);

        departmentEntity.setEmployees(employeeEntityArrayList);
        departmentRepository.save(departmentEntity);
    }

    @Override
    public void deleteDepartmentWithEmployees() {
        Optional<DepartmentEntity> byId = departmentRepository.findById(1L);
        if (byId.isPresent()) {
            departmentRepository.delete(byId.get());
        }
    }

    @Override
    public void deleteDepartment() {
        departmentRepository.deleteById(1L);
    }
}
