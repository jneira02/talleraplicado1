<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
    <title>Registro de Contacto</title>
</head>
<body>
<h2>Formulario Registro de Nuevo Cliente</h2>

<form:form method="post" action="registrarClienteAction.html">
 <center>
    <table>
    
    <tr>
        <td><form:label path="rut"><spring:message code="label.rut"/></form:label></td>
        <td><form:input path="rut" /> <form:errors></form:errors></td> 
    </tr>
    <tr>
    
    
    <tr>
        <td><form:label path="nombres"><spring:message code="label.nombres"/></form:label></td>
        <td><form:input path="nombres" /> <form:errors></form:errors></td> 
    </tr>
    <tr>
        <td><form:label path="apellido_paterno"><spring:message code="label.apellido_paterno"/></form:label></td>
        <td><form:input path="apellido_paterno" /></td>
    </tr>
    <tr>
        <td><form:label path="apellido_materno"><spring:message code="label.apellido_materno"/></form:label></td>
        <td><form:input path="apellido_materno" /></td>
    </tr>
    <tr>
        <td><form:label path="telefono"><spring:message code="label.telefono"/></form:label></td>
        <td><form:input path="telefono" /></td>
    </tr>
    <tr>
    <tr>
        <td><form:label path="email"><spring:message code="label.email"/></form:label></td>
        <td><form:input path="email" /></td>
    </tr>
    <tr>
    <tr>
        <td><form:label path="direccion"><spring:message code="label.direccion"/></form:label></td>
        <td><form:input path="direccion" /></td>
    </tr>
   
        <td colspan="2">
            <input type="submit" value="Registrar Cliente"/>
        </td>
    
    
</table>  
     </center>
</form:form>
</body>
</html>