package com.anbar.employeeaccess.repository;

import com.anbar.employeeaccess.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}