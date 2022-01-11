package com.smari.server.service;

import com.smari.server.dto.DepartmentModel;

import java.util.List;

/**
 * @author smari
 */
public interface DepartmentService {
    public DepartmentModel createDepartment(DepartmentModel model);
    public DepartmentModel updateDepartment(DepartmentModel model);
    public void deleteDepartment(Long id);
    public DepartmentModel getDepartment(Long id);
    public List<DepartmentModel> getAllDepartments();
}
