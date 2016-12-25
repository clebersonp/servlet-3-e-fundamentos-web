<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8"/>
	</head>
	<body>
		<c:if test="${not empty usuarioLogado}">
			Usu�rio ${usuarioLogado.email} logado com sucesso!
		</c:if>
		<c:if test="${empty usuarioLogado}">
			Usu�rio ou senha inv�lidos!
		</c:if>
	</body>
</html>