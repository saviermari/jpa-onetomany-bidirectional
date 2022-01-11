package com.smari.server.service;

import com.smari.server.dao.DepartmentRepository;
import com.smari.server.dao.EmployeeRepository;
import com.smari.server.dto.DepartmentModel;
import com.smari.server.dto.EmployeeModel;
import com.smari.server.entity.Department;
import com.smari.server.entity.Employee;
import com.smari.server.mapper.DepartmentMapper;
import com.smari.server.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author smari
 */
@Service
public class EmployeeServiceImp implements EmployeeService{
    @Autowired
    private EmployeeRepository repository;
    @Autowired
    private DepartmentRepository deptRepository;
    @Override
    @Transactional
    public EmployeeModel createEmployee(Long deptId, EmployeeModel model) {
        Employee emp = EmployeeMapper.convertModelToEntity(model);
        Department dept = deptRepository.getById(deptId);
        EmployeeModel empModel = save(emp, dept);
        return empModel;
    }

    private EmployeeModel save(Employee emp, Department dept) {
        emp.setDepartment(dept);
        Employee empEntity = repository.save(emp);
        EmployeeModel empModel = EmployeeMapper.convertEntityToModel(empEntity);
        DepartmentModel deptModel = DepartmentMapper.convertEntityToModel(emp.getDepartment());
        empModel.setDept(deptModel);
        return empModel;
    }

    @Override
    @Transactional
    public EmployeeModel updateEmployee(EmployeeModel model) {
        Employee emp = repository.getById(model.getId());
        emp.setName(model.getName());
        Department dept = deptRepository.getById(model.getDept().getId());
        EmployeeModel empModel = save(emp, dept);
        return empModel;
    }

    @Override
    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }

    @Override
    public EmployeeModel getEmployee(Long id) {
        Optional<Employee> optional = repository.findById(id);
        if(optional.isPresent()){
            return EmployeeMapper.convertEntityToModel(optional.get());
        }
        return null;
    }

    @Override
    public List<EmployeeModel> getAllEmployees() {
        List<Employee> empList = repository.findAll();
        List<EmployeeModel> modelList = empList.stream().map(EmployeeMapper::convertEntityToModel).collect(Collectors.toList());
        return modelList;
    }
}
