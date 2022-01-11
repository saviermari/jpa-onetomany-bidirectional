package com.smari.server.controller;

import com.smari.server.dto.DepartmentModel;
import com.smari.server.dto.EmployeeModel;
import com.smari.server.mapper.DepartmentMapper;
import com.smari.server.service.DepartmentService;
import com.smari.server.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author smari
 */
@RestController
@RequestMapping(value = "/rest/v1/departments/{deptId}", produces = { MediaType.APPLICATION_JSON_VALUE })
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @Autowired
    private DepartmentService deptService;

    @PostMapping("/employees")
    public EmployeeModel createEmployee(@RequestBody  EmployeeModel model,@PathVariable Long deptId){
        DepartmentModel dept = deptService.getDepartment(deptId);
        if(dept==null){
            throw new RuntimeException("Department not found");
        }
        return service.createEmployee(deptId,model);
    }
    @PutMapping("/employees/{id}")
    public EmployeeModel updateEmployee(@RequestBody EmployeeModel model,  @PathVariable Long deptId, @PathVariable Long id){
        DepartmentModel dept = deptService.getDepartment(deptId);
        if(dept==null){
            throw new RuntimeException("Department not found");
        }
        EmployeeModel emp = service.getEmployee(id);
        if(emp==null){
            throw new RuntimeException("Employee not found");
        }
        model.setId(emp.getId());
        model.setDept(dept);
        return service.updateEmployee(model);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable Long id,@PathVariable Long deptId){
        DepartmentModel dept = deptService.getDepartment(deptId);
        if(dept==null){
            throw new RuntimeException("Department not found");
        }
        service.deleteEmployee(id);
    }

    @GetMapping("/employees/{id}")
    public EmployeeModel getEmployee(@PathVariable Long id,@PathVariable Long deptId){
        DepartmentModel dept = deptService.getDepartment(deptId);
        if(dept==null){
            throw new RuntimeException("Department not found");
        }
        return service.getEmployee(id);
    }

    @GetMapping("/employees")
    public List<EmployeeModel> getAllEmployees(@PathVariable Long deptId){
        DepartmentModel dept = deptService.getDepartment(deptId);
        if(dept==null){
            throw new RuntimeException("Department not found");
        }
        return service.getAllEmployees();
    }
}
