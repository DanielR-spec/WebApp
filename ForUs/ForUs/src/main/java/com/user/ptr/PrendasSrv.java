package com.user.ptr;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrendasSrv
 */
@WebServlet("/PrendasSrv")
public class PrendasSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int SC_OK = 200;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrendasSrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("===Acceso al servlet de Prenda===");
		System.out.println("Invocaci�n al m�todo INIT del Servlet");
		
		super.init(config);
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Invocaci�n al m�todo DESTROY del Servlet");
		super.destroy();
	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return super.getServletConfig();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Invocaci�n al m�todo SERVICE del Servlet PrendaSrv");
		
		super.service(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	//ESTE SRV NO TIENE CONTROLADOR YA QUE SOLO ES PUETE PARA EXTRAER
	//LA INFORMACION
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("Invocaci�n al m�todo deGet del Servlet ctrl");

		String idUsuario = request.getParameter("idUsuario");
		String idDonaFire = request.getParameter("idDonaFire");
		String idDonaBack = request.getParameter("idDonaBack");
		
		System.out.println("INFORMACION DE SOLICITUD... ");
		System.out.println(" Parametros ");
		System.out.println("  * idUsuario: " + idUsuario);
		System.out.println("  * idDonaFire: " + idDonaFire);
		System.out.println("  * idDonaBack: " + idDonaBack);
		
		System.out.println("Almacenando informacion en cookies");

		Cookie c1 = new Cookie("idUsuario", idUsuario); 
		Cookie c2 = new Cookie("idDonaFire", idDonaFire);
		Cookie c3 = new Cookie("idDonaBack", idDonaBack);
		
		response.addCookie(c1); 
		response.addCookie(c2);
		response.addCookie(c3);
		
		System.out.println("Cookies almacenadas");
		System.out.println(" - redirigiendo a Prendas...");
		
		response.sendRedirect("prendas.html");

		response.setStatus(SC_OK);
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

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
