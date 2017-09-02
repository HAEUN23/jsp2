<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script>

var func1 = function(func){
	this.test = func;
}

var f = new func1(function(){
	alert(1);
});
f.test();
</script>
<body>
<input type="button" value="click" onclick="test1()">
<div id="r_div"></div>
</body>
</html>