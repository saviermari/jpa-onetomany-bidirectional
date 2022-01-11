package com.smari.server.service;

import com.smari.server.dao.DepartmentRepository;
import com.smari.server.dto.DepartmentModel;
import com.smari.server.entity.Department;
import com.smari.server.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author smari
 */
@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentRepository repository;

    @Override
    public DepartmentModel createDepartment(DepartmentModel model) {
        Department dept = repository.save(DepartmentMapper.convertModelToEntity(model));
        return DepartmentMapper.convertEntityToModel(dept);
    }

    @Override
    public DepartmentModel updateDepartment(DepartmentModel model) {
        return DepartmentMapper.convertEntityToModel(repository.save(DepartmentMapper.convertModelToEntity(model)));
    }

    @Override
    public void deleteDepartment(Long id) {
        repository.deleteById(id);
    }

    @Override
    public DepartmentModel getDepartment(Long id) {
        Optional<Department> optional = repository.findById(id);
        if(optional.isPresent()){
            return DepartmentMapper.convertEntityToModel(optional.get());
        }
        return null;
    }

    @Override
    public List<DepartmentModel> getAllDepartments() {
        List<Department> deptList = repository.findAll();
        List<DepartmentModel> modelList = deptList.stream().map(DepartmentMapper::convertEntityToModel).collect(Collectors.toList());
        return modelList;
    }
}
