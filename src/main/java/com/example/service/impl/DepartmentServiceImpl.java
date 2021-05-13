package com.example.service.impl;

import com.example.dao.DepartmentDao;
import com.example.dto.DepartmentDTO;
import com.example.dto.DepartmentModel;
import com.example.dto.filter.DepartmentSearchCriteria;
import com.example.mapper.EmployeeMapper;
import com.example.service.DepartmentService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    @NonNull
    private DepartmentDao departmentDao;

    public List<DepartmentDTO> getDepartmentList(final DepartmentSearchCriteria filter, Integer page, Integer size) {
        return departmentDao.findAll(filter, page, size).stream()
                .map(EmployeeMapper::toDTO)
                .collect(Collectors.toList());
    }

    public DepartmentDTO getDepartmentById(final Long id) {
        return departmentDao.findById(id).map(EmployeeMapper::toDTO).orElse(null);
    }

    public void save(final DepartmentModel department) {
        departmentDao.update(EmployeeMapper.toEntity(department));
    }
}
