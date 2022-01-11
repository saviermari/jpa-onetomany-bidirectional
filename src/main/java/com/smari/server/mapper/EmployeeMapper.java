package com.smari.server.mapper;

import com.smari.server.dto.DepartmentModel;
import com.smari.server.dto.EmployeeModel;
import com.smari.server.entity.Department;
import com.smari.server.entity.Employee;
public class EmployeeMapper {

    public static EmployeeModel convertEntityToModel(Employee entity){
        EmployeeModel empModel = new EmployeeModel();
        if(entity != null){
            if(entity.getId() != null) empModel.setId(entity.getId());
            empModel.setName(entity.getName());
        }
        return empModel;
    }

    public  static Employee convertModelToEntity(EmployeeModel model){
        Employee employee = new Employee();
        if(model != null){
            if(model.getId() != null) employee.setId(model.getId());
            employee.setName(model.getName());
        }
        return employee;
    }
}
