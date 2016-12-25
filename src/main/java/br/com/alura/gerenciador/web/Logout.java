package br.com.alura.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;

//@WebServlet(urlPatterns="/logout")
//public class Logout extends HttpServlet {
public class Logout implements Tarefa {

	private static final long serialVersionUID = 1L;

	
	// Todo codigo de servle foi substituido, pois o FazTudo é a Servlet que executa tudo
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		session.removeAttribute("usuarioLogado");
		return "/WEB-INF/paginas/logout.html";
	}

//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		Cookie cookie = new Cookies(request.getCookies()).getUsuarioLogado();
		
//		HttpSession session = request.getSession();
//		PrintWriter writer = response.getWriter();
		
		// se houver cookie, seta o tempo de vida dele para zero e devolve para o cliente
//		if (cookie != null) {
//			cookie.setMaxAge(0);
//			response.addCookie(cookie);
//			writer.println("<html><body> Usuário "
//					+ cookie.getValue() 
//					+ " foi deslogado com sucesso."
//					+ "</body></html>");
//		} else {
//			writer.print("<html><body> Não existia usuário logado</body></html>");
//		}
		
		// ao inves de usar cookies, vamos utilizar session, mais recomendado
//		session.removeAttribute("usuarioLogado");

//		writer.println("<html><body>Logout efetuado</body></html>"); usar o redirect ao inves de misturar logica java com html
		
		// redireciona o usuario no lado do cliente
//		response.sendRedirect("logout.html"); não usaremos mais esse redirecionamento pois o cliente passa a conhecer a URI
		
		
		// agaora o redirecionamento sera do lado do servidor, pois é só ele que pode acessa o caminho WEB-INF
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginas/logout.html");
//		dispatcher.forward(request, response);
		
//	}
	
}
