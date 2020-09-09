package br.com.controle.financeiro.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface InterfaceServlet{
	
	public void processarRequest(HttpServletRequest req, HttpServletResponse resp)throws Exception;

}
