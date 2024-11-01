package com.nhnacademy.shoppingmall.controller.auth;

import com.nhnacademy.shoppingmall.common.mvc.annotation.RequestMapping;
import com.nhnacademy.shoppingmall.common.mvc.controller.BaseController;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@RequestMapping(method = RequestMapping.Method.GET, value = "/logout.do")
@Slf4j
public class LogoutController implements BaseController {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {

        req.getSession().invalidate();
        log.debug("로그아웃 완료 : {}",req.getSession().getAttribute("USER_TOKEN"));
        return "redirect:/index.do";

    }
    //todo#13-3 로그아웃 구현


}
