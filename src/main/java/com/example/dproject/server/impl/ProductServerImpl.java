package com.example.dproject.server.impl;


import com.example.dproject.dao.ProductDao;
import com.example.dproject.pojo.ProductInfo;
import com.example.dproject.server.ProductServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServerImpl implements ProductServer {
    @Autowired
   private ProductDao productDao;
    /*
     * 查询所有*/
    @Override
    public List<ProductInfo> findAll() {
        return productDao.findAll();
    }

    /*
     * 根据id查询一条*/
    @Override
    public Optional<ProductInfo> findById(Integer id) {
        return productDao.findById(id);
    }

}
