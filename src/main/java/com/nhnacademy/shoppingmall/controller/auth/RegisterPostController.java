package com.nhnacademy.shoppingmall.controller.auth;

import com.nhnacademy.shoppingmall.address.domain.Address;
import com.nhnacademy.shoppingmall.address.service.AddressService;
import com.nhnacademy.shoppingmall.common.mvc.annotation.RequestMapping;
import com.nhnacademy.shoppingmall.common.mvc.controller.BaseController;
import com.nhnacademy.shoppingmall.user.domain.User;
import com.nhnacademy.shoppingmall.user.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@RequestMapping(method = RequestMapping.Method.POST, value = "/signup.do")
@Slf4j
public class RegisterPostController implements BaseController {

    private final int CREATED_DEFAULT_POINT = 1_000_000;

    public String execute(HttpServletRequest req, HttpServletResponse resp) {

        String userId = req.getParameter("user_id");
        String userName = req.getParameter("user_name");
        String userPassword = req.getParameter("user_password");
        String userBirth = req.getParameter("user_birth").split(" ")[0].replace("-","");
        log.debug("userBirth:{}",userBirth);
        User.Auth userRole = User.Auth.ROLE_USER;
        int userPoint = CREATED_DEFAULT_POINT;
        LocalDateTime createdAt = LocalDateTime.now();
        LocalDateTime lastLoginTime = LocalDateTime.now();

        User user = new User(
                userId,userName,userPassword,userBirth,userRole,userPoint,createdAt,lastLoginTime
        );

        Address defaultAddress = new Address(null, req.getParameter("user_address"),userId);

        UserService userService = (UserService) req.getServletContext().getAttribute("userService");
        userService.saveUser(user);

        AddressService addressService = (AddressService) req.getServletContext().getAttribute("addressService");
        addressService.saveAddress(defaultAddress);

        log.debug("회원가입 완료");
        return "redirect:/index.do";

    }
}
