package com.sujit.entity;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private long dept_id; // adding it here because I'm pushing data during program startup

    /*
    Each employee will be assigned to only one department
     */
    @ManyToOne
    @JoinColumn(name = "dept_id", insertable = false, updatable = false)
    private Department department;

    public Employee() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public long getDept_id() {
        return dept_id;
    }

    public void setDept_id(long dept_id) {
        this.dept_id = dept_id;
    }
}
