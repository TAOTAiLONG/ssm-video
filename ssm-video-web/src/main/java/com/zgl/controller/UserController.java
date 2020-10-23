package com.zgl.controller;

import com.zgl.pojo.User;
import com.zgl.service.UserService;
import com.zgl.utils.ImageCut;
import com.zgl.utils.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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
    @ResponseBody
    @RequestMapping("/insertUser")
    public String insertUser(User user, HttpSession session) {
        System.out.println(user.getPassword());
        System.out.println(user.getEmail());

        Integer user1 = userService.insertUser(user);
        if (user1 != null) {
            session.setAttribute("user", user);
            return "success";
        }
        throw new RuntimeException("用户注册失败");
    }

    /**
     * 验证邮箱是否已存在
     * @param email
     * @return
     */
    @ResponseBody
    @RequestMapping("/validateEmail")
    public String validateEmail(String email) {
        System.out.println(email);

        List<User> users = userService.findUserByEmail(email);
        if (users.size() > 0) {
            return "hasUser";
        }
        return "success";
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
        return "failed";
    }

    /**
     * 进入忘记密码页面
     * @return
     */
    @RequestMapping("/forgetPassword")
    public String forgetPassword() {

        return "before/forget_password";
    }

    /**
     * 忘记密码，邮箱验证修改密码操作
     * @param email
     * @return
     */
    @ResponseBody
    @RequestMapping("/sendEmail")
    public String sendEmail(String email, HttpSession session) {

        /*List<User> users = userService.findUserByEmail(email);
        if (users.size() != 0) {
            return "hasNoUser";
        }*/
        if ("success".equals(validateEmail(email))) {
            return "hasNoUser";
        }

        String code = MailUtils.getValidateCode(6);
        MailUtils.sendMail("email", "测试邮件随机生成的验证码是：" + code, "你好，这是一封测试邮件，无需回复。");
        System.out.println("发送成功");
        session.setAttribute("code", code);

        return "success";
    }

    /**
     * 比对验证验证码是否一致,一致则跳转到重置密码页面
     * @param email
     * @param code
     * @param session
     * @return
     */
    @RequestMapping("/validateEmailCode")
    public String validateEmailCode(String email, String code, HttpSession session) {
        System.out.println("验证码：" + code);

        if (session.getAttribute("code").equals(code)) {
            List<User> users = userService.findUserByEmail(email);
            session.setAttribute("user", users.get(0));
            return "/before/reset_password";
        }
        return "before/forget_password";
    }

    /**
     * 用户退出
     * @param session
     * @return
     */
    @RequestMapping("/loginOut")
    public String user_loginOut(HttpSession session) {

        session.removeAttribute("user");
        //session.setAttribute("user", null);
        //System.out.println(session.getAttributeNames());

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
        System.out.println(user.getEmail());
        //System.out.println(user.getId());
        List<User> users = userService.findUserByEmail(user.getEmail());
        //System.out.println(users.get(0));

        model.addAttribute("user", users.get(0));

        return "before/my_profile";
    }

    /**
     * 用户从个人中心退出到主页面
     * @param session
     * @return
     */
    @RequestMapping("/loginOut2")
    public String user_loginOut2(HttpSession session) {

        return "redirect:/index.jsp";
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

        return "before/change_profile";
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
        //System.out.println(res);

        return "redirect:/user/showMyProfile";
    }

    /**
     * 跳转到密码安全页面
     * @return
     */
    @RequestMapping("/passwordSafe")
    public String passwordSafe() {

        return "before/password_safe";
    }

    /**
     * 跳转到更改密码页面
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/restPassword")
    public String restPassword(HttpSession session, Model model) {

        User user = (User) session.getAttribute("user");
        List<User> users = userService.findUserByEmail(user.getEmail());
        //System.out.println(users.get(0));

        model.addAttribute("user", users.get(0));

        return "before/reset_password";
    }

    /**
     * 验证旧密码是否正确
     * @param password
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/validatePassword")
    public String validatePassword(String password, HttpSession session) {

        User user = (User) session.getAttribute("user");
        if (user.getPassword().equals(password)) {
            return "success";
        }
        return "failed";
    }

    @RequestMapping("/updatePassword")
    public String updatePassword(String newPassword, HttpSession session) {

        User user = (User) session.getAttribute("user");
        user.setPassword(newPassword);
        userService.updateUser(user);

        return "redirect:/user/showMyProfile";
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


    /**
     * 跳转到更改头像页面
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/changeAvatar")
    public String changeAvatar(HttpSession session, Model model) {

        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        return "before/change_avatar";
    }

    /**
     * 上传图片
     * @param session
     * @param
     * @return
     */
    @RequestMapping("/upLoadImage")
    public String upLoadImage(HttpSession session, @RequestParam("image_file") MultipartFile imageFile,
                              String x1, String x2, String y1, String y2) throws IOException {

        User user = (User) session.getAttribute("user");
        //上传地址
        String path = "D:\\server\\apache-tomcat-8.5.31\\webapps\\video\\";
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }

        String filename = imageFile.getOriginalFilename();
        System.out.println(filename);
        filename = filename.substring(filename.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + filename;
        imageFile.transferTo(new File(path, filename));

        int x1Int = (int) Double.parseDouble(x1);
        int x2Int = (int) Double.parseDouble(x2);
        int y1Int = (int) Double.parseDouble(y1);
        int y2Int = (int) Double.parseDouble(y2);
        new ImageCut().cutImage(path + "/" + filename, x1Int, y1Int, x2Int - x1Int, y2Int - y1Int);

        //设置ImgUrl属性
        user.setImgurl(filename);
        userService.updateUser(user);
        return "redirect:/user/showMyProfile";
    }


    /**
     * 上传图片
     * @param session
     * @param photo
     * @return
     */
    /*@RequestMapping("/upLoadImage")
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
    }*/

}
