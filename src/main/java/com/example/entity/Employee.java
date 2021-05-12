package com.example.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false, referencedColumnName = "id")
    private Department department;

    private Integer age;
}
