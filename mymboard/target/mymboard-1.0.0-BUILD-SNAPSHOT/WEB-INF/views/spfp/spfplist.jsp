<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="UTF-8" />

<style>
#prev {
	visibility: hidden;
	position: absolute;
	top: 60%;
	text-align: left;
}
</style>
<table class="list_table">
	<colgroup>
		<col style="width: 150px;" />
		<col style="width: auto;" />
		<col style="width: 100px;" />
	</colgroup>
	<thead>
		<tr>
			<th>작성일</th>
			<th>제목</th>
			<th>작성자</th>
		</tr>
	</thead>
	<c:forEach var="spfp" items="${spfplist}" varStatus="spfpS">
		<tr class="_hover_tr">
			<td><fmt:formatDate value="${spfp.wdate}" pattern="yyyy-MM-dd HH:mm"/></td>
			<td style="text-align: left" onmouseover="hover('${spfp.seq}')" onmouseout="down()">
			  <a href="./spfpdetail.do?seq=${spfp.seq}" >
						<font class="team${spfp.team}">■ ${spfp.team}팀 일지 보기</font>
				</a>
			</td>
			<td>${spfp.id}</td>
		</tr>
	</c:forEach>
</table>
<form name="frmForm" id="_frmForm" method="get" action=""></form>
<form name="frmForm2" id="_frmForm2" method="get" action="">
<input type="hidden" name='today' value='${today}'/>
</form>
<div id="buttons_wrap">
	<span class="button blue">
	<c:if test="${login.auth==1}">
	<button type="button" id="_btnAdd">글쓰기</button> | <button type="button" id="_btnReply">PDF 저장</button>
	</c:if>
	<c:if test="${login.auth!=1}">
	<button type="button" id="_btnAdd">글쓰기</button> 
	</c:if>
	</span>
</div>


<script type="text/javascript">
function filedowns(filename,seq){
	alert(filename+'  '+seq);
	var doc=document.delfileup;
	doc.filename.value=filename;
	doc.seq.value=seq;
	doc.submit();
}
$("#_btnReply").click(function() {	
	alert('저장');	
	//submitContents($("#_frmForm"),'bbsreply.do');
	$("#_frmForm2").attr({ "target":"_self", "action":"spfpPDFs.pdf"}).submit();
});
$("#_btnAdd").click(function() {	
	alert('글쓰기');	
	$("#_frmForm").attr({ "target":"_self", "action":"spfpwrite.do" }).submit();
});

function hover(msg) {
	$("#prev").css("visibility", "visible");
	$.ajax({
		data:{seq:msg},
		url:"spfpprev.do",
		success:function(data) {
			var ss="<p>내용: " + data.content+"</p>";
			ss = ss + "<p>작성자: " + data.id + "</p>";
			if(data.img!=null) {
				ss = ss + "<p><img src='" + data.path + data.img + "'width = '300px' /></p>";
			} else {
				ss = ss + "<p> 사진 없음 </p>";
			} $("#prev").html(ss);
		}
	});
	
}
function down() {
	$("#prev").css("visibility", "hidden");
}
</script>