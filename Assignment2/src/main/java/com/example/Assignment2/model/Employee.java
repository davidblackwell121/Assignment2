package com.example.Assignment2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import java.util.Set;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Employee {
    @Id // Marks the id as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto generates the ID for each employee
    private int id;

    @NotEmpty(message = "Name is required") // Ensures the field is populated
    private String name;

    @NotEmpty(message = "Designation is required") // // Ensures the field is populated
    private String designation;

    public double salary; // Will be auto calculated based on designation

    private boolean employmentType; // true = full-time and false = part-time

    @ElementCollection
    @CollectionTable(name = "employee_departments", joinColumns = @JoinColumn(name = "employee_id"))
    @Column(name = "department")
    private Set<String> departments;
}
