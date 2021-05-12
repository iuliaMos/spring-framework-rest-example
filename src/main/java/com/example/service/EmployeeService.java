package com.example.service;

import com.example.dto.EmployeeDTO;
import com.example.dto.filter.EmployeeSearchCriteria;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> getEmployees(EmployeeSearchCriteria filter);
}
