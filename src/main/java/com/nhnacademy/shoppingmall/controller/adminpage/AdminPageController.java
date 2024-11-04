package com.nhnacademy.shoppingmall.controller.adminpage;

import com.nhnacademy.shoppingmall.common.mvc.annotation.RequestMapping;
import com.nhnacademy.shoppingmall.common.mvc.controller.BaseController;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@RequestMapping(method = RequestMapping.Method.GET, value = "/adminpage.do")
@Slf4j
public class AdminPageController implements BaseController {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {

        return "/shop/adminpage/adminpage";
    }
}
