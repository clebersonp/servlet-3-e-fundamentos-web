<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
</head>
<body>
Bem vindo ao nosso gerenciador de empresas!<br/>

<!-- quando não setamos uma variavel pelo request do usuario, o framework procura na session, que é este caso -->
<c:if test="${not empty usuarioLogado}">
	Bem vindo, ${usuarioLogado.email}
</c:if>

<form action="executa" method="post">
	<input type="hidden" name="tarefa" value="NovaEmpresa">
	Nome: <input type="text" name="nome">
	<input type="submit" value="Enviar">
</form>

<form action="executa" method="post">
	<input type="hidden" name="tarefa" value="Login">
	Email: <input type="text" name="email">
	Senha: <input type="password" name="senha">
	<input type="submit" value="Entrar">
</form>

<form action="executa" method="get">
	<input type="hidden" name="tarefa" value="BuscaEmpresa">
	Nome da Empresa:<input type="text" name="filtro">
	<input type="submit" value="Buscar">
</form>

<!-- a ação chama o servlet executa -->
<form action="executa" method="post">
	<!-- passando o parametro tarefa com o valor = Logout -->
	<input type="hidden" name="tarefa" value="Logout">
	<input type="submit" value="Logout">
</form>

</body>
</html>