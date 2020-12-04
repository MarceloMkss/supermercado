package com.ipartek.formacion.supermercado.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.supermercado.accesodatos.Dao;
import com.ipartek.formacion.supermercado.accesodatos.UsuarioDaoTreeMap;
import com.ipartek.formacion.supermercado.modelos.Usuario;


/**
 * Servlet implementation class PerroDetalleController
 */
@WebServlet("/usuario-detalle")
public class UsuarioDetalleController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Dao<Usuario> dao = UsuarioDaoTreeMap.getInstancia();
		Iterable<Usuario> usuario = dao.listar();
		
		
		
		request.setAttribute("usuario", usuario);	
		request.getRequestDispatcher("/WEB-INF/vistas/listaUsuarios.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
