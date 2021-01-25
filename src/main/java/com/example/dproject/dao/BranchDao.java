package com.example.dproject.dao;

import com.example.dproject.pojo.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchDao extends JpaRepository<Branch,Integer> {
}
