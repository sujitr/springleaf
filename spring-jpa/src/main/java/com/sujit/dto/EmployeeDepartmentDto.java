package com.sujit.dto;

public class EmployeeDepartmentDto {
    private String deptName;
    private String empName;

    public EmployeeDepartmentDto(String deptName, String empName) {
        this.deptName = deptName;
        this.empName = empName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    @Override
    public String toString() {
        return "EmployeeDepartmentDto{" +
                "deptName='" + deptName + '\'' +
                ", empName='" + empName + '\'' +
                '}';
    }
}
