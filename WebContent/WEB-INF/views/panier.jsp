<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#66b3ff">
	<h1 style="color:maroon; font-style:italic; text-align:center;" >Panier ${sessionScope.client.getNom()} </h1><hr>
	<table border=1>
		<tr>
			<td>Photo</td>
			<td>Titre</td>
			<td>Qty</td>
			<td>Date</td>
		</tr>
		<c:forEach var="pan" items="${panier}">
			<tr>
				<td><img src="${pan.getArticle().getPhoto()}" style="height: 60px;width: 60px;"></td>
				<td>${pan.getArticle().getTitre()}</td>
				<td>${pan.getQty()}</td>
				<td>${pan.getDateCommande()}</td>
			</tr>
		</c:forEach>
		
	
	</table>

</body>
</html>