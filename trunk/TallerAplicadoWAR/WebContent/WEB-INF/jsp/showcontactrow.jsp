<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Ejemplo de Resultado en Tabla</title>
</head>
<body>
<h2>Registros Ingresados</h2>
<table width="50%">
    <tr>
        <th>Nombre</th>
        <th>Apellido</th>
        <th>Mail</th>
        <th>Telefono</th>
    </tr>
    <c:forEach items="${contactForm.contacts}" var="contact" varStatus="status">
        <tr>
            <td>${contact.nombre}</td>
            <td>${contact.apellido}</td>
            <td>${contact.mail}</td>
            <td>${contact.telefono}</td>
        </tr>
    </c:forEach>
</table>  
<br/>
<input type="button" value="Back" onclick="javascript:history.back()"/>
</body>
</html>