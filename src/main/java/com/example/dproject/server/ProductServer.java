package com.example.dproject.server;

import com.example.dproject.pojo.ProductInfo;

import java.util.List;
import java.util.Optional;

public interface ProductServer {
    /*
    * 查询所有*/
    public List<ProductInfo> findAll();
    /*
    * 根据id查询一条*/
    public Optional<ProductInfo> findById(Integer id);
}
