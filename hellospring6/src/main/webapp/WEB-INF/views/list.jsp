<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
	<title>list</title>
	<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
</head>
<body>
[${login.name}]님&nbsp;&nbsp;&nbsp;&nbsp;<a href="${root}/list">목록</a>&nbsp;<a href="${root}/write">글쓰기</a>&nbsp;<a href="${root}/logout">로그아웃</a>
<hr/>
<h1>
	Hello world!  
</h1>

<table>
  <tr>
  <th>번호</th>
    <th>아이디</th>
   <!--  <th>이름</th> -->
    <th>제목</th>
  </tr>
  <c:if test=${empty lists} }>
    <tr>
    <td colspan ="3">작성된 글이 없습니다.</td>
    </tr>
  </c:if> 
  <c:forEach items="${lists}" var="board" varStatus="vs">
    <tr>
    <td>${vs.count+1}</td>
    <td>${board.id}</td>
   <%--  <td>${board.name}</td> --%>
    <td>${board.title}</td>
  </tr>
  </c:forEach>
</table>

</body>
</html>
