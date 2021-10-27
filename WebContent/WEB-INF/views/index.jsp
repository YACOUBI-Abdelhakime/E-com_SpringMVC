<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<!DOCTYPE html>

<c:if test = "${sessionScope.lang == null }">
   <% session.setAttribute("lang","fr"); %>
</c:if>


<html>
<head>
<meta charset="ISO-8859-1">
<title>SEBO</title>

</head>
<style><%@include file="/WEB-INF/style/style.css"%></style>
<body bgColor="#ffc299">

	<c:set var="method" value="<%=request.getMethod() %>"/>
	<c:if test = "${method.equals('POST') }">
	   		<% session.setAttribute("lang",request.getParameter("lang")); %>
	   		<c:out value=""/>
	</c:if>
	<fmt:setLocale value="${sessionScope.lang}" />
	<fmt:setBundle basename="languages.text"/>




    <h1 > <fmt:message key="index.title" /> </h1>
    <hr><br>
    <a href="identifier"><fmt:message key="index.identifier" /></a><br>
    <a href="inscrire"><fmt:message key="index.inscrire" /></a>
    
    <form action="changeLangIndex" method="post">
    	<fmt:message key="index.selectLang" /> : 
    	<select name="lang">
           <option value="fr">Frensh</option>
           <option value="en">English</option>
        </select>
        <input type="submit" value="<fmt:message key="index.ok" />">
    </form>
    

    
</body>
</html>