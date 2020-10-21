package com.zgl.controller;

import com.zgl.pojo.Client;
import com.zgl.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    /**
     * 添加报名信息
     * @param client
     * @return
     */
    @ResponseBody
    @RequestMapping("/clientPy")
    public String clientPy(Client client) {
        System.out.println(client);


        Calendar cal = Calendar.getInstance();
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8:00"));       //非常关键的！！！
        java.text.SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        System.out.println(sdf.format(cal.getTime()));

        client.setTime(sdf.format(cal.getTime()));
        Integer integer = clientService.insertClient(client);
        //System.out.println(integer.intValue());
        if (integer != null) {

         return "success";
        }
        return "fail";
    }



}
