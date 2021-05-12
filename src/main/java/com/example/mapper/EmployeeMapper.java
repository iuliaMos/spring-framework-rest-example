package com.example.mapper;

import com.example.dto.DepartmentDTO;
import com.example.dto.DepartmentModel;
import com.example.dto.EmployeeDTO;
import com.example.entity.Department;
import com.example.entity.Employee;

public class EmployeeMapper {

    private EmployeeMapper() {
    }

    public static Employee toEntity(final EmployeeDTO emplyeeDTO, final Department department) {
        Employee employee = new Employee();

        employee.setName(emplyeeDTO.getName());
        employee.setDepartment(department);
        employee.setAge(emplyeeDTO.getAge());

        return employee;
    }

    public static EmployeeDTO toDTO(final Employee employee) {
        return new EmployeeDTO(employee.getId(), employee.getName(), employee.getDepartment().getName(),
                employee.getAge());
    }

    public static Department toEntity(final DepartmentModel departmentModel) {
        Department department = new Department();

        department.setName(departmentModel.getName());
        department.setCountry(departmentModel.getCountry());

        return department;
    }

    public static DepartmentDTO toDTO(final Department department) {
        return new DepartmentDTO(department.getId(), department.getName(), department.getCountry());
    }
}
