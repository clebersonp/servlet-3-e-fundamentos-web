<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<body>
		Busca de Empresas<br/>
		<ul>
			<c:forEach items="${empresas}" var="empresa">
				<li>${empresa.id}: ${empresa.nome}</li>	
			</c:forEach>
		</ul>
	</body>
</html>