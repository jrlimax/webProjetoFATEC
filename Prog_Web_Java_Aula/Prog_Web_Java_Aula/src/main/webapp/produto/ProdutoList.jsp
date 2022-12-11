<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"  %>
<%@ taglib uri="http://java.sun.com/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Listagem de Produtos</h1>
<form id="formulario01" action="ProdutoFind" method="post">
<table>
	<tr><td>Nome</td><td><input type="text" name="nome"/></td></tr>
	<tr><td colspan="2"><input type="submit"  value="Pesquisar" /></td></tr>
	<tr><td colspan="2"><a href="ProdutoNew">Novo Produto</a></td></tr>
</table>
</form>
<a href="Index">Voltar</a>
<table>
	<tr>
		<th>Codigo</th>
		<th>Nome</th>
		<th>Descrição</th>
		
	</tr>
	<c:forEach var="item" items="${lista}" >
		<tr>
			<td><c:out value="${item.codigo}" /> </td>
			<td><c:out value="${item.nome}"/></td>
			<td><c:out value="${item.descricao}"/></td>
			<td><a href="ProdutoDelete?id=<c:out value="${item.codigo}" />">Deletar</a></td>
			<td><a href="ProdutoEdit?id=<c:out value="${item.codigo}" />">Editar</a></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>