<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<fmt:requestEncoding value="UTF-8"/>

<form name="frmForm" id="_frmForm" action="" method="post" 
enctype="multipart/form-data">
<input type="hidden" name="seq"   value="${spfpDiary.seq}"/>
<table class="list_table" style="width:85%;">
<colgroup>
<col style="width:200px;" />
<col style="width:auto;" />
</colgroup>
<tr>
<th>아이디</th>
<td style="text-align: left"><input type="text" name='id' readonly="readonly"
value="${spfpDiary.id}" size="50"/></td>
</tr>
<tr>
<th>개발자 참여</th>
<td style="text-align: left">
<textarea rows="4" cols="70" name='pair' id="_pair">${spfpDiary.pair}</textarea></td>
</tr>
<tr>
<th>참고 사이트</th>
<td style="text-align: left">
<textarea rows="4" cols="70" name='ref' id="_ref">${spfpDiary.ref}</textarea></td>
</tr>
<tr>
<th>파일업로드</th>
<td style="text-align: left"><input type="text" name='namefile' size="50"  value="${spfpDiary.img}" size="50" readonly="readonly"/>
<input type="file" name="fileload" style=" width : 400px;"></td>
</tr>
<tr>


<tr>
<th>일정</th>
<td style="text-align: left">
<select name='year'>
<c:forEach begin="${ct.year-5}" end="${ct.year+6}" step="1" var="iyear">
<option ${iyear eq ct.year? "selected='selected'":"" } value="${iyear}">${iyear}</option>
</c:forEach>
</select>년
<select name='month'>
<c:forEach begin="1" end="12" step="1" var="imonth">
<option ${imonth eq ct.month? "selected='selected'":"" } value="${imonth}">${imonth}</option>
</c:forEach>
</select>월
<select name='day'>
<c:forEach begin="1" end="31" step="1" var="iday">
<option ${iday eq ct.day? "selected='selected'":"" } value="${iday}">${iday}</option>
</c:forEach>
</select>일
<select name='hour'>
<c:forEach begin="0" end="23" step="1" var="ihour">
<option ${ihour eq ct.hour? "selected='selected'":"" } value="${ihour}">${ihour}</option>
</c:forEach>
</select>시
<!-- 여기부터 -->
<select name='min'>
<c:forEach begin="0" end="59" step="1" var="imin">
<option ${imin eq ct.min? "selected='selected'":"" } value="${imin}">${imin}</option>
</c:forEach>
</select>분
<!-- 여기까지 -->
</td>
</tr>
<tr>

<th>내용</th>
<td style="text-align: left"><textarea rows="25" 
cols="70" name='content' id="_content">${spfpDiary.content}</textarea></td>
</tr>
<tr>
<td colspan="2" style="height:50px; text-align:center;">
	<span><a href="#none" id="_btnLogin" title="수정하기"><img src="image/bupdate.png" alt="로그인" /></a>
</span>
</td>
</tr>
</table>
</form>
<script type="text/javascript">
$("#_btnLogin").click(function() {	
	alert('수정하기');	
	$("#_frmForm").attr({ "target":"_self", "action":"spfpupdateAf.do" }).submit();
});
</script>
