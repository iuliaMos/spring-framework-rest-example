package com.example.service.impl;

import com.example.dao.EmployeeDao;
import com.example.dto.EmployeeDTO;
import com.example.dto.filter.EmployeeSearchCriteria;
import com.example.mapper.EmployeeMapper;
import com.example.service.EmployeeService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    @NonNull
    private EmployeeDao employeeDao;

    public List<EmployeeDTO> getEmployees(EmployeeSearchCriteria filter) {
        return employeeDao.findAll(filter)
                .stream().map(EmployeeMapper::toDTO).collect(Collectors.toList());
    }
}
