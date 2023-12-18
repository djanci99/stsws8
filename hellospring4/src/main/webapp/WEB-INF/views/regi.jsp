<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
	<title>regi</title>
</head>
<body>
<h1>
	Hello world! 회원가입!! 
</h1>

<form action="${root}/regi" method="post">
  <label for="id">아이디:</label><br>
  <input type="text" id="id" name="id" placeholder="아이디"><br>
  <label for="name">이름:</label><br>
  <input type="text" id="name" name="name" placeholder="이름"><br>
  <label for="email">패스워드:</label><br>
  <input type="email" id="email" name="email" placeholder="email"><br>
  <label for="pwd">패스워드:</label><br>
  <input type="password" id="pwd" name="pwd" placeholder="패스워드"><br><br>
  <input type="submit" value="회원가입">
</form> 

<a href="${root}/index">login</a>
</body>
</html>



