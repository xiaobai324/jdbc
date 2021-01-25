package com.example.dproject.server;

import com.example.dproject.pojo.Branch;

import java.util.List;
import java.util.Optional;

public interface BranchServer {
    /*
    * 查询所有*/
    public List<Branch> findAll();
    /*
    * 根据id查询*/
    Optional<Branch> findById(Integer id);
}
