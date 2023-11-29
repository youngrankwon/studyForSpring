package com.study.spring.abstractRouting;

import com.study.spring.abstractRouting.repository.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "employee")
    public ResponseEntity<List<Employee>> getEmployees() {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(employeeService.getEmployees());
    }
}