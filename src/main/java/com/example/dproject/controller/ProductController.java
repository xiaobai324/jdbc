package com.example.dproject.controller;


import com.example.dproject.entity.Result;
import com.example.dproject.entity.StatusCode;
import com.example.dproject.pojo.ProductInfo;
import com.example.dproject.server.ProductServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/productInfo")
public class ProductController {
    @Autowired
    private ProductServer productServer;
    /*
    * 查询所有*/
    @RequestMapping("/findAll")
    public Result findAll(){
        List<ProductInfo> productServerList = productServer.findAll();
        //return productServer.findAll();
        return  new Result(StatusCode.SUCCESS,"查询成功",productServerList);
    }
    /*
     * 根据id查询一条*/
    @RequestMapping("/findById")
    public Result findBuId(Integer id){
        Optional<ProductInfo> serverById = productServer.findById(id);
        if (serverById.isPresent()){
            return new Result(StatusCode.SUCCESS,"查询成功",serverById);
        }
        return new Result(StatusCode.FAIL,"查询失败");
    }
    @GetMapping("/test")
    public String testBranch(){
        return "success";
    }

}
