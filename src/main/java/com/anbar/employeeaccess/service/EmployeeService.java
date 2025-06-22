package com.anbar.employeeaccess.service;

import com.anbar.employeeaccess.model.Employee;
import com.anbar.employeeaccess.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee save(Employee emp) {
        return employeeRepository.save(emp);
    }

    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }
}