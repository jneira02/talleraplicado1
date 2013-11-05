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


	<h1>Estoy en JSP de mostrar cuentas y consumos :)</h1>
	<h2><td>Viendo datos de ${objectForm.object[0].cuentaVO.clienteVO.nombres}</td></h2>
	
	
	<table width="110%">
		
		
		
		<tr>
			<th>Tipo</th>
			<th>Unidad</th>
			<th>P/p Unidad</th>
			<th>c/ Unidades</th>
			<th>Total</th>
			<th>Pago</th>
			<th>Vencimiento</th>
			<th>Estado cuenta</th>
		</tr>

		

		<c:forEach items="${objectForm.object}" var="consumo"
			varStatus="status">
			<tr>
				<td>${consumo.tipo_servicio}</td>
				<td>${consumo.unidad_servicio}</td>
				<td>${consumo.monto_unidad}</td>
				<td>${consumo.cantidad_unidades}</td>
				<td>${consumo.monto_total}</td>
				<td>${consumo.esta_pagado}</td>
				<td>${consumo.fecha_vencimiento}</td>
				<td>${consumo.cuentaVO.esActiva}</td>
				<td>${consumo.cuentaVO.clienteVO.rut}</td>
			</tr>
		
		</c:forEach>
		
	<form:form method="post" action="registrarConsumo.html">
			<input name="rut" type="hidden" value="${objectForm.object[0].cuentaVO.clienteVO.rut}" />
			<td><input type="submit" value="Registro de consumo" /></td>
	</form:form>
	
	<form:form method="post" action="activarCuentaAction.html">
			<input name="rut" type="hidden" value="${objectForm.object[0].cuentaVO.clienteVO.rut}" />
			<td><input type="submit" value="Activar/desactivar cuenta" /></td>
	</form:form>

	</table>
</body>
</html>