package com.tetra.bank.web.rest;

import com.tetra.bank.domain.Employee;
import com.tetra.bank.repository.EmployeeRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDataBase {

    public static final Logger log = LoggerFactory.getLogger(LoadDataBase.class);
    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository) {
        return args -> {
            log.info("preLoading" + repository.save(new Employee("Caribou", "Manager")));
            log.info("preLoading" + repository.save(new Employee("Academy", "Tester")));
        };
    }
}
