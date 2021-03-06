/**
 * server para conectar a la pagina de inicio index
 * @author Marcelo Kleibson
 */
package com.ipartek.formacion.supermercado.controladores;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.supermercado.accesodatos.Dao;
import com.ipartek.formacion.supermercado.modelos.Producto;

@MultipartConfig
@WebServlet("/pagina-principal")
public class PaginaPrincipalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		// llamo la instacia de ProductoDaoTreeMap, que contiene mi metodo Iterable<Producto> listar()
		Dao<Producto> dao = Configuracion.daoProductos;
		
		Iterable<Producto> productos = dao.listar();
		request.setAttribute("productos", productos);		
		request.getRequestDispatcher("/WEB-INF/vistas/paginaPrincipal.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);

	}

}
