package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentModel {

    @NotBlank
    private String name;
    @NotBlank
    private String country;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("DepartmentModel(");
        builder.append(", name=").append(this.getName())
                .append(", country=").append(this.getCountry())
                .append(")");
        return builder.toString();
    }
}
