/**
 * server para conectar a la pagina de inicio index
 * @author Marcelo Kleibson
 */
package com.ipartek.formacion.supermercado.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.supermercado.accesodatos.Dao;
import com.ipartek.formacion.supermercado.accesodatos.ProductoDaoTreeMap;
import com.ipartek.formacion.supermercado.modelos.Producto;

@WebServlet("/inicio-controller")
public class InicioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Dao<Producto> dao = ProductoDaoTreeMap.getInstancia();
		Iterable<Producto> productos = dao.listar();
		request.setAttribute("productos", productos);
		request.getRequestDispatcher("/WEB-INF/vistas/index.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);

	}

}
