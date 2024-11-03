<%--
  Created by IntelliJ IDEA.
  User: pangpange
  Date: 2024. 11. 2.
  Time: AM 1:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" session="false" %>

<div style="margin: auto; width: 400px;">
    <div class="p-2">
        <form method="post" action="/signup.do">

            <h1 class="h3 mb-3 fw-normal">회원 가입</h1>

            <a>사용할 아이디를 입력하세요</a>
            <div class="form-floating">
                <input type="text" name="user_id" class="form-control" id="user_id" placeholder="회원 아이디" required>
                <label for="user_id">아이디</label>
            </div>

            <a>사용할 비밀번호를 입력하세요</a>
            <div class="form-floating">
                <input type="password" name="user_password" class="form-control" id="user_password" placeholder="비밀번호"
                       required>
                <label for="user_password">비밀번호</label>
            </div>

            <a>이름을 입력하세요</a>
            <div class="form-floating">
                <input type="text" name="user_name" class="form-control" id="user_name" placeholder="회원 아이디" required>
                <label for="user_name">이름</label>
            </div>

            <a>생년월일을 입력하세요</a>
            <div class="form-floating">
                <input type="date" name="user_birth" class="form-control" id="user_birth" placeholder="생년월일" required>
                <label for="user_birth">생년월일</label>
            </div>

<%--            <a>기본 배송지를 등록하세요</a>--%>
<%--            <div class="form-floating">--%>
<%--                <input type="text" name="user_address" class="form-control" id="user_address" placeholder="기본 배송지 주소"--%>
<%--                       required>--%>
<%--                <label for="user_birth">배송지</label>--%>
<%--            </div>--%>

            <button class="w-100 btn btn-lg btn-primary mt-3" type="submit">Sign up</button>

            <p class="mt-5 mb-3 text-muted">© 2022-2024</p>

        </form>
    </div>
</div>