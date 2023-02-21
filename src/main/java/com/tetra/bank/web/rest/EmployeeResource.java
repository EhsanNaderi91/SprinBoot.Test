package com.tetra.bank.web.rest;

import com.tetra.bank.domain.Employee;
import com.tetra.bank.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeResource {
    private final EmployeeRepository repository;

    public EmployeeResource(EmployeeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/employees")
    List<Employee> all(){
        return repository.findAll();
    }
    @PostMapping("/employees")
    Employee newEmployees(@RequestBody Employee newEmployee){
        return repository.save(newEmployee);
    }
}
