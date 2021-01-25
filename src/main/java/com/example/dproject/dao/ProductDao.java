package com.example.dproject.dao;


import com.example.dproject.pojo.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductDao extends JpaRepository<ProductInfo,Integer> {
}
