package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;

//@WebServlet(urlPatterns = "/login")
//public class Login extends HttpServlet {
public class Login implements Tarefa {

//	private static final long serialVersionUID = 1L;

//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		PrintWriter writer = response.getWriter();
		
		// recuperando os valores dos campos via post
//		String email = request.getParameter("email");
//		String senha = request.getParameter("senha");
//		
		// verificar se o usuário existe no "banco"
//		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);
//		
//		if (usuario == null) {
//			writer.println("<html><body>Usuário ou senha inválida.</body></html>");
//		} else {
//			
			// e o usuário existir vamos criar um cookie e enviar para o cliente/navegador
			// o tempo de vida será de 10 minutos
//			Cookie cookie = new Cookie("usuario.logado", email);
//			cookie.setMaxAge(10 * 60);
//			response.addCookie(cookie);
			
			// outra forma de atrelar o usuario á requisicao é usando session, mais recomendado
//			HttpSession session = request.getSession();
//			session.setAttribute("usuarioLogado", usuario);
//			
//			writer.println("<html><body>Usuário logado: " + email + "</body></html>");
//		}
		
//	}
	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		
		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);
		
		HttpSession session = req.getSession();
		session.setAttribute("usuarioLogado", usuario);
		
		return "/WEB-INF/paginas/login.jsp";
		
	}
	
}
