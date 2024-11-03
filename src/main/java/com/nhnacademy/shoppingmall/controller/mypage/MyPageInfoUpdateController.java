package com.nhnacademy.shoppingmall.controller.mypage;

import com.nhnacademy.shoppingmall.common.mvc.annotation.RequestMapping;
import com.nhnacademy.shoppingmall.common.mvc.controller.BaseController;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RequestMapping(method = RequestMapping.Method.GET,value = {"/mypage/infoupdate.do"})
public class MyPageInfoUpdateController implements BaseController {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {

//        UserService userService = (UserService) req.getServletContext().getAttribute("userService");
//
//        String newBirth = req.getParameter("newBirth");
//        User user = (User) req.getSession().getAttribute("USER_TOKEN");
//        user.setUserName(newBirth);
//
//        userService.updateUser(user);

        return "/shop/mypage/mypage_info_update_form";

    }
}
