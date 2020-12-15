package com.ipartek.formacion.supermercado.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.supermercado.accesodatos.UsuarioDaoTreeMap;
import com.ipartek.formacion.supermercado.modelos.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UsuarioDaoTreeMap dao = UsuarioDaoTreeMap.getInstancia();
		Usuario usuario = dao.obtenerPorEmail(email);
		
		
		
		 
		if(usuario != null && usuario.getPassword().equals(password)) {
			request.getSession().setAttribute("usuario", usuario);			
			//request.getRequestDispatcher("/admin/index").forward(request, response);
			response.sendRedirect(request.getContextPath()+ "/admin/index");
		} else {
			request.setAttribute("alertaTexto", "el usuario o la contrase�a son incorrectos");
			request.setAttribute("alertaNivel", "danger");
			
			request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
		}

       
	}

}
