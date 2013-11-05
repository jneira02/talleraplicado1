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




	<h1>Estoy en el historial :)</h1>
	<table width="110%">

		<tr>
			<th>Rut</th>
			<th>Nombres</th>
			<th>Apellido Materno</th>
			<th>Apellido Paterno</th>
			<th>Telefono</th>
			<th>Email</th>
			<th>Direccion</th>
			<th>Fecha modificacion</th>
			<th>Autor</th>
		</tr>
		<c:forEach items="${objectForm.object}" var="cliente"
			varStatus="status">
			<tr>
				<h5><td>${cliente.rut}</td>
				<td>${cliente.nombres}</td>
				<td>${cliente.apellido_materno}</td>
				<td>${cliente.apellido_paterno}</td>
				<td>${cliente.telefono}</td>
				<td>${cliente.email}</td>
				<td>${cliente.direccion}</td>
				<td>${cliente.fecha_modificacion}</td>
				<td>${cliente.loginVO.administradorVO.user}</td></h5>
				
				
				
				
				

			</tr>
		</c:forEach>
	</table>
</body>
</html>