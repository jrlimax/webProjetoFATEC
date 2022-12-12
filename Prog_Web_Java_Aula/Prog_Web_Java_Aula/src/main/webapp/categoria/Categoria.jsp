<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jstl/core"  prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Categorias</title>
</head>
<body>
<h1>Cadastro de Categorias:</h1>

<form id="formulario01" action="CategoriaSave" method="post">

<input type="hidden" id="id" name="id" 
		value="<c:out value="${cliente.id}"/>" /> 
	
	<div>
		<label>Nome:</label>
		<input type="text" placeholder="Nome do Cliente" id="nome" name="nome" 
		value="<c:out value="${cliente.nome}"/>" /> 
	</div>

	
	<div>
		<label>Descrição:</label>
		<input type="text" placeholder="Descrição" id="descricao" name="descricao" 
		value="<c:out value="${cliente.descricao}"/>" /> 
	</div>
	
	<div>
		<input type="submit" value="Cadastrar">
	<button>
		<a href="Index">Voltar</a>
	</button>
	</div>
	
</form>

</body>
</html>