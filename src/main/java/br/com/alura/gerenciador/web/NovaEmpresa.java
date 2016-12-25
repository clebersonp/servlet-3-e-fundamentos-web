package br.com.alura.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

//@WebServlet(urlPatterns = "/novaEmpresa")
//public class NovaEmpresa extends HttpServlet {
public class NovaEmpresa implements Tarefa {

	private static final long serialVersionUID = 1L;
	
//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		PrintWriter writer = response.getWriter();
		
//		String nome = request.getParameter("nome");
//		Empresa novaEmpresa = new Empresa(nome);
//		new EmpresaDAO().adiciona(novaEmpresa);
		
		//System.out.println("Testando....");
		
		/*writer.write("<html><body>Empresa "
					+ novaEmpresa.getNome()
					+" cadastrada com sucesso."  
					+ " </body></html>");
					
		 vamos usar o redirecionamento no lado do servidor(server side)
		 e vamos setar a empresa no request, para a pagina jsp recuperar o nome da
		 empresa cadastrada*/
		
		// setando a empresa para mostrar na pagina jsp, atraves do request do usuario
//		request.setAttribute("empresa", novaEmpresa);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginas/novaEmpresa.jsp");
//		dispatcher.forward(request, response);
		
//	}
	
	
	/* deixando a servlet de lado, vamos implementar a interface tarefa 
	 * e retornar a uri para o faz tudo despachar e renderizar a pagina para nos*/
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		String nomeEmpresa = req.getParameter("nome");
		if (nomeEmpresa != null && !nomeEmpresa.isEmpty()) {
			Empresa empresa = new Empresa(nomeEmpresa);
			new EmpresaDAO().adiciona(empresa);
			return "/WEB-INF/paginas/novaEmpresa.jsp";
		}
		// caso contrario volta para a pagina principal
		
		return "index.jsp";
	}
	
}
