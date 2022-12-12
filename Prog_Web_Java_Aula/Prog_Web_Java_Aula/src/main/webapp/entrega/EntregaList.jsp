<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista das Entregas</title>
</head>
<body>
	<h1>Entregas:</h1>
	<form id="formulario01" action="EntregaFind" method="post">

		<table>
			<tr>
				<td>Entregas:</td>
				<td><input type="text" placeholder="Venda" name="venda" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Pesquisar" /></td>
			</tr>
			<tr>
				<td colspan="2"><a href="EntregaNew">Cadastrar Entregas</a></td>
			</tr>
		</table>
	</form>
	<a href="Index">Voltar</a>
	<table>
		<tr>
			<th>ID</th>
			<th>Entrega</th>
			<th>Data</th>
		</tr>
		
		<c:forEach var="item" items="${lista}">
			<tr>
				<td><c:out value="${item.id}" /></td>
				<td><c:out value="${item.venda}" /></td>
				<td><c:out value="${item.data}" /></td>
				<td><a href="EntregaDelete?id=<c:out value="${item.id}" />">Deletar</a></td>
				<td><a href="EntregaEdit?id=<c:out value="${item.id}" />">Editar</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>