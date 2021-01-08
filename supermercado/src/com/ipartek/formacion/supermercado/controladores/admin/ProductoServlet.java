package com.ipartek.formacion.supermercado.controladores.admin;



import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.supermercado.accesodatos.Dao;
import com.ipartek.formacion.supermercado.controladores.Configuracion;
import com.ipartek.formacion.supermercado.modelos.Producto;

/**
 * Servlet implementation class ProductoServlet
 */
@WebServlet("/admin/producto")
public class ProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	// para cargar imagenes
	/*private String pathFileString = "C:\\Users\\Marce\\git\\supermercado\\supermercado\\WebContent\\img";
    private File uploads = new File(pathFileString);
	private String [] extensioneStrings = {".ico",".png",".jpg",".jpeg"};*/

	
       
	private static final Logger LOGGER = Logger.getLogger(ProductoServlet.class.getName());
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. Recoger informaci�n de la petici�n

				String id = request.getParameter("id");

				// 2. Poner informaci�n dentro de un modelo
				// 3. Tomar decisiones seg�n lo recibido

				
				
				if (id != null) {
					Dao<Producto> dao = Configuracion.daoProductos;

					Producto producto = dao.obtenerPorId(Long.parseLong(id));

					// 4. Generar modelo para la vista

					request.setAttribute("producto", producto);
				}

				// 5. Redirigir a otra vista
				request.getRequestDispatcher("/WEB-INF/vistas/admin/producto.jsp").forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Cambiar codificaci�n de entrada de datos de formulario de Windows-1252 a UTF8

				request.setCharacterEncoding("utf-8");

				// 1. Recoger informaci�n de la petici�n

				String id = request.getParameter("id");
				String nombre = request.getParameter("nombre");
				String descripcion = request.getParameter("descripcion");
				String urlImagen = request.getParameter("imagen");				
				String precio = request.getParameter("precio");
				String descuento = request.getParameter("descuento");				
				String unidadMedida = request.getParameter("unidad-medida");
				String precioUnidadMedida = request.getParameter("precio-unidad-medida");
				String cantidad = request.getParameter("cantidad");
				String total= request.getParameter("total");
				

				// 2. Poner informaci�n dentro de un modelo

				Producto producto = new Producto(id, nombre, descripcion, urlImagen, precio, descuento, unidadMedida,
						precioUnidadMedida, cantidad,total);

				
				LOGGER.log(Level.INFO, producto.toString());

				// 3. Tomar decisiones seg�n lo recibido
				
				

				if (!producto.isCorrecto()) {
					// 4. Generar modelo para la vista
					request.setAttribute("producto", producto);
					// 5. Redirigir a otra vista
					request.getRequestDispatcher("/WEB-INF/vistas/admin/producto.jsp").forward(request, response);
					return;
				}

				Dao<Producto> dao = Configuracion.daoProductos;

				String mensaje;

				// si el producto tiene una id que vale null, esta vacio, quiere decir que queremos a�adir
				if (producto.getId() == null) {
					// creamos un producto
					dao.crear(producto);

					mensaje = "Se ha creado el producto correctamente";
				} else {
					// Si est� rellenado el id , es que queremos modificar
					dao.modificar(producto);

					mensaje = "Se ha modificado el producto correctamente";
				}

				// 4. Generar modelo para la vista

				request.setAttribute("alertaTexto", mensaje);
				request.setAttribute("alertaNivel", "success");

				// 5. Redirigir a otra vista

				request.getRequestDispatcher("/admin/index").forward(request, response);
	}

}
