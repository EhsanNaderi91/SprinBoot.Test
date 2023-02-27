package com.tetra.bank.web.rest;

import com.tetra.bank.domain.Employee;
import com.tetra.bank.repository.EmployeeRepository;
import com.tetra.bank.web.rest.errors.EmployeeNotFounException;
import org.slf4j.*;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class EmployeeResource {
    private static final Logger log = LoggerFactory.getLogger(EmployeeResource.class);
    private final EmployeeRepository repository;

    public EmployeeResource(EmployeeRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/employees")
    List<Employee> all(){
        log.trace("start get all employee");
        return repository.findAll();
    }
    @PostMapping("/employees")
    Employee newEmployees(@RequestBody Employee newEmployee){
        return repository.save(newEmployee);
    }
    @GetMapping("/employees/{id}")
    Employee one(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFounException(id));
    }
    @PutMapping("/employees/{id}")
    Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id){
        return repository.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setRole(newEmployee.getRole());
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return repository.save(newEmployee);
                });
    }
    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id){
        repository.deleteById(id);
    }
}
