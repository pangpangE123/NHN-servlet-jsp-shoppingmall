package com.nhnacademy.shoppingmall.controller.address;

import com.nhnacademy.shoppingmall.address.domain.Address;
import com.nhnacademy.shoppingmall.address.service.AddressService;
import com.nhnacademy.shoppingmall.common.mvc.annotation.RequestMapping;
import com.nhnacademy.shoppingmall.common.mvc.controller.BaseController;
import com.nhnacademy.shoppingmall.user.domain.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@RequestMapping(method = RequestMapping.Method.POST, value = "/mypage/addaddress.do")
@Slf4j
public class AddAddressPostController implements BaseController {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {

        AddressService addressService = (AddressService) req.getServletContext().getAttribute("addressService");
        String new_address = req.getParameter("new_address");
        String user_id = ((User)(req.getSession().getAttribute("USER_TOKEN"))).getUserId();
        Address address = new Address(null,new_address,user_id);
        addressService.saveAddress(address);

        return "redirect:/mypage.do";
    }
}
