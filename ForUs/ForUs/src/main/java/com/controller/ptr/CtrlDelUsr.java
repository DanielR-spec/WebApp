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
 * Servlet implementation class CtrlDelUsr
 */
@WebServlet("/CtrlDelUsr")
public class CtrlDelUsr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CtrlDelUsr() {
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
		System.out.println("Invocación al método deGet del Servlet ctrl");
		
		//IMPORTANTE AGREGAR ATRIBUTOS FALTANTES Y CONFIGURAR BD

		LocalizadorSrv localizadorSrv = (LocalizadorSrv) request.getAttribute("Lcz");

		String id = getId(request, response);
		
		System.out.println("Enviando solicitud al localizador de servicios");
		String res = localizadorSrv.delUser(id); 
		
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

}
