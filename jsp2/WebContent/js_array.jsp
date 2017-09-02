<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script>
var test = function(){
	this.a = "123";
	var b = "456";
	this.tt = function(){
		alert(b);
		alert("아~");
	}
	var tt2 = function(){
		alert("tt2");
	}
	this.arr = {};
	this.arr["key1"] = "value1";
	this.arr["key2"] = "value2";
	this.arr.key3 = "value3";
	this.json = JSON.stringify(this.arr);
}

function test1(){
	var t = new test();
	var obj = JSON.parse(t.json);
	alert(obj.key1);
}
</script>
<body>
<input type="button" value="click" onclick="test1()">
<div id="r_div"></div>
</body>
</html>