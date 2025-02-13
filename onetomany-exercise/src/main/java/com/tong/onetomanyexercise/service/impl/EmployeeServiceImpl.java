package com.tong.onetomanyexercise.service.impl;

import com.tong.onetomanyexercise.dao.DepartmentRepository;
import com.tong.onetomanyexercise.dao.EmployeeRepository;
import com.tong.onetomanyexercise.entity.DepartmentEntity;
import com.tong.onetomanyexercise.entity.EmployeeEntity;
import com.tong.onetomanyexercise.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
        private final EmployeeRepository employeeRepository;
        private final DepartmentRepository departmentRepository;

        public EmployeeServiceImpl(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        }

        @Override
        public List<EmployeeEntity> getEmployeesWithDepartment() {
                return employeeRepository.findAll();
        }

        @Override
        public void createEmployeesWithDepartments() {
                // 創建員工
                EmployeeEntity employeeEntity1 = new EmployeeEntity();
                employeeEntity1.setName("員工 3");
                EmployeeEntity employeeEntity2 = new EmployeeEntity();
                employeeEntity2.setName("員工 4");
                // 創建部門
                DepartmentEntity departmentEntity = new DepartmentEntity();
                departmentEntity.setDeptName("部門 3");

                employeeEntity1.setDepartment(departmentEntity);
                employeeEntity2.setDepartment(departmentEntity);
                ArrayList<EmployeeEntity> employeeEntityArrayList = new ArrayList<>();
                employeeEntityArrayList.add(employeeEntity1);
                employeeEntityArrayList.add(employeeEntity2);

                departmentEntity.setEmployees(employeeEntityArrayList);
                departmentRepository.save(departmentEntity);
//                employeeRepository.saveAll(employeeEntityArrayList);
        }
}
