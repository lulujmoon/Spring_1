<%@page import="com.redbeet.s1.passbook.PassbookDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	List<PassbookDTO> ar = (List<PassbookDTO>)request.getAttribute("list"); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Passbook List</h1>
	<h1>${kind }</h1>
	<h1>${list }</h1>
</body>
</html>