package com.ipartek.formacion.supermercado.controladores.admin;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.supermercado.modelos.Cliente;


@WebServlet("/admin/cliente")
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//  permite crear mensajes para el seguimiento o registro de la ejecución de una aplicación en la consola.
	private Logger LOGGER = Logger.getLogger(ClienteServlet.class.getName());
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/vistas/admin/cliente.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");// para que podamos poner letras con simbolos ejemplo ñ
	
		// cogemos los datos que llegan de la jsp cliente
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String cif = request.getParameter("cif");
		String fechaNacimiento = request.getParameter("fecha-nacimiento");
		
		
		// metemos los datos en el constructor Cliente
		Cliente cliente = new Cliente(id, nombre, apellidos, cif, fechaNacimiento);
	
		LOGGER.info(cliente.toString());
		
		
		// si el cliente es correcto
		if (cliente.isCorrecto()) {
			LOGGER.warning("Cliente Correcto");// logger sirve para ver los errores en la consola
			response.sendRedirect(request.getContextPath() + "/admin/index"); // si es correcto enviamos los datos a la tabla clientes
			
			
		}else {
			LOGGER.warning("Cliente Incorrecto");
			request.setAttribute("cliente", cliente);
			request.getRequestDispatcher("/WEB-INF/vistas/admin/cliente.jsp").forward(request, response);
		}
		
	}

}
