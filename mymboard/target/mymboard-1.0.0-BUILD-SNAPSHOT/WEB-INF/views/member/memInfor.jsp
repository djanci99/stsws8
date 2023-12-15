<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<fmt:requestEncoding value="UTF-8"/>
<div>
<table class="list_table" style="width:85%;">
<colgroup>
<col style="width:100px;" />
<col style="width:200px;" />
<col style="width:200px;" />
<col style="width:auto;" />
</colgroup>
<tr>
<th>team</th>
<th>아이디</th>
<th>이름</th>
<th>이메일</th>
</tr>
<c:forEach items="${memInfors}" var="myinfor" varStatus="vs">
	<tr>
	<td  class='team${myinfor.team}' ><span style='background-color: #F8E692'>${myinfor.team}</span></td>
	<td>${myinfor.id}</td>
	<td>${myinfor.name}</td>
	<td>${myinfor.email}</td>
	</tr>
</c:forEach>
</table>
</div>