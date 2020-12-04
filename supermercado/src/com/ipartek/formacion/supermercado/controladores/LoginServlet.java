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
		
		String mensaje = ""; 
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UsuarioDaoTreeMap dao = UsuarioDaoTreeMap.getInstancia();
		Usuario usuario = dao.obtenerPorEmail(email);
		
		try {
			dao.crear(usuario);
			 mensaje = "Usuario insertado con exito";
		} catch (Exception e) {
			e.printStackTrace();
			mensaje = "Lo sentimos pero " + usuario.getEmail() +" el nombre del Usuario ya existe";
			
		} finally {
			request.setAttribute("usuario", usuario);
			request.setAttribute("mensaje", mensaje);
		}
		
		
		 
		if(usuario != null && usuario.getPassword().equals(password)) {
			request.getSession().setAttribute("usuario", usuario);
			request.getRequestDispatcher("/inicio-controller").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
		}

       
	}

}
