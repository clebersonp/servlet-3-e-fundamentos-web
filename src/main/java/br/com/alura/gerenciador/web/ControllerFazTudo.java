package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Usando esse controller, estamos implementando o modelo MVC - Model View Controller, onde,
 * o Controller é essa servlet, o Model é a execução da logica da aplicação, por exemplo, logar um usuario,
 * buscar uma empresa, logout de usuario etc. E a view são as páginas html, jsp etc.
 * 
 * O controller diz qual é o modelo que será executado, e também saberá redirecionar para 
 * qual pagina(view) desse ser encaminhada para renderizar e visualiza-la
 * 
 * 
 * Ela controla qual tarefa será executada e qual visualização será mostrada
 * @author Cleberson
 *
 */
@WebServlet(urlPatterns = "/executa")
public class ControllerFazTudo extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// esse metodo service executa qualquer requisição, seja via doGet quanto doPost
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// vou recuperar qual é a classe que precisará executar minha lógica, mas é tudo string correto?
		String tarefa = req.getParameter("tarefa");
		
		// caso o usuario esqueça de passar o parametro tarefe na uri jogamos uma exception
		if (tarefa == null) {
			throw new IllegalArgumentException("Você esqueceu de passar a tarefa");
		}
		
		try {
			// recuperar o nome completo da classe que queremos executar a logica
			String nomeClasse = "br.com.alura.gerenciador.web." + tarefa;
			
			// usando a API reflexion do java, vamos instanciar uma classe a partir do nome dela(string)
			Class<?> tipoTarefa = Class.forName(nomeClasse);
			
			/* instanciar a classe, e criar uma interface, para toda tarefa possuir um metodo executa(),
			 * que executa a logica e devolve o uri que deve ser renderizada */
			Tarefa instancia = (Tarefa) tipoTarefa.newInstance();
			String pagina = instancia.executa(req, resp);
			
			// encaminho a uri que dever ser chamada para renderizar a pagina(jsp)
			RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
			dispatcher.forward(req, resp);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
		
	}
	
}
