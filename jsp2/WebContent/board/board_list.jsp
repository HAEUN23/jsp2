<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp" %>
<title>게시판</title>
</head>
<body>
<table border='1'>
	<tr>
		<td>번호</td>
		<td>이름</td>
		<td>내용</td>
		<td>생성자</td>
		<td>생성일자</td>
	</tr>
	<c:forEach items="${boardList}"  var="b" >
		<tr>
			<td>${b.bNum}</td>
			<td>${b.title}</td>
			<td>${b.content}</td>
			<td>${b.writer}</td>
			<td>${b.regDate}</td>
		</tr>
	</c:forEach>
</table>
게시판리스트입니다.
</body>
</html>