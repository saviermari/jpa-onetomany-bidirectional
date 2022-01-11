package com.smari.server.dao;

import com.smari.server.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author smari
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}