<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 <%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details</title>
</head>
<body bgcolor="#66b3ff">
  
     
    <h1 style="color:maroon; font-style:italic; text-align:center;"> Detail de l'article ${sessionScope.client.getNom()}</h1><hr>
    <h4 style="color:rebeccapurple; text-decoration: underline;float:right;" ><a href="logout">logOut</a></h4>
     <table border=1>
     
     
                <tr>
                  <td><img style="height: 130px;width: 130px;" src="${item.getPhoto()}" alt="photo"></td>
                </tr>
		        <tr> 
		        	<td style="width:150px;">Reference : </td>
		        <td style="width:150px;">${item.getCodeArticle()}</td>
		        	<td style="width:150px;">Desigantion : </td>
		        	<td style="width:150px;">${item.designation}</td>
		        </tr>
		        <tr> 
			        <td style="width:100px;">titre : </td>
			        <td style="width:100px;">${item.titre}</td>
			        <td style="width:100px;">Prix : </td>
			        <td style="width:100px;">${item.prix}</td>
		        </tr>
		        
    
    </table>
    <h3 style="text-align:center;">
    <a style="color:rebeccapurple; text-decoration: underline;margin-right:20px;" href="catalogue">Retour</a>
    <a style="color:rebeccapurple; text-decoration: underline;" href="panier?codeArticle=${item.getCodeArticle()}">Ajouter au panier</a>
     </h3>
</body>
</html>