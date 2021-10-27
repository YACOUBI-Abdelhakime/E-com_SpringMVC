<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ page session="true" %>
<!DOCTYPE html>
<html>
<style><%@include file="/WEB-INF/style/style.css"%></style>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body bgcolor="#66ff99">
     <h4 style="color:rebeccapurple; text-decoration: underline;float:right;" ><a href="logout">logOut </a></h4>
    <h1 style="color:maroon;"> Bienvenue ${sessionScope.client.getNom()} ${sessionScope.client.getPrenom()}</h1><hr><br>
    <a  href="catalogue">Consulter Catalogue</a><br><br>
    <a  href="commandes">Suivre vos commande</a><br><br>
    <a  href="panier">Visualisier voter Panier </a>
</body>
</html>