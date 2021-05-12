package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DepartmentDTO {

    private Long id;
    private String name;
    private String country;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("DepartmentDTO(");
        builder.append("id=").append(this.getId())
                .append(", name=").append(this.getName())
                .append(", country=").append(this.getCountry())
                .append(")");
        return builder.toString();
    }
}
