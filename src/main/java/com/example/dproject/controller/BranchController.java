package com.example.dproject.controller;

import com.example.dproject.entity.Result;
import com.example.dproject.entity.StatusCode;
import com.example.dproject.pojo.Branch;
import com.example.dproject.server.BranchServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/branch")

public class BranchController {
    @Autowired
    private BranchServer branchServer;
    /*
     * 根据id查询一条*/
    @RequestMapping("/findById")
    public Result findById(Integer id){
        Optional<Branch> serverById = branchServer.findById(id);
        if (serverById.isPresent()){
            return  new Result(StatusCode.SUCCESS,"查询成功",serverById);
        }
        return  new Result(StatusCode.FAIL,"查询失败");
    }
    /*
     * 查询所有*/
    @RequestMapping("/findAll")
    public Result findAll(){
        List<Branch> branchList = branchServer.findAll();
        return  new Result(StatusCode.SUCCESS,"查询成功",branchList);
    }
    /*@GetMapping("/findAll")
    public List<Branch> findAll(){
        return branchServer.findAll();
    }*/
    @GetMapping("/test")
    public String testBranch(){
        return "success";
    }
}
