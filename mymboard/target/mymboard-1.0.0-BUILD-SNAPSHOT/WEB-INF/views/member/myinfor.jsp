<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<fmt:requestEncoding value="UTF-8"/>
<div class="box_border" style="margin-top:5px; margin-bottom: 10px;">
<form name="frmForm" id="_frmForm" action="" method="post" >
<table class="list_table" style="width:85%;">
<colgroup>
<col style="width:200px;" />
<col style="width:auto;" />
</colgroup>
<tr>
<th>아이디</th>
<td style="text-align: left"><input type="text" name='id' 
readonly="readonly" id='_userid' 
value="${myinfor.id}" size="70"/></td>
</tr>
<tr>
<th>이름</th>
<td style="text-align: left"><input type="text" name='name' id='_name' 
value="${myinfor.name}" size="70"/></td>
</tr>
<tr>
<th>이메일</th>
<td style="text-align: left"><input type="text" name='email' id='_email' 
value="${myinfor.email}" size="70"/></td>
</tr>
<tr>
<th>패스워드(구)</th>
<td style="text-align: left"><input type="password" name='pwd' id='_pwd' 
value="" size="70"/></td>
</tr>
<tr>
<th>패스워드(신)</th>
<td style="text-align: left"><input type="password" name='npwd'  id='_npwd' 
value="" size="70"/></td>
</tr>
<tr>
<th>팀</th>
<td style="text-align: left"><input type="text" name='team' readonly="readonly"
value="${myinfor.team}" size="70"/></td>
</tr>
<tr>
<td colspan="2" style="height:50px; text-align:center;">
	<span><a href="#none" id="_btnLogin" title="정보변경"><img src="image/bupdate.png" alt="정보변경" /></a>
</span>
</td>
</tr>
</table>
</form>
</div>
<script type="text/javascript">
$("#_btnLogin").click(function() {	
	if ($("#_userid").val() == "") {
		alert("ID를 입력해 주십시요.");
		$("#_userid").focus();
	} else if ($("#_name").val() == "") {
		alert("이름을 입력해 주십시요.");
		$("#_name").focus();
	} else if ($("#_email").val() == "") {
		alert("이메일을 입력해 주십시요.");
		$("#_email").focus();
	}else if ($("#_pwd").val() == "") {
		alert("(구)패스워드를 입력해 주십시요.");
		$("#_pwd").focus();
	}else if ($("#_npwd").val() == "") {
		alert("(신)패스워드를 입력해 주십시요.");
		$("#_npwd").focus();
	}
	else {
		alert('정보수정');	
		$("#_frmForm").attr({ "target":"_self", "action":"myinforAf.do" }).submit();
	}
});
</script>
