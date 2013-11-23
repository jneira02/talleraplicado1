<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
    <title>Registro de consumos</title>
</head>
<body>
<h2>Registro de consumos</h2>

<form:form method="post" action="registrarConsumoAction.html">
 <center>
    <table>
    
    <tr>
        <td><form:label path="tipo_servicio"><spring:message code="label.tipo_servicio"/></form:label></td>
        <td><form:input path="tipo_servicio" /> <form:errors></form:errors></td> 
    </tr>
    <tr>
    <tr>
        <td><form:label path="unidad_servicio"><spring:message code="label.unidad_servicio"/></form:label></td>
        <td><form:input path="unidad_servicio" /> <form:errors></form:errors></td> 
    </tr>
    <tr>
        <td><form:label path="monto_unidad"><spring:message code="label.monto_unidad"/></form:label></td>
        <td><form:input path="monto_unidad" /></td>
    </tr>
    <tr>
        <td><form:label path="cantidad_unidades"><spring:message code="label.cantidad_unidades"/></form:label></td>
        <td><form:input path="cantidad_unidades" /></td>
    </tr>
    <tr>
        <td><form:label path="monto_total"><spring:message code="label.monto_total"/></form:label></td>
        <td><form:input path="monto_total" /></td>
    </tr>
    <tr>
    <tr>
        <td><form:label path="esta_pagado"><spring:message code="label.esta_pagado"/></form:label></td>
        <td><form:input path="esta_pagado" /></td>
    </tr>
    <tr>
    <tr>
        <td><form:label path="fecha_vencimiento"><spring:message code="label.fecha_vencimiento"/></form:label></td>
        <td><form:input path="fecha_vencimiento" /></td>
    </tr>
   
        <td colspan="2">
            <input type="submit" value="Registrar Consumo"/>
        </td>
    
    
</table>  
     </center>
</form:form>
</body>
</html>