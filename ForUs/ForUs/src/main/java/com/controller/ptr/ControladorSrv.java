package com.controller.ptr;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.ptr.UsuarioDAO;

/**
 * Servlet implementation class ControladorServ
 */
@WebServlet("/ControladorSrv")
public class ControladorSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int SC_OK = 200;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControladorSrv() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("===Acceso al servlet controlador de User Login===");
		System.out.println("Invocaci�n al m�todo INIT del Servlet ctrl");
		super.init(config);

	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Invocaci�n al m�todo DESTROY del Servlet ctrl");
		super.destroy();
	}


	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Invocaci�n al m�todo SERVICE del Servlet ctrl");
		
		LocalizadorSrv localizadorSrv = new LocalizadorSrv();
		request.setAttribute("Lcz", localizadorSrv);
		super.service(request, response);

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("Invocaci�n al m�todo deGet del Servlet ctrl");

		String correo = request.getParameter("correo");
		String clave = request.getParameter("clave");
		String id = "";
		
		System.out.println("INFORMACION DE SOLICITUD... ");
		System.out.println(" Parametros ");
		System.out.println("  * Correo: " + correo);
		System.out.println("  * Clave: " + clave);

		LocalizadorSrv localizadorSrv = (LocalizadorSrv) request.getAttribute("Lcz");
		
		System.out.println("Enviando solicitud al localizador de servicios");
		//String res = localizadorSrv.getUser(correo, clave).toString();
		String res = "yeas";

		//AGREGAR EL ID EN LA COOKIE CUANDO SE LEA EL JSON DESDE EL BACK
//		int index = res.indexOf("\"" + "id" + "\"") !=-1?  res.indexOf("\"" + "id" + "\""): 0;
//		System.out.println("index id: " + index);
//		
//		for (int i = 0; i < res.length(); i++) {
//			 
//            // Print current character
//			if (i == index) {
//				id = String.valueOf(res.charAt(index+5));
//				System.out.println("id: " + id);
//			}
//            
//        }
	
		id = "2";
		if(id!="") {

			System.out.println("Respuesta del servidor en el metodo doGet de Servlet Login ctrl: ");
			System.out.println(" - Id Usuario: " + id );
			

			Cookie c1 = new Cookie("correo", correo); 
			Cookie c2 = new Cookie("clave", clave);
			Cookie c3 = new Cookie("id", id);
			
			response.addCookie(c1); 
			response.addCookie(c2);
			response.addCookie(c3);
			
			System.out.println("Creando Sesion de usuario...");
			//Crear session usuario
			HttpSession session = request.getSession(true); 
			session.setMaxInactiveInterval(300);    // session timeout in seconds
			session.setAttribute("loggedIn", new String("true")); 
			
			// Redirigir a otro servlet para realizar las operaciones
			System.out.println("Informacion de session almacenada");
			System.out.println(" - redirigiendo al DashBoard...");
			response.sendRedirect("dash.html");
			
		}

		response.setStatus(SC_OK);
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
}
