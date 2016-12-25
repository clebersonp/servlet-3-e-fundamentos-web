package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;

@WebFilter(urlPatterns = "/*")
public class FiltroDeAuditoria implements Filter {

	private final Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		String uri = req.getRequestURI();
		
		// toda requisicao passa por esse filtro, e se já tiver cookie, ele vem para o servidor no request
		// recuperar os cookies e saber quem está logado
		
		String email = getUsuario(req, resp);
		
//		System.out.println("Usuario " + email + " acessando a URI: " + uri);
		logger.info("Usuario " + email + " acessando a URI: " + uri + "\n");
		
		// força o fluxo normal após passar por esse filtro
		chain.doFilter(request, response);
	}

	private String getUsuario(HttpServletRequest req, HttpServletResponse resp) {
//		Cookie cookie = new Cookies(req.getCookies()).getUsuarioLogado();
//		if (cookie != null) {
//			// se quiser adicionar um tempo de vida maior para o cookie a cada requisição
//			// é só configurar o MaxAge();
//			cookie.setMaxAge(10 * 60); // adicionando mais 10 minutos
//			resp.addCookie(cookie); // adicionando o cookie para devolver ao cliente
//			return cookie.getValue();
//		}
		
		// usaremos session ao inves de cookies.
		HttpSession session = req.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		if (usuario != null) {
			// adiciono mais 10 minutos, caso ultrapasse esse tempo a session expira
			session.setMaxInactiveInterval(10 * 60);
			return usuario.getEmail();
		}
		return "<Deslogado>";
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
