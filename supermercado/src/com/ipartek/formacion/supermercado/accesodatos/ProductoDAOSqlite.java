package com.ipartek.formacion.supermercado.accesodatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.supermercado.modelos.Producto;

public class ProductoDAOSqlite implements Dao<Producto> {
	
	private static ProductoDAOSqlite INSTANCE = null;
	
	public synchronized static  ProductoDAOSqlite getInstance() {
		if ( INSTANCE == null ) {
			INSTANCE = new ProductoDAOSqlite();
		}
		return INSTANCE;
	}

	@Override
	public Iterable<Producto> listar() {
		
				
		final String SQL = "SELECT id, nombre, descripcion, urlImage, precio, descuento,unidadMedida,precioUnidadMedida,cantidad FROM producto ORDER BY nombre ASC;";
		ArrayList<Producto> productos = new ArrayList<Producto>();
		
		
		try (	Connection conn = ConectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL);
				ResultSet rs = pst.executeQuery();) {

			System.out.println("***" + pst);
			
			while (rs.next()) {
								
				productos.add(mapper(rs));
				

			} // while

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return productos;
		
	}	
			


	@Override
	public Producto recuperar(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void crear(Producto objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(Producto objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	private Producto mapper( ResultSet rs ) throws SQLException {
		
		Producto productos = new Producto();
		
		
		productos.setId(rs.getLong("id"));
		productos.setNombre(rs.getString("nombre"));
		productos.setDescripcion(rs.getString("descripcion"));
		productos.setUrlImagen(rs.getString("urlImagen"));
		productos.setPrecio(rs.getBigDecimal("precio"));
		productos.setDescuento(rs.getInt("descuento"));
		productos.setUnidadMedida(rs.getString("unidadMedida"));
		productos.setPrecioUnidadMedida(rs.getBigDecimal("precioUnidadMedida"));
		productos.setCantidad(rs.getInt("cantidad"));
		
		
		
			
		return productos;
		
		
	}


	
}
