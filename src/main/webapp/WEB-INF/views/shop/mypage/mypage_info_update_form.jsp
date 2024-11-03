<%@ page import="com.nhnacademy.shoppingmall.user.domain.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style>
    table, th, td {
        border: 1px solid black;
    }

    .table-container {
        margin-bottom: 40px;
    }

    input[type="text"] {
        border: 1px solid #ccc; /* 입력 박스 테두리 색상 */
        border-radius: 4px; /* 모서리 둥글게 */
        padding: 5px; /* 패딩 */
        width: 100%; /* 전체 너비 */
        box-sizing: border-box; /* 테두리 포함 */
    }

    input[type="password"] {
        border: 1px solid #ccc; /* 비밀번호 입력 박스 테두리 색상 */
        border-radius: 4px; /* 모서리 둥글게 */
        padding: 5px; /* 패딩 */
        width: 100%; /* 전체 너비 */
        box-sizing: border-box; /* 테두리 포함 */
    }
</style>

<div style="margin: auto; width: 400px;">
    <div class="p-2">


        <div class="table-container">
            <h1 class="h1 mb-3 fw-normal">회원정보 수정</h1>

            <form method="post" action="/mypage/infoupdate.do">

            <div class="form-floating">
                <h1 class="h3 mb-3 fw-normal">기본 정보</h1>
                <table>
                    <tr>
                        <th>아이디</th>
                        <td><%=((User) (request.getSession().getAttribute("USER_TOKEN"))).getUserId() %></td>
                    </tr>
                    <tr>
                        <th>이름</th>
                        <td>
                            <input type="text" name="newName" value="<%=((User) (request.getSession().getAttribute("USER_TOKEN"))).getUserName() %>" required/>
                        </td>
                    </tr>
                    <tr>
                        <th>비밀번호</th>
                        <td>
                            <input type="password" name="newPassword" placeholder="새 비밀번호 입력" required/>
                        </td>
                    </tr>
                    <tr>
                        <th>생년월일</th>
                        <td>
                        <input type="date" name="newBirth" class="form-control" id="user_birth" placeholder="생년월일"
                               required value=
                                   <%=((User) (request.getSession().getAttribute("USER_TOKEN"))).getUserBirth().substring(0,4) +"-"
                               + ((User) (request.getSession().getAttribute("USER_TOKEN"))).getUserBirth().substring(4,6) +"-"
                               + ((User) (request.getSession().getAttribute("USER_TOKEN"))).getUserBirth().substring(6,8)%>
                                />
                        </td>
                    </tr>
                    <tr>
                        <th>권한</th>
                        <td><%=((User) (request.getSession().getAttribute("USER_TOKEN"))).getUserAuth() %></td>
                    </tr>
                    <tr>
                        <th>포인트</th>
                        <td><%=((User) (request.getSession().getAttribute("USER_TOKEN"))).getUserPoint() %></td>
                    </tr>
                    <tfoot>
                    <tr>
                        <td colspan="3" style="text-align: center;">
                            <button class="btn btn-warning" type="submit">수정 완료</button>
                        </td>
                    </tr>
                    </tfoot>
                </table>
            </div>

            </form>
        </div>
    </div>
</div>
