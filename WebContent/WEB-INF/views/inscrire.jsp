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
<title>SEBO</title>
</head>
<style><%@include file="/WEB-INF/style/style.css"%></style>
<body bgColor="#66b3ff">
<h1 ><fmt:message key="identifier.tilte" /></h1><hr>
<div class="container">
	<form action="insertionUser" method="post">
		<table >
			<tr>
				<td><fmt:message key="inscrire.nom" /> :</td>
				<td><input type="text" name="nom" required /><br></td>
			</tr>
			<tr>
				<td><fmt:message key="inscrire.prenom" /> :</td>
				<td><input type="text" name="prenom" required /><br></td>
			</tr>
			<tr>
				<td><fmt:message key="inscrire.adress" /> :</td>
				<td><input type="text" name="adress" required /><br></td>
			</tr>
			<tr>
				<td><fmt:message key="inscrire.codePostal" /> :</td>
				<td><input type="text" name="codePostal"  required  /><br></td>
			</tr>
			<tr>
				<td><fmt:message key="inscrire.ville" /> :</td>
				<td><input type="text" name="ville" required /><br></td>
			</tr>
			<tr>
				<td><fmt:message key="inscrire.tel" /> :</td>
				<td><input type="text" name="tel"/><br></td>
			</tr>
			<tr>
				<td><fmt:message key="inscrire.email" /> :</td>
				<td><input type="text" name="email" required /><br></td>
			</tr>
			<tr>
				<td><fmt:message key="inscrire.motPass" /> :</td>
				<td><input type="text" name="motPass" required /><br></td>
			</tr>
			<tr>
			<td></td>
			 	<td><input type="submit" value="<fmt:message key="inscrire.ok" />"/></td>
			</tr>
		
		</table>		
	</form>
</div>
</body>
</html>