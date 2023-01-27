package com.assetManagement.assetManagement.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Eid;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "DeptId")
    private long DeptId;

    @Column(name = "asset")
    private String asset;

    @Column(name = "itemId")
    private long itemId;

    @Column(name = "category")
    private String category;

    @Column(name = "DoA")
    private String DoA;


    public Employee() {
    }

    public Employee(long Eid, String firstName, String lastName, String email, long DeptId, long itemId,String asset
                    ,String DoA) {
        this.Eid = Eid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.itemId = itemId;
        this.asset = asset;
        this.DoA = DoA;
        this.DeptId = DeptId;
    }

    public long getEid() {
        return Eid;
    }

    public void setEid(long eid) {
        Eid = eid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getDeptId() {
        return DeptId;
    }

    public void setDeptId(long deptId) {
        DeptId = deptId;
    }

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDoA() {
        return DoA;
    }

    public void setDoA(String doA) {
        DoA = doA;
    }


}




