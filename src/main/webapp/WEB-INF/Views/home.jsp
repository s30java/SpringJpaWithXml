<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/assets/css/StyleSheet.css" />" rel="stylesheet">
<title>::::::::::::::::::</title>
</head>
<body>
   <h1>List of all persons</h1>
   <form:form action="addPerson.html" modelAttribute="person" method="post">
  Name: <form:input path="name" id="name"/>
  <input type="submit" name="Submit"  value="Add">
  </form:form>
 <br> 
  <table class="CSSTableGenerator">
  <tr><td><b>ID</b></td><td><b>Name</b></td></tr>
  <c:forEach var="p" items="${persons}">
  <tr>
  <td>${p.id}</td>
    <td>${p.name}</td>
  </tr>

  </c:forEach>
  </table>


</body>
</html>