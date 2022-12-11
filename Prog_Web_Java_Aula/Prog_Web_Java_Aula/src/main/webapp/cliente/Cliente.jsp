<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jstl/core"  prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Clientes</title>
</head>
<body>
<h1>Cadastro de Clientes:</h1>

<form id="formulario01" action="ClienteSave" method="post">

<input type="hidden" id="id" name="id" 
		value="<c:out value="${cliente.id}"/>" /> 
	
	<div>
		<label>Nome:</label>
		<input type="text" placeholder="Nome do Cliente" id="nome" name="nome" 
		value="<c:out value="${cliente.nome}"/>" /> 
	</div>

	
	<div>
		<label>Email:</label>
		<input type="email" placeholder="E-mail" id="email" name="email" 
		value="<c:out value="${cliente.email}"/>" /> 
	</div>
	
		
	<div>
		<label>Endereço:</label>
		<input type="text" placeholder="Rua fulando de tal, 1010" id="endereco" name="endereco" 
		value="<c:out value="${cliente.email}"/>" /> 
	</div>
	
		
	<div>
		<label>Celular:</label>
		<input type="tel" placeholder="(xx)9xxxx-xxxx" id="telefone" name="telefone" 
		value="<c:out value="${cliente.telefone}"/>" /> 
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