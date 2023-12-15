<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:requestEncoding value="utf-8"/>
<style>
<!--
.menu_table li.menu_item a:hover { background-image:url("<%=request.getContextPath()%>/image/arrow.gif"); background-repeat:no-repeat; background-position:5px 7px; background-color:#FFFFFF; }
-->
</style>
<div class="menu_table">
	<ul style="width:100%;">
	<li class="title">일지게시판</li>
	<li class="subtitle">일지게시판</li>
	<li class="menu_item"><a href="#none" onclick="url_spfpcal();" title="글목록">일지 목록</a></li>		
	<li class="menu_item"><a href="#none" onclick="url_spfpwrite();" title="글쓰기">일지 쓰기</a></li>
	<c:if test="${login.auth eq '1'}">
		<li class="menu_item"><a href="#none" onclick="url_spfpteam();" title="팀 바꾸기">팀 바꾸기</a></li>
	</c:if>		
	<c:if test="${login.auth ne '1'}">
		<li class="menu_item"><a href="#none" onclick="url_spfpmyteam('${login.team}');" title="내팀 자료">내팀 자료</a></li>
	</c:if>					
	</ul>				
</div>
<c:if test="${login.auth==3}">
<div class="team">
<%
for(int i=1; i<16 ;i++){
	%>
	<p class="team">&nbsp;<font class="team<%=i%>">■ <%=i%> 팀</font></p>
	<%
}
%>
</div>
</c:if>
<c:if test="${login.auth==1}">
<div class="team">
<%
for(int i=1; i<16 ;i++){
	%>
	<p class="team">&nbsp;<font class="team<%=i%>">■ <%=i%> 팀</font>&nbsp; <a href="#none" onclick="url_spfpmyteam('<%=i%>');" title="내팀 자료"><font style='font-size:8px'>[<%=i%> 팀]</font></a></p>
	<%
}
%>
</div>
</c:if>