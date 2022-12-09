package com.example.demo.controller;

import com.example.demo.model.employee.Employee;
import com.example.demo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;

    @GetMapping("/list")
    private String showListEmployee(Model model,@PageableDefault(page = 0,size = 5) Pageable pageable){
        Page<Employee> employees = employeeService.findAll(pageable);
        model.addAttribute("employees",employees);
        return "employee/list";
    }
}
