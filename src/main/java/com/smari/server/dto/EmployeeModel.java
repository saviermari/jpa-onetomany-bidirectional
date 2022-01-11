package com.smari.server.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.smari.server.entity.Department;

import java.io.Serializable;

/**
 * @author smari
 */
public class EmployeeModel implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private DepartmentModel dept;

    public EmployeeModel(){

    }
    public EmployeeModel(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DepartmentModel getDept() {
        return dept;
    }

    public void setDept(DepartmentModel dept) {
        this.dept = dept;
    }
}
