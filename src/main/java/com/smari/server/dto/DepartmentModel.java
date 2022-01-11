package com.smari.server.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

/**
 * @author smari
 */
public class DepartmentModel implements Serializable {
    private static final long serialVersionUID = 1L;
    private  Long id;
    private String deptName;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<EmployeeModel> emps;

    public DepartmentModel(){

    }
    public DepartmentModel(Long id, String deptName) {
        this.id = id;
        this.deptName = deptName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<EmployeeModel> getEmps() {
        return emps;
    }

    public void setEmps(List<EmployeeModel> emps) {
        this.emps = emps;
    }
}
