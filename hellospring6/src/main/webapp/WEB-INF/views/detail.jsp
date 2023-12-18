<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
	<title>detail</title>
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
	상세보기  
</h1>

<table>
<col width = "200px">
<col width = "500px">
  <tr>
  	<th>번호</th> <td> ${board.seq} </td>
  </tr>
  <tr>
  	<th>아이디</th> <td> ${board.id} </td>
  </tr>
  <tr>
  	<th>제목</th> <td> ${board.title} </td>
  </tr>
  <tr>
  	<th>내용</th>
  	<td><textarea rows ="10" cols = "50">
  		${board.content}
  	</textarea> </td>
  </tr>
  
</table>

<form action="${root}/update" method="get">
  <input type="hidden" id="seq" name="seq" value ="${board.seq}"><br>
  <input type="submit" value="수정하기">
</form>
<form action="${root}/delete" method="get">
  <input type="hidden" id="seq" name="seq" value ="${board.seq}"><br>
  <input type="submit" value="삭제하기">
</form> 

</body>
</html>
