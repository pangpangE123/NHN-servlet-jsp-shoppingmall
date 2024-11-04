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
    <form method="post" action="/mypage/addaddress.do">

      <h1 class="h3 mb-3 fw-normal">배송지 추가</h1>

      <a>사용할 아이디를 입력하세요</a>
      <div class="form-floating">
        <input type="text" name="new_address" class="form-control" id="user_id" placeholder="주소" required>
        <label for="user_id">주소</label>
      </div>

      <button class="w-100 btn btn-lg btn-primary mt-3" type="submit">입력</button>

      <p class="mt-5 mb-3 text-muted">© 2022-2024</p>

    </form>
  </div>
</div>