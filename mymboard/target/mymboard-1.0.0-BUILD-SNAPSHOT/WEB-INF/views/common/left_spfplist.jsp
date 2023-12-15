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
		<li class="menu_item"><a  href="#none" 
		onclick="url_memInfor();" title="모든팀 자료">
		<span class="team0">■ 모든 팀</span></a></li>		
	</c:if>		
	<%
	for(int i=1; i<16 ;i++){
		%>
		<c:set value="<%=i%>" var="ii"/>
		<li ${login.team==ii ? "style='display:none'":"" } class="menu_item"><a  href="#none" 
		onclick="url_spfpmyteam('<%=i%>');" title="<%=i%>팀 자료">
		<span class="team<%=i%>">■ <%=i%> 팀</span></a></li>		
		<li ${login.team !=ii ? "style='display:none'":"" } class="menu_item"><a href="#none" 
		onclick="url_spfpmyteam('${login.team}');" title="내팀 자료"> 
		<span class="team<%=i%>">■ <%=i%> 팀&nbsp;</span>[내팀 자료]</a></li>		
		<%
	}
	%>
	</ul>				
</div>
<div id="prev" style="visibility:hidden">
	<p>prev</p>
</div>