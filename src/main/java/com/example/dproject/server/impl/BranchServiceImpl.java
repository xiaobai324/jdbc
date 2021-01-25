package com.example.dproject.server.impl;

import com.example.dproject.dao.BranchDao;

import com.example.dproject.pojo.Branch;
import com.example.dproject.server.BranchServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BranchServiceImpl implements BranchServer {
    @Autowired
    private BranchDao branchDao;
    @Override
    public List<Branch> findAll() {
        return branchDao.findAll();
    }

    @Override
    public Optional<Branch> findById(Integer id) {
        return branchDao.findById(id);
    }
}
