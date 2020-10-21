package com.zgl.service.impl;

import com.zgl.dao.ClientMapper;
import com.zgl.pojo.Client;
import com.zgl.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientMapper clientMapper;


    @Override
    public Integer insertClient(Client client) {

        return clientMapper.insertSelective(client);
    }

}
