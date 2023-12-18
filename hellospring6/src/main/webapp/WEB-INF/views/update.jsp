<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
	<title>update</title>
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

<form id="form-register" method="POST"  action="${root}/update">
     <input
       type="hidden"
       class="form-control"
       id="seq"
       name="seq"
       value="${board.seq}"
       readonly="readonly"
     />
	<div class="mb-3">
		<label for="subject" class="form-label">아이디 : </label>	
		<input
		  type="text"
		  class="form-control"
		  id="id"
		  name="id"
		  placeholder="아이디"
		  value="${board.id}"
		  readonly="readonly"
		/>
	</div>
	<div class="mb-3">
		<label for="subject" class="form-label">제목 : </label>
		<input
		  type="text"
		  class="form-control"
		  id="title"
		  name="title"
		  value="${board.title}"
		/>
	</div>
	<div class="mb-3">
		<label for="content" class="form-label">내용 : </label>
			<textarea class="form-control" id="content" name="content" rows="7">
				${board.content}
			</textarea>
	</div>
	<div class="col-auto text-center">
		<button type="submit" id="btn-register" class="btn btn-outline-primary mb-3">
			글수정
		</button>
	</div>
</form>
</body>
</html>
