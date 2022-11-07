package com.controller.ptr;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CtrlUpdUsr
 */
@WebServlet("/CtrlUpdUsr")
public class CtrlUpdUsr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CtrlUpdUsr() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("===Acceso al servlet controlador de User Update===");
		System.out.println("Invocación al método INIT del Servlet Update");
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
		System.out.println("Invocación al método SERVICE del Servlet ctrlUpd");
		
		LocalizadorSrv localizadorSrv = new LocalizadorSrv();
		request.setAttribute("Lcz", localizadorSrv);
		
		super.service(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Acceso al controlador de actualizar usuario");

		response.getWriter().append("Served at CrtlUpdUsr: ").append(request.getContextPath());//.append(request.getParameter("username"));
		response.getWriter().append(" Datos Ingresados: ");
		response.getWriter().append(" Name: ").append(request.getParameter("nombres"));
		response.getWriter().append(" lastName: ").append(request.getParameter("apellidos"));
		
		//IMPORTANTE AGREGAR ATRIBUTOS FALTANTES Y CONFIGURAR BD

		String nombres = request.getParameter("nombres");
		String apellidos = request.getParameter("apellidos");
		String correo = request.getParameter("correo");
		String clave = request.getParameter("clave");
		String cell = request.getParameter("cell");
		String doc = request.getParameter("doc");
		String direccion = request.getParameter("direccion");
		
		System.out.println("INFORMACION DE SOLICITUD... ");
		System.out.println(" * Nombres: " + nombres);
		System.out.println(" * Apellidos: " + apellidos);
		System.out.println(" * Correo: " + correo);
		System.out.println(" * Clave: " + clave);
		System.out.println(" * Cell: " + cell);
		System.out.println(" * Doc: " + doc);
		System.out.println(" * Direccion: " + direccion);

		LocalizadorSrv localizadorSrv = (LocalizadorSrv) request.getAttribute("Lcz");

		String id = getId(request, response);
		String res = localizadorSrv.updUser(id, nombres, apellidos, correo, clave,cell,doc,direccion); 
		
		if(res!=null) {

			System.out.println("respuesta: " + res);
			
			response.sendRedirect("login.html");
		}
		
	}
	
	public String getId(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		Cookie[] cookies = request.getCookies(); 
		String id = "0";
		int length = cookies.length; 
		for (int i=0; i<length; i++) { 
		 Cookie cookie = cookies[i]; 
		 
		 if (cookie.getName().equals("id")) 
		 {
			 id = cookie.getValue();
		 }

		}
		return id;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}

}
