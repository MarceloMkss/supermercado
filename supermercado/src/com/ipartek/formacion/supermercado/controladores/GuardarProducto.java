package com.ipartek.formacion.supermercado.controladores;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.supermercado.accesodatos.Dao;
import com.ipartek.formacion.supermercado.accesodatos.ProductoDaoTreeMap;
import com.ipartek.formacion.supermercado.modelos.Producto;


@WebServlet("/Guardar-Producto")
public class GuardarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	
		request.getRequestDispatcher("/WEB-INF/vistas/formalta.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Dao<Producto> dao = ProductoDaoTreeMap.getInstancia();
		//Iterable<Producto> productos = dao.listar();
		
		
         String mensaje = ""; 
		
		//recibri datos del formulario, fijaros en el input el atributo 'name'
		Long id = (long) Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		String urlImagen = request.getParameter("urlImagen");		   			
	    BigDecimal precio = new BigDecimal(request.getParameter("precio"));
	    Integer descuento = Integer.parseInt(request.getParameter("descuento"));
	    String unidadMedida = request.getParameter("unidadMedida");
	    BigDecimal precioUnidadMedida = new BigDecimal(request.getParameter("precioUnidadMedida"));
	    Integer cantidad = Integer.parseInt(request.getParameter("cantidad"));
	    
	    
		
		Producto productos = new Producto(id, nombre, descripcion, urlImagen, precio, descuento, unidadMedida, precioUnidadMedida, cantidad);
	    
		
		// para usar lo de abajo con los seters tengo que contruir un construtor vacio en Producto
		
		/*producto.setId((long) id);
		producto.setNombre(nombre);
		producto.setNombre(descripcion);
		producto.setUrlImagen(urlImagen);		
		producto.setPrecio(precio);
		producto.setDescuento(descuento);
		producto.setUnidadMedida(unidadMedida);
		producto.setPrecioUnidadMedida(precioUnidadMedida);
		producto.setCantidad(cantidad);*/
								
		//guardarlo en la bbdd
		try {
			
			if ( id == 0 ) {	// si la id del perro es igual a zero, creamos un nuevo perro		
				dao.crear(productos);
				mensaje = "Producto insertado con exito";
			}else {
				dao.modificar(productos); // si no es igual a zero es que existe el perro y podemos modificar
				mensaje = "Producto Modificado con exito";
			}
			
		} catch (Exception e) {			
			e.printStackTrace();
			mensaje = "Lo sentimos pero " + productos.getNombre() +" el nombre del producto ya existe";
			
		}finally {
		
			// enviarlos a la JSP
			request.setAttribute("productos", productos);
			request.setAttribute("mensaje", mensaje);
			// ir a la JSP
			
			request.getRequestDispatcher("tablaProducto.jsp").forward(request, response);
		}
		
		



}
}	