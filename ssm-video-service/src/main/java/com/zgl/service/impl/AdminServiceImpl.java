package com.zgl.service.impl;

import com.zgl.dao.AdminMapper;
import com.zgl.pojo.Admin;
import com.zgl.pojo.AdminExample;
import com.zgl.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public int login(Admin admin) {

        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(admin.getUsername());
        criteria.andPasswordEqualTo(admin.getPassword());
        return adminMapper.selectByExample(example).size();
    }
}
