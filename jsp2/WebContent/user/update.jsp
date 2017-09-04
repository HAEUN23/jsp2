<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp" %>
<title>회원정보 수정</title>
</head>
<body>
<script>
$(document).ready(function(){
	var params = {};
	params["user_no"] = "<%=request.getParameter("user_no")%>";
	params = "?command=view&param=" + JSON.stringify(params);
	params = encodeURI(params);
	var au = new AjaxUtil("update.user",params,"post");
	au.changeCallBack(callback);
	au.send();
})
function callback(result){
	alert(result);
	var obj = JSON.parse(result);
	$("#name").val(obj.name);
	$("#id").val(obj.id);
	var hobbies = obj.hobby.split(",");
	for(var i=0, max=hobbies.length;i<max;i++){
		$("input[value='" + hobbies[i] + "']").prop("checked", true);
	}
	alert(obj.user_no);
	$("#userNo").val(obj.user_no);
}
function check(){
	var nameValue = $("#name").val().trim();
	var pwdValue = $("#pwd").val().trim();
	if(nameValue==""){
		alert("이름 좀 적자!!");
		$("#name").val("");
		$("#name").focus();
		return false;
	}
	
	if(pwdValue==""){
		alert("비밀번호 좀 적자!!");
		$("#pwd").val("");
		$("#pwd").focus();
		return false;
	}
	return true;
}
</script>
<div id="test"></div>
<form action="sigin.user" method="post" onsubmit="return check()">
<table border="1">
	<tr>
		<td colspan="2" align="center">회원정보 수정</td>
	</tr>
	<tr>
		<td>아이디</td>
		<td><input type="text" name="id" id="id"  readonly></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="pwd" id="pwd" ></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><input type="text" name="name" id="name" ></td>
	</tr>
	<tr>
		<td>취미</td>
		<td>
			수면<input type="checkbox" name="hobby" value="수면" >
			음악<input type="checkbox" name="hobby" value="음악">
			영화<input type="checkbox" name="hobby" value="영화">
			게임<input type="checkbox" name="hobby" value="게임" >
			요리<input type="checkbox" name="hobby" value="요리">
			여행<input type="checkbox" name="hobby" value="여행">
		</td>  
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="회원정보수정"></td>
	</tr>
</table>
<input type="hidden" name="command" value="update">
<input type="hidden" name="userNo" id="userNo">
</form>
</body>
</html>