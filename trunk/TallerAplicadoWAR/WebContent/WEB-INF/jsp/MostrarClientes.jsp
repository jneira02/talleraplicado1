<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logeado</title>
</head>
<body>




	<h1>Estoy en JSP de mostrar :)</h1>
	<table width="110%">
		<center>
			<form:form method="post" action="registroClientes.html">
				<input type="submit" value="Crear nuevo cliente" />
			</form:form>
		</center>

		<tr>
			<th>Rut</th>
			<th>Nombres</th>
			<th>Apellido Materno</th>
			<th>Apellido Paterno</th>
			<th>Telefono</th>
			<th>Email</th>
			<th>Direccion</th>
		</tr>
		<c:forEach items="${objectForm.object}" var="cliente"
			varStatus="status">
			<tr><h5>
				<td>${cliente.rut}</td>
				<td>${cliente.nombres}</td>
				<td>${cliente.apellido_materno}</td>
				<td>${cliente.apellido_paterno}</td>
				<td>${cliente.telefono}</td>
				<td>${cliente.email}</td>
				<td>${cliente.direccion}</td></h5>
				<form:form method="post" action="modificarCliente.html">
					<input name="rut" type="hidden" value="${cliente.rut}" />
					<input name="nombres" type="hidden" value="${cliente.nombres}" />
					<input name="apellido_materno" type="hidden" value="${cliente.apellido_materno}" />
					<input name="apellido_paterno" type="hidden" value="${cliente.apellido_paterno}" />
					<input name="telefono" type="hidden" value="${cliente.telefono}" />
					<input name="email" type="hidden" value="${cliente.email}" />
					<input name="direccion" type="hidden" value="${cliente.direccion}" />
					<td><input type="submit" value="Modificar" /></td>
				</form:form>
				<form:form method="post" action="historialCambios.html">
					<input name="rut" type="hidden" value="${cliente.rut}"/>
					<td><input type="submit" value="Ver historial cambios" /></td>
				</form:form>
				<form:form method="post" action="estadoCuenta.html">
					<input name="rut" type="hidden" value="${cliente.rut}" />
					<td><input type="submit" value="Estado de cuenta" /></td>
				</form:form>
			</tr>
		</c:forEach>
	</table>
</body>
</html>