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

import com.google.gson.Gson;

import br.com.controle.financeiro.bean.Usuario;
import br.com.controle.financeiro.bo.UsuarioBO;
import br.com.controle.financeiro.bo.impl.UsuarioBOAbs;
import br.com.controle.financeiro.dao.UsuarioDAO;
import br.com.controle.financeiro.dao.impl.UsuarioDAOImpl;
import br.com.controle.financeiro.singleton.EMFSingleton;

@WebServlet(urlPatterns = "/cadastrar")

public class CadastroServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Cadastro

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = emf.createEntityManager();

		String json = req.getParameter("dados");
		
		Usuario u = new Gson().fromJson(json, Usuario.class);
		UsuarioBO bo = new UsuarioBO();
		
		UsuarioBOAbs abs = new UsuarioBOAbs(u, bo, em);
		
		if (abs.retornaLista().isEmpty()) {
			UsuarioDAO dao = new UsuarioDAOImpl(em);
				dao.cadastrar(u);
				dao.commit();
				em.close();
				emf.close();
				resp.setContentType("application/json");
				resp.getWriter().write(new Gson().toJson(abs.retornaLista()));
				
		} else {
			resp.setContentType("application/json");
			resp.getWriter().write(new Gson().toJson(abs.retornaLista()));
		}
	}
}