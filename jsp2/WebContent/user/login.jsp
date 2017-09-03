<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%@ include file="/common/header.jsp" %>
<title>로그인</title>
</head>
<script>
$(document).ready(function(){
	$("input[type='button']").click(function(){
		if(this.getAttribute("id")=="btnLogin") return;
		var value = this.value;
		if(value=="회원탈퇴"){
			$("#command").val("delete");
		}else if(value=="회원정보수정"){
			location.href = "/user/update.jsp";
			return;
		}else if(value=="회원리스트"){
			location.href = "/user/list.jsp";
			return;
		}
		this.form.submit();
	})
})
</script>
<body>
<%
if(user==null){
%>
<script>

$(document).ready(function(){
	$("#btnLogin").click(function(){
		var idValue = $("#id").val().trim();
		var pwdValue = $("#pwd").val().trim();
		if(idValue==""){
			alert("아이디를 적어야지!!")
			$("#id").val("");
			$("#id").focus();
			return;
		}
		if(pwdValue==""){
			alert("비밀번호 빼먹었네!!")
			$("#pwd").val("");
			$("#pwd").focus();
			return;
		}
		var param = {};
		param["id"] = idValue;
		param["pwd"] = pwdValue;
		
		param = "?command=login&param=" + JSON.stringify(param);
		param = encodeURI(param);
		var au = new AjaxUtil("test.user",param,"get",false);
		au.changeCallBack(callback);
		au.send();
	});
})

function callback2(result){
	var re = JSON.parse(result);
	alert(re.result);
	location.href = re.url;
}
function callback(result){
	var idValue = $("#id").val().trim();
	var pwdValue = $("#pwd").val().trim();
	var param = {};
	param["id"] = idValue;
	param["pwd"] = pwdValue;
	
	param = "?command=login&param=" + JSON.stringify(param);
	param = encodeURI(param);
	var au1 = new AjaxUtil("test.user",param,"post",false);
	au1.changeCallBack(callback2);
	au1.send();
}
</script>
<form action="login.user" method="get">
아이디 : <input type="text" name="id" id="id"><br>
비밀번호 : <input type="password" name="pwd" id="pwd"><br>
<input type="hidden" name="command"  id="command" value="login">
<input type="button" id="btnLogin" value="로그인">
</form>
<%
}else {
	String id = user.get("id");
	String userNo = user.get("user_no");
	String name = user.get("name");
	String hobby = user.get("hobby");
	String result = userNo+"번째로 가입하신" + name + "님 반갑습니다.<br>";
	result += name + "님의 id는 " + id + "이며 취미는 아래와 같습니다.<br>";
	result += " 취미 : " + hobby;
	out.println(result);
%>
<form action="some.user" method="post">
<input type="button" value="로그아웃">
<input type="button" value="회원탈퇴">
<input type="button" value="회원정보수정">
<input type="button" value="회원리스트">
<input type="hidden" name="command" id="command" value="logout">
<input type="hidden" name="userNo" value="<%=userNo%>">
</form>
<%
}
%>
</body>
</html>