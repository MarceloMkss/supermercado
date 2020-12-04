package com.ipartek.formacion.supermercado.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.supermercado.accesodatos.Dao;
import com.ipartek.formacion.supermercado.accesodatos.ProductoDAOSqlite;
import com.ipartek.formacion.supermercado.modelos.Producto;

/**
 * Servlet implementation class PerroDetalleController
 */
@WebServlet("/producto-detalle")
public class ProductoDetalleController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Dao<Producto> dao = ProductoDAOSqlite.getInstance();
		Iterable<Producto> productos = dao.listar();
		
		
		
		request.setAttribute("productos", productos);	
		request.getRequestDispatcher("/WEB-INF/vistas/tablaProducto.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
