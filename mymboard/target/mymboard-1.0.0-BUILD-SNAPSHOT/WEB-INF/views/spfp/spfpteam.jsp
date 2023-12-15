<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:requestEncoding value="utf-8"/>
<table class="list_table" style="width: 85%;">
<colgroup>
<col style="width: 70px;" />
<col style="width: auto;" />
<%-- <col style="width: 100px;" /> --%>
</colgroup>
<thead>
<tr>
<th>아이디</th>
<th>기존 팀</th>
<!-- <th>팀 변경</th> -->
</tr>
</thead>
<c:forEach items="${members }" var="member">
<tr>
<td><input type="hidden" name="id" value="${member.id }" />${member.name }[${member.id }]</td>
<td><font class="team${member.team}">■ ${member.team} 팀</font></td>
</c:forEach>
</table>
<form name="frmForm" id="_frmForm" method="post" action="">
<select name='id'>
<c:forEach items="${members }" var="member" varStatus="vss">
<option value="${member.id }">${member.name }[${member.id }]</option>
</c:forEach>
</select>
<select name='team'>
<c:forEach begin="0" end="15" step="1" varStatus="vs">
<option value="${vs.index }">${vs.index }</option>
</c:forEach>
</select>
</form>
<a href="#none" id="_btnUpdate" title="글수정하기"><img src="image/bupdate.png" alt="수정하기" /></a>
<script type="text/javascript">
$("#_btnUpdate").click(function() {	
	alert('팀 변경');
	$("#_frmForm").attr({ "target":"_self", "action":"spfpteamAf.do" }).submit();
});
</script>