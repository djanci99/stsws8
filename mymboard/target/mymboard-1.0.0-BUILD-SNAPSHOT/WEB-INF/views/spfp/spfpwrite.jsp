<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<fmt:requestEncoding value="UTF-8"/>

<form name="frmForm" id="_frmForm" action="" method="post" 
enctype="multipart/form-data">
<table class="list_table" style="width:85%;">
<colgroup>
<col style="width:200px;" />
<col style="width:auto;" />
</colgroup>
<tr>
<th>아이디</th>
<td style="text-align: left"><input type="text" name='id' readonly="readonly"
value="${login.id}" size="50"/></td>
</tr>
<tr>
<th>개발자 참여 (페어 개발자 참여여부/ 결석여부/ 결석원인)</th>
<td style="text-align: left">
<textarea rows="4" cols="70" 
name='pair' id="_pair">.</textarea></td>
</tr>
<tr>
<th>참고 사이트</th>
<td style="text-align: left">
<textarea rows="4" cols="70" name='ref' id="_content">.</textarea></td>
</tr>
<tr>
<th>파일업로드</th>
<td style="text-align: left"><input type="file" name="fileload" style=" width : 400px;"></td>
</tr>
<tr>
<th>내용</th>
<td style="text-align: left"><textarea rows="25" 
cols="70" name='content' id="_content">.</textarea></td>
</tr>
<tr>
<td colspan="2" style="height:50px; text-align:center;">
	<span><a href="#none" id="_btnLogin" title="글쓰기"><img src="image/bwrite.png" alt="로그인" /></a>
</span>
</td>
</tr>
</table>
</form>
<script type="text/javascript">
$("#_btnLogin").click(function() {	
	alert('글쓰기');	
	//submitContents($("#_frmForm"));
	$("#_frmForm").attr({ "target":"_self", "action":"spfpwriteAf.do" }).submit();
});
</script>
