package com.controller.ptr;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CrtlAddUsr
 */
@WebServlet("/CrtlAddUsr")
public class CrtlAddUsr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrtlAddUsr() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("===Acceso al servlet controlador de Add User===");
		System.out.println("Invocación al método INIT del Servlet ctrlAdd");
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
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Invocación al método SERVICE del Servlet ctrl Add");
		
		LocalizadorSrv localizadorSrv = new LocalizadorSrv();
		request.setAttribute("Lcz", localizadorSrv);
		super.service(request, response);

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Invocación al método deGet del Servlet ctrl");

		response.getWriter().append("Served at CrtlAddUsr: ").append(request.getContextPath());//.append(request.getParameter("username"));
		response.getWriter().append(" Datos Ingresados: ");
		response.getWriter().append(" Name: ").append(request.getParameter("name"));
		response.getWriter().append(" Cell: ").append(request.getParameter("cell"));
		
		//IMPORTANTE AGREGAR ATRIBUTOS FALTANTES Y CONFIGURAR BD

		String nombres = request.getParameter("nombres");
		String apellidos = request.getParameter("apellidos");
		String correo = request.getParameter("correo");
		String clave = request.getParameter("clave");
		String cell = request.getParameter("cell");
		String doc = request.getParameter("doc");
		String direccion = request.getParameter("direccion");
		String ciudad = request.getParameter("ciudad");

		
		System.out.println("INFORMACION DE SOLICITUD... ");
		System.out.println(" * Nombres: " + nombres);
		System.out.println(" * Apellidos: " + apellidos);
		System.out.println(" * Correo: " + correo);
		System.out.println(" * Clave: " + clave);
		System.out.println(" * Cell: " + cell);
		System.out.println(" * Doc: " + doc);
		System.out.println(" * Direccion: " + direccion);
		System.out.println(" * Ciudad: " + ciudad);

		LocalizadorSrv localizadorSrv = (LocalizadorSrv) request.getAttribute("Lcz");

		System.out.println("Enviando solicitud al localizador de servicios");
		String res = localizadorSrv.addUser(nombres, apellidos, correo, clave,cell,doc,direccion,ciudad).toString(); 
		
		if(res!=null) {

			System.out.println("Respuesta del servidor en el metodo doGet de Servlet Add ctrl:");
			System.out.println("Respuesta: " + res);
			System.out.println(" - redirigiendo a LogIn...");
			response.sendRedirect("login.html");
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

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
