package com.zgl.controller;

import com.zgl.pojo.User;
import com.zgl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户注册
     * @param user
     * @return
     */
    @RequestMapping("/insertUser")
    public String insertUser(User user) {
        System.out.println(user.getPassword());
        System.out.println(user.getEmail());
        return null;
    }

    /**
     * 用户登录
     * @param user
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/loginUser")
    public String loginUser(User user, HttpSession session) {
        //System.out.println(user.getPassword());
        //System.out.println(user.getEmail());

        List<User> users = userService.login(user);

        if (users.size() != 0) {
            session.setAttribute("user", users.get(0));
            return "success";
        }
        return "fail";
    }

    /**
     * 用户退出
     * @param session
     * @return
     */
    @RequestMapping("/loginOut")
    public String user_loginOut(HttpSession session) {
        session.setAttribute("user", null);
        System.out.println(session.getAttributeNames());

        return "before/index";
    }


    /**
     * 用户个人中心
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/showMyProfile")
    public String showMyProfile(HttpSession session, Model model) {
        //System.out.println(session.getAttribute("user"));
        User user = (User) session.getAttribute("user");
        System.out.println(user.getId());
        List<User> users = userService.findUserByEmail(user.getEmail());
        //System.out.println(users.get(0));

        model.addAttribute("user", users.get(0));

        return "/before/my_profile";
    }

    /**
     * 用户从个人中心退出到主页面
     * @param session
     * @return
     */
    @RequestMapping("/loginOut2")
    public String user_loginOut2(HttpSession session) {

        return "before/index";
    }

    /**
     * 跳转到更改资料页面
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/changeProfile")
    public String changeProfile(HttpSession session, Model model) {

        User user = (User) session.getAttribute("user");
        List<User> users = userService.findUserByEmail(user.getEmail());
        //System.out.println(users.get(0));

        model.addAttribute("user", users.get(0));

        return "/before/change_profile";
    }

    /**
     * 更改个人资料
     * @param user
     * @return
     */
    @RequestMapping("/updateUser")
    public String updateUser(User user) {

        //System.out.println(user);
        int res = userService.updateUser(user);
        System.out.println(res);

        return "redirect:/user/showMyProfile";
    }

    /**
     * 跳转到更改密码页面
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/restPassword")
    public String passwordSafe(HttpSession session, Model model) {

        User user = (User) session.getAttribute("user");
        List<User> users = userService.findUserByEmail(user.getEmail());
        //System.out.println(users.get(0));

        model.addAttribute("user", users.get(0));

        return "/before/reset_password";
    }

    /**
     * 更改个人资料
     * @param user
     * @return
     */
    @RequestMapping("/resetPassword")
    public String resetPassword(User user) {

        System.out.println(user);
        List<User> user1 = userService.findUserByEmail(user.getEmail());
        user.setId(user1.get(0).getId());
        int res = userService.updateUser(user);
        System.out.println(user);
        System.out.println(res);

        return "redirect:/user/showMyProfile";
    }


    @RequestMapping("/changeAvatar")
    public String changeAvatar(HttpSession session, Model model) {

        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        return "/before/change_avatar";
    }

    @RequestMapping("/upLoadImage")
    public String upLoadImage(HttpSession session, MultipartFile photo) {

        User user = (User) session.getAttribute("user");
        //上传地址
        String path = "D:\\server\\apache-tomcat-8.5.31\\webapps\\upload\\";
        //上传的文件名
        String photoFileName = photo.getOriginalFilename();
        System.out.println("上传的文件名："+photoFileName);
        //预防上传文件的文件名重复
        //String uuid = UUID.randomUUID().toString().replace("-","");
        //String uploadFileName = uuid + photoFileName;
        //File file = new File(path+uploadFileName);

        //上传文件
        File file = new File(path+photoFileName);
        //上传方法
        try {
            photo.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //设置path属性
        user.setImgurl(photoFileName);
        userService.updateUser(user);
        return "/before/change_avatar";
    }

}
