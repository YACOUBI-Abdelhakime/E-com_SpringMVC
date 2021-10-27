<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<!DOCTYPE html>
<fmt:setLocale value="${sessionScope.lang}" />
<fmt:setBundle basename="languages.text"/>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style><%@include file="/WEB-INF/style/style.css"%></style>
<body bgColor="#66b3ff">
<h1 ><fmt:message key="identifier.tilte" /></h1><hr>
<div id="container">
	<form action="login" method="post">
		<table>
			<tr>
				<td><fmt:message key="identifier.email" /> :</td>
				<td><input type="text" name="email"/><br></td>
			</tr>
			<tr>
				<td><fmt:message key="identifier.pswd" /> :</td>
				<td><input type="password" name="motPass"/><br></td>
			</tr>
			<tr>
			 	<td><input type="submit" value="<fmt:message key="identifier.ok" />"/></td>
			</tr>
		
		</table>		
	</form>
</div>
</body>
</html>