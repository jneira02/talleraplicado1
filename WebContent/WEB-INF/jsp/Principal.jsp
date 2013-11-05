<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login de administrador</title>
</head>
<body>
<form:form method="post" action="logear.html">
<center><table>
<h5> Login </h5>
    <tr>
        <td><form:label path="user"><spring:message code="label.user"/></form:label></td>
        <td><form:input path="user" /> <form:errors></form:errors></td> 
    </tr>
    <tr>
        <td><form:label path="password"><spring:message code="label.password"/></form:label></td>
        <td><form:password path="password" /></td>
    </tr>
    <tr>
    </tr>
    </table>
    
    <input type="submit" value="Logear"/>

</center>
</form:form>
<br> <br>
<form:form method="post" action="registroAdmin.html">
<center><table>
<h5> Registro </h5>
    <tr>
        <td><form:label path="user"><spring:message code="label.user"/></form:label></td>
        <td><form:input path="user" /> <form:errors></form:errors></td> 
    </tr>
    <tr>
        <td><form:label path="password"><spring:message code="label.password"/></form:label></td>
        <td><form:password path="password" /></td>
    </tr>
    
    
    <tr>
    </tr>
    </table>
    
    <input type="submit" value="Registrar"/>

</center>
</form:form>

</body>
</html>