<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core"  prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro Produto</title>
</head>
<body>
<form id="formulario01" action="ProdutoSave" method="post">
<input type="hidden" id="codigo" name="codigo" 
		value="<c:out value="${produto.codigo}"/>" /> 
		
<table>
<tr>
<td>Nome</td><td>
<input type="text" id="nome" name="nome" 
		value="<c:out value="${produto.nome}"/>" /> 
</td>
</tr>
<tr>
<td>Descri??o</td><td><input type="text" id="descricao" name="descricao" value="<c:out value="${produto.descricao}"/>" /> </td>
</tr>
<tr>
<td>Pre?o</td><td>
<input type="text" id="preco" name="preco"
value="<c:out value="${produto.preco}"/>" /> 

</td>
</tr>
<tr>
	<td><input type="submit" value="Gravar">
		<input type="submit" value="limpar">
		<a href="ProdutoList">Voltar</a>
	</td>
</tr>
</table>
</form>
</body>
</html>