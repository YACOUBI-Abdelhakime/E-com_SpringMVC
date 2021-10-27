<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#80ffd4">
	<h1 style="color:maroon; font-style:italic; text-align:center;">Add Categorie</h1><hr>
	
	<c:if test = "${RefCat != null && Cat != null}">
	
	<h2 style="color:green; text-align:center;"><c:out value="${Cat} Added" /></h2>
		<sql:setDataSource var="cnx"  driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/db"  user="root"  password="" />
  	 	<sql:update dataSource="${cnx}" var="res">  
			INSERT into Categories Values (?,?); 
		<sql:param value="${RefCat}" />
		<sql:param value="${Cat}" /> 
		</sql:update>
	</c:if>
	
	 
	<form action="http://localhost:8089/MiniProjetSpringMVC/adminAddCat" method="post">
	<table>
		<tr>
			<td>Ref Categorie</td>
			<td><input type="text" name="RefCat"></td>
		</tr>
		<tr>
			<td>Categorie</td>
			<td><input type="text" name="Cat"></td>
		</tr>
		<tr>
		<td></td>
			<td><input type="submit" value="Add Categorie"></td>
		</tr>
	</table>
	</form>
	<a href="http://localhost:8089/MiniProjetSpringMVC/admin">Retuen</a>
</body>
</html>