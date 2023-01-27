package com.assetManagement.assetManagement.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Did;

    @Column(name = "Dept_name")
    private String DeptName;

    public long getDid() {
        return Did;
    }

    public void setDid(long did) {
        Did = did;
    }

    public String getDeptName() {
        return DeptName;
    }

    public void setDeptName(String deptName) {
        DeptName = deptName;
    }
}
