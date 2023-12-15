<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<c:set var = "root" value ="${pageContext.request.contextPath}"> </c:set>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${requestScope.serverTime}. </P>
<P>  The time on the server is ${hello}. </P>
<a href="${root}/insert"> 추가 </a> <br> 
</body>
</html>
