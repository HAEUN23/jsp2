<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="/js/jquery-3.2.1.min.js"></script>
<script src="/js/AjaxUtil.js"></script>

<script src="/js/jquery-3.2.1.js"></script>
<script src="/ui/common.js"></script>
<script src="/ui/btsp3.7.7/js/bootstrap.min.js"></script>
<script src="/ui/btsp3.7.7/js/bootstrap-table.js"></script>
<script src="/ui/btsp3.7.7/js/bootstrap-table.js"></script>
<link rel="stylesheet" href="/ui/btsp3.7.7/css/bootstrap-theme.min.css"/>
<link rel="stylesheet" href="/ui/btsp3.7.7/css/bootstrap.min.css"/>
<link rel="stylesheet" href="/ui/btsp3.7.7/css/bootstrap-table.css"/>
<link rel="stylesheet" href="/ui/common.css"/>
<% 
boolean debugMod = true;
String urlStr = request.getRequestURL().toString();
Map<String,String> user = null;
if(session.getAttribute("user")!=null){
	user = (Map<String,String>)session.getAttribute("user");
}else if(urlStr.indexOf("/user/login")==-1){
%>
<script>
	location.href="/user/login.jsp";
</script>
<%	
}

%>