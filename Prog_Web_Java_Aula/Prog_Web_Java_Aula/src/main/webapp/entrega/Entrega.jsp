<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jstl/core"  prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Entregas</title>
</head>
<body>
<h1>Cadastro de Entregas:</h1>

<form id="formulario01" action="EntregaSave" method="post">

<input type="hidden" id="id" name="id" 
		value="<c:out value="${entrega.id}"/>" /> 
	
	<div>
		<label>Entrega:</label>
		<input type="text" placeholder="Cadastro da entrega" id="venda" name="venda" 
		value="<c:out value="${entrega.venda}"/>" /> 
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