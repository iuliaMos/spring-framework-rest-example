package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeDTO {

    private Long id;
    private String name;
    private String department;
    private Integer age;

    public EmployeeDTO(Long id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("EmplyeeDTO(");
        builder.append("id=").append(this.getId())
                .append(", name=").append(this.getName())
                .append(", department=").append(this.getDepartment())
                .append(", age=").append(this.getAge())
                .append(")");
        return builder.toString();
    }
}
