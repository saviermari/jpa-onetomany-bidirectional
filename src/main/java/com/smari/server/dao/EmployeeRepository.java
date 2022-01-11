package com.smari.server.dao;

import com.smari.server.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author smari
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}