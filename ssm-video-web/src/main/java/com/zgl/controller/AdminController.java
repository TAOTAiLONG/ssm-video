package com.zgl.controller;

import com.zgl.pojo.Admin;
import com.zgl.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 跳转到后台登陆页面
     * @return
     */
    @RequestMapping("/loginView")
    public String loginView() {

        return "behind/login";
    }

    /**
     * 管理员登录
     * @param admin
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/login")
    public String admin_login(Admin admin, HttpSession session) {
        System.out.println(admin.getUsername() + ":" + admin.getPassword());

        if (adminService.login(admin) != null) {
            session.setAttribute("admin", admin);
            return "success";
        }
        return "fail";
    }

    /**
     * 管理员退出
     * @param session
     * @return
     */
    @RequestMapping("/exit")
    public String admin_exit(HttpSession session) {
        session.removeAttribute("admin");
        //session.setAttribute("admin", null);
        System.out.println(session.getAttributeNames());
        return "behind/login";
    }
}
