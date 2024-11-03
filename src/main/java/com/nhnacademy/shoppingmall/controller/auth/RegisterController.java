package com.nhnacademy.shoppingmall.controller.auth;

import com.nhnacademy.shoppingmall.common.mvc.annotation.RequestMapping;
import com.nhnacademy.shoppingmall.common.mvc.controller.BaseController;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@RequestMapping(method = RequestMapping.Method.GET, value = "/signup.do")
@Slf4j
public class RegisterController implements BaseController {

    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        return "shop/register/register_form";
    }

}
