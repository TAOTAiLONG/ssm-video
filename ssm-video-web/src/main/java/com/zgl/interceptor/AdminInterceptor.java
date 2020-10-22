package com.zgl.interceptor;

import com.zgl.pojo.Admin;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("admin");
        if (null != admin) {
            response.sendRedirect(request.getContextPath() + "/video/list");
            return false;
        } else {
            return true;
        }

    }
}
