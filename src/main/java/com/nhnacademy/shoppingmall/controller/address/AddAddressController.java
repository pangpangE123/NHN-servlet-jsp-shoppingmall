package com.nhnacademy.shoppingmall.controller.address;

import com.nhnacademy.shoppingmall.common.mvc.annotation.RequestMapping;
import com.nhnacademy.shoppingmall.common.mvc.controller.BaseController;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@RequestMapping(method = RequestMapping.Method.GET, value = "/mypage/addaddress.do")
@Slf4j
public class AddAddressController implements BaseController {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {

        return "/shop/address/add_address_form";
    }
}
