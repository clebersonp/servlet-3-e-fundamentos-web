package br.com.alura.gerenciador.web;

import javax.servlet.http.Cookie;

public class Cookies {

	private final Cookie[] cookies;

	public Cookies(Cookie[] cookies) {
		this.cookies = cookies;
	}

	// retorna o cookie do usuario logado, caso contrario, retorna null
	public Cookie getUsuarioLogado() {
		// verifica se tem algum cookie, pois pode ser null, ou seja, primeiro usuario a logar
		if (this.getCookies() != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("usuario.logado")) {
					return cookie;
				}
			}
		}
		return null;
	}

	public Cookie[] getCookies() {
		return cookies;
	}
}
