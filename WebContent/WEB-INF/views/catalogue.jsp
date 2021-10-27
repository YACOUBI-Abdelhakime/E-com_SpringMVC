<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 <%@ page session="true" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Catalogue</title>
</head>
<style><%@include file="/WEB-INF/style/style.css"%></style>
<body bgcolor="#66b3ff">
  
     
    <h1 style="color:maroon; font-style:italic; text-align:center;"> Catalogue ${sessionScope.client.getNom()}</h1><hr>
    <h4 style="float:right;" ><a href="logout">logOut</a></h4>
    <form action="cataloge" method="post">
    Choisissez un genre :
    	<select name="categorie">
	          <option value="all" selected>All</option>
    			<c:forEach var="cat" items="${Categories}">
			          <option value="${cat.getRefCat()}">${cat.getCat()}</option>
			    </c:forEach>
        </select>
        <input type="submit" value="ok"/>
    </form>
    <h3> Categorie : ${Categorie}</h3>
    <table border=2>
      <tr style="background-color:#66ff66"> 
        <td>Reference</td>
        <td>Titre</td>
        <td>Designation</td>
        <td>Photo</td>
        <td>Prix</td>
        <td>Operation</td>
      </tr>
      <c:if test="${Articles != null }">
      		<c:forEach items="${Articles}" var="art">
	      		<tr>
	      			<td>${art.getCodeArticle()}</td>
	      			<td>${art.getTitre()}</td>
	      			<td>${art.getDesignation()}</td>
	      			<td><img style="height: 50px;width: 50px;" src="${art.getPhoto()}" alt="photo"></td>
	      			<td>${art.getPrix()}</td>
	      			<td><a href="details?code=${art.getCodeArticle()}"> Voir les détails</a></td>
	      		</tr>
	      </c:forEach>
      </c:if>
    </table>
  
</body>
</html>