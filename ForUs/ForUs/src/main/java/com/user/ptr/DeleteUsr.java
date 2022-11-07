package com.user.ptr;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DeleteUsr
 */
@WebServlet("/DeleteUsr")
public class DeleteUsr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUsr() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("===Acceso al servlet de Session===");
		System.out.println("Invocación al método INIT del Servlet");
		
		super.init(config);
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Invocación al método DESTROY del Servlet");
		super.destroy();
	}

	/**
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return super.getServletInfo();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Invocación al método SERVICE del Servlet UpdateUsr");
		
		super.service(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Invocación al método deGet del Servlet Delete");
		System.out.println("Acceso al Srv del User");
		
		System.out.println("Leyendo la sesion...");

		HttpSession session = request.getSession();
		if(leerSession(request, response)) {
			System.out.println("Enviando peticion al controlador del servlet...");
			RequestDispatcher rd = request.getRequestDispatcher("CtrlDelUsr");
			rd.forward(request, response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	public boolean leerSession(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session == null) {
			System.out.println("- La sesion se encuentra inactiva");
			System.out.println("Reedirigiendo al login...");
			response.sendRedirect("login.html");
		} else {
			System.out.println("- La sesion se encuentra activa");
			String loggedIn = (String) session.getAttribute("loggedIn");
			if (loggedIn.equals("true")) {
				return true;
			}

		}
		return false;
	}

}
