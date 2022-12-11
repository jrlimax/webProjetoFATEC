<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista dos Clientes</title>
</head>
<body>
	<h1>Clientes:</h1>
	<form id="formulario01" action="ClienteFind" method="post">

		<table>
			<tr>
				<td>Nome do cliente:</td>
				<td><input type="text" placeholder="Nome do Cliente" name="nome" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Pesquisar" /></td>
			</tr>
			<tr>
				<td colspan="2"><a href="ClienteNew">Cadastrar Cliente</a></td>
			</tr>
		</table>
	</form>
	<a href="Index">Voltar</a>
	<table>
		<tr>
			<th>ID</th>
			<th>Cliente</th>
			<th>E-Mail</th>
			<th>Telefone</th>
			<th>Endereço</th>
		</tr>
		
		<c:forEach var="item" items="${lista}">
			<tr>
				<td><c:out value="${item.id}" /></td>
				<td><c:out value="${item.nome}" /></td>
				<td><c:out value="${item.email}" /></td>
				<td><c:out value="${item.telefone}" /></td>
				<td><c:out value="${item.endereco}" /></td>
				<td><a href="ClienteDelete?id=<c:out value="${item.id}" />">Deletar</a></td>
				<td><a href="ClienteEdit?id=<c:out value="${item.id}" />">Editar</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>