package com.nhnacademy.shoppingmall.common.filter;

import lombok.extern.slf4j.Slf4j;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = {"/admin/*"})
public class AdminCheckFilter extends HttpFilter {

    private final String ROLE_ADMIN = "ROLE_ADMIN";

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        //todo#11 /admin/ 하위 요청은 관리자 권한의 사용자만 접근할 수 있습니다. ROLE_USER가 접근하면 403 Forbidden 에러처리

        if(req.getParameter("user_role").equals(ROLE_ADMIN)){
            chain.doFilter(req,res);
        }

        // 에러처리 해야함...
    }
}
