<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>메뉴 정보 전체 조회</title>
</head>
<body>
    <h1>메뉴 정보 전체 조회</h1>
    <table>
        <tr>
            <th>메뉴코드</th>
            <th>메뉴이름</th>
            <th>메뉴가격</th>
            <th>판매여부</th>
            <th>카테고리코드</th>
        </tr>
        <c:forEach items="${ menuList}" var="menu">
            <tr>
                <td>${menu.menuCode}</td>
                <td>${menu.menuName}</td>
                <td>${menu.menuPrice}</td>
                <td>${menu.orderableStatus}</td>
                <td>${menu.categoryCode}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
