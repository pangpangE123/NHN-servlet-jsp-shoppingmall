<%@ page import="com.nhnacademy.shoppingmall.user.domain.User" %><%--
  Created by IntelliJ IDEA.
  User: pangpange
  Date: 2024. 11. 3.
  Time: PM 1:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" session="false" %>
<style>
    table, th, td {
        border: 1px solid black;
    }

    .table-container{
        margin-bottom: 40px;
    }


</style>

<div style="margin: auto; width: 400px;">
    <div class="p-2">


        <div class="table-container">
            <h1 class="h1 mb-3 fw-normal">마이페이지</h1>
            <div class="form-floating">

                <h1 class="h3 mb-3 fw-normal">기본 정보</h1>
                <table>
                    <tr>
                        <th>아이디</th>
                        <td><%=((User) (request.getSession().getAttribute("USER_TOKEN"))).getUserId() %>
                        </td>
                    </tr>
                    <tr>
                        <th>이름</th>
                        <td><%=((User) (request.getSession().getAttribute("USER_TOKEN"))).getUserName() %>
                        </td>

                    </tr>
                    <tr>
                        <th>비밀번호</th>
                        <td>
                            비밀번호는 표시되지 않습니다
                        </td>
                    </tr>
                    <tr>
                        <th>생년월일</th>
                        <td><%=((User) (request.getSession().getAttribute("USER_TOKEN"))).getUserBirth().substring(0, 4) + "년"
                                + ((User) (request.getSession().getAttribute("USER_TOKEN"))).getUserBirth().substring(4, 6) + "월"
                                + ((User) (request.getSession().getAttribute("USER_TOKEN"))).getUserBirth().substring(6, 8) + "일"
                        %>
                        </td>
                    </tr>
                    <tr>
                        <th>권한</th>
                        <td><%=((User) (request.getSession().getAttribute("USER_TOKEN"))).getUserAuth() %>
                        </td>
                    </tr>
                    <tr>
                        <th>포인트</th>
                        <td><%=((User) (request.getSession().getAttribute("USER_TOKEN"))).getUserPoint() %>
                        </td>
                    </tr>
                    <tfoot>
                    <tr>
                        <td colspan="3" style="text-align: center;">
                            <a class="btn btn-warning" href="/mypage/infoupdate.do">내 정보 수정</a>
                        </td>
                    </tr>
                    </tfoot>
                </table>
            </div>
        </div>

        <div class="table-container">
            <h1 class="h3 mb-3 fw-normal">배송지 정보</h1>
            <table>
                <tr>
                    <th>배송지1</th>
                    <td>경기도 성남시 분당구 불정로 32
                    </td>
                    <td>
                        <a class="btn btn-danger" href="#">수정</a>
                    </td>
                </tr>
                <tr>
                    <th>배송지2</th>
                    <td>전라남도 광주광역시 동구 동명동 113-98
                    </td>
                    <td>
                        <a class="btn btn-danger" href="#">수정</a>
                    </td>
                </tr>
                <tr>
                    <th>배송지3</th>
                    <td>경남 김해시 내동 503-5
                    </td>
                    <td>
                        <a class="btn btn-danger" href="#">수정</a>
                    </td>
                </tr>
                <tfoot>
                <tr>
                    <td colspan="3" style="text-align: center;">
                        <a class="btn btn-success" href="#">배송지 추가</a>
                        <a class="btn btn-danger" href="#">배송지 삭제</a>
                    </td>
                </tr>
                </tfoot>
            </table>
        </div>


        <p class="mt-5 mb-3 text-muted">© 2022-2024</p>

    </div>
</div>
