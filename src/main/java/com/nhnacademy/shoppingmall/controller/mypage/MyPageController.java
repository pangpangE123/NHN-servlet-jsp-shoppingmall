package com.nhnacademy.shoppingmall.controller.mypage;

import com.nhnacademy.shoppingmall.common.mvc.annotation.RequestMapping;
import com.nhnacademy.shoppingmall.common.mvc.controller.BaseController;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RequestMapping(method = RequestMapping.Method.GET,value = {"/mypage.do"})
public class MyPageController implements BaseController {


    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {

        // 배송지 DB에서 사용자 ID로 배송지 목록 받아옴

        // 세션에 해당 정보 추가

        return "shop/mypage/mypage";
    }
}
