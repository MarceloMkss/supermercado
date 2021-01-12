package com.ipartek.formacion.supermercado.controladores.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ipartek.formacion.supermercado.controladores.Configuracion;


/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/admin/lista-Producto")
public class ListaProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("productos", Configuracion.daoProductos.listar());
		request.getRequestDispatcher("/WEB-INF/vistas/admin/listaProducto.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
