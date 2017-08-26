<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
</head>
<body>
<form action="sigin.user" method="post">
<table border="1">
	<tr>
		<td colspan="2" align="center">회원가입</td>
	</tr>
	<tr>
		<td>아이디</td>
		<td><input type="text" name="id" id="id"></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="pwd" id="pwd"></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><input type="text" name="name" id="name"></td>
	</tr>
	<tr>
		<td>취미</td>
		<td>
			수면<input type="checkbox" name="hobby" value="수면">
			음악<input type="checkbox" name="hobby" value="음악">
			영화<input type="checkbox" name="hobby" value="영화">
			게임<input type="checkbox" name="hobby" value="게임">
			요리<input type="checkbox" name="hobby" value="요리">
			여행<input type="checkbox" name="hobby" value="여행">
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="회원가입"></td>
	</tr>
</table>
<input type="hidden" name="command" value="signin">
</form>
</body>
</html>