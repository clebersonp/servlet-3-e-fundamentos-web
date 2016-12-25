package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

/**
 * Importante, toda servlet é instanciada uma unica vez,
 * ela só é destruida se desligarmos o servidor.
 * 
 * Para evitar problemas, não devemos criar variáveis de membro,
 * pois pode ser acessada em concorrencia, o que resultaria em informaçoes inconsistentes
 * @author Cleberson
 *
 */


//@WebServlet(urlPatterns = "/busca")
//public class BuscaEmpresa extends HttpServlet {
public class BuscaEmpresa implements Tarefa {

	private static final long serialVersionUID = 1L;
	
	// Entendendo quando uma servlet é instanciada
	public BuscaEmpresa() {
//		System.out.println("Instanciando uma Servlet do tipo BuscaEmpresa: " + this);
		System.out.println("Instanciando a classe do tipo BuscaEmpresa: " + this);
	}
	
	
	// verificar quando o inite é chamando
//	@Override
//	public void init() throws ServletException {
//		super.init();
//		System.out.println("Inicializando a Servlet: " + this);
//	}

	// entendendo quando o destroy é invocado
//	@Override
//	public void destroy() {
//		super.destroy();
//		System.out.println("Destruindo a Servlet: " + this);
//	}
	
//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		/*PrintWriter writer = response.getWriter();
		
		writer.write("<html><body>");
		writer.write("<h1>Primeira Servlet</h1>");
		writer.write("<p>Busca Empresas:</p>");
		writer.write("<ul>");*/
		
//		String filtro = request.getParameter("filtro");
//		Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(filtro);
//		
//		request.setAttribute("empresas", empresas);// setando a coleção para recuperar na pagina jsp
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginas/buscaEmpresa.jsp");
//		dispatcher.forward(request, response);
		
		/*for (Empresa empresa : empresas) {
			writer.write("<li>");
			writer.write(empresa.getId() + ": " + empresa.getNome());
			writer.write("</li>");
		}
		
		writer.write("</ul>");
		writer.write("</body></html>"); faremos de forma dinamica, criando a pagina buscaEmpresa.jsp*/
//	}
	
	// Trocando a servlet por essa classe, pois o fazTudo é a servlet que controla tudo
	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		String filtro = req.getParameter("filtro");
		Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(filtro);
		req.setAttribute("empresas", empresas);
		return "/WEB-INF/paginas/buscaEmpresa.jsp";
	}
}