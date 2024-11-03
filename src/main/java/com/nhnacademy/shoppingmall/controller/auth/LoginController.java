package com.nhnacademy.shoppingmall.controller.auth;

import com.nhnacademy.shoppingmall.common.mvc.annotation.RequestMapping;
import com.nhnacademy.shoppingmall.common.mvc.controller.BaseController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@RequestMapping(method = RequestMapping.Method.GET,value = "/login.do")
@Slf4j
public class LoginController implements BaseController {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        //todo#13-1 session이 존재하고 로그인이 되어 있다면 redirect:/index.do 반환 합니다.

        if(Objects.nonNull(req.getSession()) && Objects.nonNull(req.getSession().getAttribute("USER_TOKEN"))){
            log.debug("이미 로그인 되어있습니다 UserToken : {}",req.getSession().getAttribute("USER_TOKEN"));
            return "redirect:/index.do";
        }

        return "shop/login/login_form";
    }
}
