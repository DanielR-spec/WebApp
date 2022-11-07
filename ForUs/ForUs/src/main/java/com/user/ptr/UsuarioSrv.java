package com.user.ptr;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Parameter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Usuario
 */

@WebServlet(urlPatterns = { "/UsuarioSrv" })
public class UsuarioSrv extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final String CONTENT_TYPE = "text/html; charset=windows-1252";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsuarioSrv() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doDelete(req, resp);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Invocación al método SERVICE del Servlet UsuarioSrv");
		super.service(req, resp);


	}

	@Override
	public ServletContext getServletContext() {
		// TODO Auto-generated method stub
		return super.getServletContext();
	}

	@Override
	public String getInitParameter(String name) {
		// TODO Auto-generated method stub
		return super.getInitParameter(name);
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return super.getServletConfig();
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return super.getServletInfo();
	}

	@Override
	public Enumeration<String> getInitParameterNames() {
		// TODO Auto-generated method stub
		return super.getInitParameterNames();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("===Acceso al servlet de User Login===");
		System.out.println("Invocación al método INIT del Servlet");
		
		super.init(config);

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Invocación al método DESTROY del Servlet");
		// super.destroy();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Invocación al método deGet del Servlet");
		
		String correo = request.getParameter("correo");
		String clave = request.getParameter("clave");
		

		if (correo != "" && clave != "") {
			
			RequestDispatcher rd = request.getRequestDispatcher("ControladorSrv");
			rd.forward(request, response);

		} else {
			sendLoginForm(response, true);
		}

	}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		

	}
	
	private void sendLoginForm(HttpServletResponse response, boolean withErrorMessage)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>Login</TITLE>");
		out.println("</HEAD>");
		out.println("<BODY>");
		if (withErrorMessage) {
			out.println("Login failed. Please try again.<BR>");}
		out.println("<BR>");
		out.println("<BR>Please enter your user name and password.");
		out.println("<BR><FORM ACTION=LogInUsr METHOD=POST>");
		out.println("<BR>User Name: <INPUT TYPE=TEXT NAME=username>");
		out.println("<BR>Password: <INPUT TYPE=PASSWORD NAME=pass>");
		out.println("<BR><INPUT TYPE=SUBMIT VALUE=Submit>");
		out.println("</FORM>");
		out.println("</BODY>");
		out.println("</HTML>");
	}

}
