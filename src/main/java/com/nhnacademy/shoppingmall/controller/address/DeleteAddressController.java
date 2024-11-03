package com.nhnacademy.shoppingmall.controller.address;

import com.nhnacademy.shoppingmall.address.service.AddressService;
import com.nhnacademy.shoppingmall.common.mvc.annotation.RequestMapping;
import com.nhnacademy.shoppingmall.common.mvc.controller.BaseController;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@RequestMapping(method = RequestMapping.Method.GET, value = "/mypage/deleteaddress.do")
@Slf4j
public class DeleteAddressController implements BaseController {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        AddressService addressService = (AddressService) req.getServletContext().getAttribute("addressService");
        String addressId = req.getParameter("id");
        addressService.deleteAddress(Long.valueOf(addressId));
        return "redirect:/mypage.do";
    }
}
