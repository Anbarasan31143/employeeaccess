package com.anbar.employeeaccess.controller;

import com.anbar.employeeaccess.model.Employee;
import com.anbar.employeeaccess.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public Employee add(@RequestBody Employee emp) {
        return employeeRepository.save(emp);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        employeeRepository.deleteById(id);
        return ResponseEntity.ok("Deleted successfully");
    }
}
