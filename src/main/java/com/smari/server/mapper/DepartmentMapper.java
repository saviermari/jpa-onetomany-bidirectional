package com.smari.server.mapper;

import com.smari.server.dto.DepartmentModel;
import com.smari.server.dto.EmployeeModel;
import com.smari.server.entity.Department;
import com.smari.server.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class DepartmentMapper {

    public static DepartmentModel convertEntityToModel(Department entity){
        DepartmentModel deptModel = new DepartmentModel();
        if(entity != null){
            if(entity.getId() != null) deptModel.setId(entity.getId());
            deptModel.setDeptName(entity.getDeptName());
            List<EmployeeModel> employees = new ArrayList<>();
            if(entity.getEmps() == null)
                return deptModel;
            List<Employee> empEntities = entity.getEmps();
            for(Employee emp: empEntities){
                employees.add(EmployeeMapper.convertEntityToModel(emp));
            }
            deptModel.setEmps(employees);
        }
        return deptModel;
    }

    public  static Department convertModelToEntity(DepartmentModel model){
        Department department = new Department();
        if(model != null){
            if(model.getId() != null) department.setId(model.getId());
            department.setDeptName(model.getDeptName());
            List<EmployeeModel> emps = null;
            if (model.getEmps() == null) {
                return department;
            }
            emps = model.getEmps();
            List<Employee> empEntities = new ArrayList<>();
            for(EmployeeModel empModel: emps){
                Employee e = EmployeeMapper.convertModelToEntity(empModel);
                e.setDepartment(department);
                empEntities.add(e);
            }
            department.setEmps(empEntities);
        }
        return department;
    }
}
