
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>메뉴 정보</title>
</head>
<body>
<h1>${ param.menuCode}번 메뉴 정보</h1>
<h4>메뉴명: ${selectedMenu.menuName}}</h4>
<h4>메뉴가격: ${selectedMenu.menuPrice}}</h4>
<h4>판매여부: ${selectedMenu.orderableStatus}}</h4>
<h4>카테고리코드: ${selectedMenu.categoryCode}}</h4>
</body>
</html>
