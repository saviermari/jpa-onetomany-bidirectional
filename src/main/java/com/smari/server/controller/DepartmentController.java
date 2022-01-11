package com.smari.server.controller;

import com.smari.server.dto.DepartmentModel;
import com.smari.server.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author smari
 */
@RestController
@RequestMapping(value = "/rest/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
public class DepartmentController {
    @Autowired
    private DepartmentService service;

    @PostMapping("/departments")
    public DepartmentModel createDepartment(@RequestBody DepartmentModel model) {
        return service.createDepartment(model);
    }

    @PutMapping("/departments/{id}")
    public DepartmentModel updateDepartment(@RequestBody DepartmentModel model, @PathVariable Long id) {
        DepartmentModel dept = service.getDepartment(id);
        if(dept == null){
            throw new RuntimeException("Not found");
        }
        if(model != null) if (null == model.getId()) {
            model.setId(dept.getId());
        }
        return service.updateDepartment(model);
    }

    @DeleteMapping("/departments/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        service.deleteDepartment(id);
    }

    @GetMapping("/departments/{id}")
    public DepartmentModel getDepartment(@PathVariable Long id) {
        return service.getDepartment(id);
    }

    @GetMapping("/departments")
    public List<DepartmentModel> getDepartment() {
        return service.getAllDepartments();
    }
}