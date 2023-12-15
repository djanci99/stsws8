<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<c:set var = "root" value ="${pageContext.request.contextPath}"> </c:set>
<html>
<head>
	<title>Insert</title>
</head>
<body>
<h1>
	Hello insert world!  
</h1>

<form action="${root}/login" method="post">
  <label for="ssid">아이디:</label><br>
  <input type="text" id="ssid" name="ssid" placeholder="아이디"><br>
  <label for="sspw">패스워드:</label><br>
  <input type="password" id="sspw" name="sspw" placeholder="비밀번호"><br><br>
  <input type="submit" value="Submit">
</form> 

<a href="${root}/insert"> 추가 </a> <br>
</body>
</html>
