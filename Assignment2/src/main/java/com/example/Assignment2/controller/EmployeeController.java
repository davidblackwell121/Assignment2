package com.example.Assignment2.controller;

import com.example.Assignment2.model.Employee;
import com.example.Assignment2.service.EmployeeService;
import com.example.Assignment2.service.DepartmentService;
import com.example.Assignment2.service.SalaryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final DepartmentService departmentService;
    private final SalaryService salaryService;

    @Autowired
    public EmployeeController(EmployeeService employeeService, DepartmentService departmentService, SalaryService, salaryService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
        this.salaryService = salaryService;
    }
}
