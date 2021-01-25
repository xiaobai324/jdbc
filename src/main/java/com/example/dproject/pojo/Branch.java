package com.example.dproject.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
* 部门实体类*/
//@Data //
@Entity
@Table(name="branch")
public class Branch {
    @Id
    private Integer id;             //部门id
    private String branchname;      //部门名称
    private String location;        //部门位置

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBranchname() {
        return branchname;
    }

    public void setBranchname(String branchname) {
        this.branchname = branchname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


}
