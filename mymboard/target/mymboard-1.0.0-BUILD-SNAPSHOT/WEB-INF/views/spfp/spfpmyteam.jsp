<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:requestEncoding value="utf-8"/>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<style>
div.gallery {
  margin: 5px;
  border: 2px solid #ccc;
  width: 250px;
  height:200px;
  float: left;
}

div.gallery:hover {
  border: 2px solid #777;
}

div.gallery img {
  float: left;
  width: 250px;
  height:200px;
}

div.desc {
  padding: 15px;
  text-align: left;
  font-size: 16px;
}
.photos::after {
  content: "";
  display: table;
  clear: both;
}
</style>

<div class="box_border" style="margin-top:5px; margin-bottom: 10px;">
	<table class="list_table" style="width:85%;">
	<colgroup>
	<col style="width:100px;" />
	<col style="width:200px;" />
	<col style="width:auto;" />
	</colgroup>
	<tr>
	<th>team</th>
	<th>아이디</th>
	<th>이름</th>
	</tr>
	<c:forEach items="${memInfors}" var="myinfor" varStatus="vs">
		<tr>
		<td  class='team${myinfor.team}' ><span style='background-color: #F8E692'>${myinfor.team}</span></td>
		<td>${myinfor.id}</td>
		<td>${myinfor.name}</td>
		</tr>
	</c:forEach>
	</table>
</div>
<div class="box_border" style="margin-top:5px; margin-bottom: 10px;">
	<c:forEach items="${spfpDiarys}" var="spfpDiary" varStatus="vs">
		<div class="photos">
			<div class="gallery">
				<a target="_self" href="${root}/spfpdetail.do?seq=${spfpDiary.seq}">
				  <img src="${root}/upload/${spfpDiary.img}" alt="${spfpDiary.team}" >
				 </a>
			</div>
			<div class="desc">[${spfpDiary.wdate}]<p>${spfpDiary.content}</p></div>
		</div>
	</c:forEach>
</div>

<c:if test="${login.auth==1 ||  login.team==myteam}">
<form name="frmForm2" id="_frmForm2" method="get" action="">
<input type="hidden" name='team' value='${myteam}'/>
</form>
<div id="buttons_wrap">
	<span class="button blue">
		<button type="button" id="_btnReply">PDF 저장</button>
	</span>
</div>
</c:if>
<br/>
<script type="text/javascript">

$("#_btnReply").click(function() {	
	alert('저장');	
	//submitContents($("#_frmForm"),'bbsreply.do');
	$("#_frmForm2").attr({ "target":"_self", "action":"spfpmyteams.pdf"}).submit();
});


</script>