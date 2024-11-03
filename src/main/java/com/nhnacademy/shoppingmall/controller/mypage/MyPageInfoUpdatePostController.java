package com.nhnacademy.shoppingmall.controller.mypage;

import com.nhnacademy.shoppingmall.common.mvc.annotation.RequestMapping;
import com.nhnacademy.shoppingmall.common.mvc.controller.BaseController;
import com.nhnacademy.shoppingmall.user.domain.User;
import com.nhnacademy.shoppingmall.user.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(method = RequestMapping.Method.POST, value = {"/mypage/infoupdate.do"})
public class MyPageInfoUpdatePostController implements BaseController {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {

        UserService userService = (UserService) req.getServletContext().getAttribute("userService");

        String newName = req.getParameter("newName");
        String newPassword = req.getParameter("newPassword");
        String newBirth = req.getParameter("newBirth").split(" ")[0].replace("-","");
        log.debug("userBirth:{}",newBirth);
        User user = (User) req.getSession().getAttribute("USER_TOKEN");

        user.setUserName(newName);
        user.setUserPassword(newPassword);
        user.setUserBirth(newBirth);

        userService.updateUser(user);

        return "redirect:/mypage.do";
    }
}
