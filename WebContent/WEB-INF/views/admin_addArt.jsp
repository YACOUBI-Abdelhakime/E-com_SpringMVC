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
	<h1 style="color:maroon; font-style:italic; text-align:center;">Add Article</h1><hr>
	
	<c:if test = "${titre != null && prix != null}">
	
	<h2 style="color:green; text-align:center;"><c:out value="${titre} Added" /></h2>
		<sql:setDataSource var="cnx"  driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/db"  user="root"  password="" />
  	 	<sql:update dataSource="${cnx}" var="res">  
			INSERT into Articles(titre,designation,prix,stock,categorie,photo) Values (?,?,?,?,?,?); 
		<sql:param value="${titre}" />
		<sql:param value="${designation}" /> 
		<sql:param value="${prix}" />
		<sql:param value="${stock}" /> 
		<sql:param value="${categorie}" />
		<sql:param value="${photo}" /> 
		</sql:update>
	</c:if>
	
	 
	<form action="http://localhost:8089/MiniProjetSpringMVC/adminAddArt" method="post">
	<table>
		<tr>
			<td>Titre</td>
			<td><input type="text" name="titre" required></td>
		</tr>
		<tr>
			<td>Designation</td>
			<td><input type="text" name="designation" required></td>
		</tr>
		<tr>
			<td>Prix</td>
			<td><input type="text" name="prix" required></td>
		</tr>
		<tr>
			<td>Stock</td>
			<td><input type="text" name="stock" required></td>
		</tr>
		<tr>
			<td>Categorie</td>
			<td><input type="text" name="categorie" required></td>
		</tr>
		<tr>
			<td>Chemin Photo</td>
			<td><input type="text" name="photo" required></td>
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