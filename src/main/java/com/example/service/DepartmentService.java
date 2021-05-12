package com.example.service;

import com.example.dto.DepartmentDTO;
import com.example.dto.DepartmentModel;
import com.example.dto.filter.DepartmentSearchCriteria;

import java.util.List;

public interface DepartmentService {

    List<DepartmentDTO> getDepartmentList(final DepartmentSearchCriteria filter, Integer page, Integer size);
    DepartmentDTO getDepartmentById(final Long id);
    void save(final DepartmentModel department);
}
