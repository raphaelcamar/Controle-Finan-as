package br.com.controle.financeiro.servlets;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import br.com.controle.financeiro.bean.Usuario;
import br.com.controle.financeiro.bo.UsuarioBO;

@WebServlet(urlPatterns = "/logar")

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = emf.createEntityManager();

		String json = req.getParameter("jsonLogin");

		Usuario u = new Gson().fromJson(json, Usuario.class);
		UsuarioBO bo = new UsuarioBO();

		if (bo.validarLogin(u.getSenha(), u.getCpf(), em) == true) {
			resp.setContentType("application/json");
			resp.getWriter().write(new Gson().toJson(""));
			HttpSession userSession = req.getSession();
			userSession.setAttribute("logUser", u);
			RequestDispatcher rd;

		} else {
			resp.setContentType("application/json");
			resp.getWriter().write(new Gson().toJson("Usuário ou senha inválidos"));
		}

	}

}