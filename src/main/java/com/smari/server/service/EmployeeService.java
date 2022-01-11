package com.smari.server.service;

import com.smari.server.dto.EmployeeModel;

import java.util.List;

/**
 * @author smari
 */
public interface EmployeeService {
    public EmployeeModel createEmployee(Long deptId, EmployeeModel model);
    public EmployeeModel updateEmployee(EmployeeModel model);
    public void deleteEmployee(Long id);
    public EmployeeModel getEmployee(Long id);
    public List<EmployeeModel> getAllEmployees();
}
