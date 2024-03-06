<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>menudb 테이블에서 menu_code를 이용하여 메뉴 정보 조회하기</h1>
<form action="${pageContext.servletContext.contextPath}/menudb/select">
    <label>조회할 메뉴 : </label>
    <input type="text" name="menuCode" id="menuCode">
    <button>조회하기</button>
</form>

<h1>menudb 테이블에서 메뉴 전체 정보 조회(판매중인 메뉴만 조회)</h1>
<button onclick="location.href='${pageContext.servletContext.contextPath}/menudb/list'">
    메뉴 정보 전체 조회하기
</button>

<h1>menudb 테이블에서 신규 메뉴 정보 추가</h1>
<form action="${pageContext.servletContext.contextPath}/menudb/insert" method="post">
    메뉴명 : <input type="text" name="menuName"><br>
    메뉴 가격: <input type="text" name="menuPrice"><br>
    판매 여부: <input type="text" name="orderableStatus">
    카테고리 코드:
    <select name="categoryCode">
        <option value="1">식사</option>
        <option value="2">음료</option>
        <option value="3">디저트</option>
        <option value="4">한식</option>
        <option value="5">중식</option>
        <option value="6">일식</option>
        <option value="7">퓨전</option>
        <option value="8">커피</option>
        <option value="9">쥬스</option>
        <option value="10">기타</option>
        <option value="11">동양</option>
        <option value="12">서양</option>
    </select>
    <button type="submit">등록하기</button>
</form>


<h1>menudb 테이블에서 메뉴명 수정</h1>
<form action="${pageContext.servletContext.contextPath}/menudb/update" method="post">
    메뉴코드: <input type="text" name="menuCode">
    변경할 메뉴명: <input type="text" name="menuName">
    <button type="submit">메뉴명 변경</button>
</form>

<h1>menudb 테이블에서 메뉴명 삭제</h1>
<form action="${pageContext.servletContext.contextPath}/menudb/delete" method="post">
    메뉴코드: <input type="text" name="menuCode">
    <button type="submit">메뉴삭제</button>
</form>
</body>
</html>
