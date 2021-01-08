package com.ipartek.formacion.supermercado.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ipartek.formacion.supermercado.modelos.Producto;


public class ProductoDaoMySql implements Dao<Producto> {

	private static final String URL = "jdbc:mysql://localhost:3306/supermercado?serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASS = "";

	private static final String SQL_SELECT = "SELECT * FROM productos";
	private static final String SQL_SELECT_ID = "SELECT * FROM productos WHERE id = ?";

	private static final String SQL_INSERT = "INSERT INTO productos (nombre, descripcion, url_imagen, precio, descuento, unidad_medida, precio_unidad_medida, cantidad) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String SQL_UPDATE = "UPDATE productos SET nombre = ?, descripcion = ?, url_imagen = ?, precio = ?, descuento = ?, unidad_medida = ?, precio_unidad_medida = ?, cantidad = ? WHERE id = ?";
	private static final String SQL_DELETE = "DELETE FROM productos WHERE id = ?";

	static {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new AccesoDatosException("No se ha encontrado el driver de JDBC para MySQL", e);
		}
	}

	// SINGLETON

	// Ponemos privado el constructor por defecto para que nadie pueda crear
	// instancias de esta clase de forma libre
	// Con esto evitamos la posibilidad de que nadie haga new de esta clase (salvo
	// esta clase en s� misma)

	private ProductoDaoMySql() {

	}

	private static ProductoDaoMySql INSTANCIA = new ProductoDaoMySql();

	// Creamos un m�todo p�blico que de acceso a la �nica instancia disponible
	// Desde otras clases deberemos hacer
	// ProductoDaoTreeMap dao = ProductoDaoTreeMap.getInstancia();
	// o mejor
	// Dao<Producto> dao = ProductoDaoTreeMap.getInstancia();
	public static ProductoDaoMySql getInstancia() {
		return INSTANCIA;
	}

	// FIN SINGLETON

	// metodos del Dao
	@Override
	public Iterable<Producto> listar() {

		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(SQL_SELECT)) {

			ArrayList<Producto> productos = new ArrayList<>();

			// Producto producto;

			while (rs.next()) {

				productos.add(mapper(rs));

			} // while

			return productos;

		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido consultar la lista de productos", e);
		}

	}

	private Producto mapper(ResultSet rs) throws SQLException {

		Producto producto = new Producto(rs.getLong("id"), rs.getString("nombre"), rs.getString("descripcion"),
				rs.getString("url_imagen"), rs.getBigDecimal("precio"), rs.getInt("descuento"),
				rs.getString("unidad_medida"), rs.getBigDecimal("precio_unidad_medida"), rs.getInt("cantidad"),rs.getBigDecimal("total"));

		return producto;
	}

	@Override
	public Producto obtenerPorId(Long id) {
		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement ps = con.prepareStatement(SQL_SELECT_ID);) {

			ps.setLong(1, id);

			try (ResultSet rs = ps.executeQuery()) {
				Producto producto = null;

				if (rs.next()) {

					producto = new Producto(rs.getLong("id"), rs.getString("nombre"), rs.getString("descripcion"),
							rs.getString("url_imagen"), rs.getBigDecimal("precio"), rs.getInt("descuento"),
							rs.getString("unidad_medida"), rs.getBigDecimal("precio_unidad_medida"),
							rs.getInt("cantidad"),rs.getBigDecimal("total"));
				}

				return producto;
			}

		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido recibir el producto " + id, e);
		}

	}

	@Override
	public void crear(Producto producto) {

		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement ps = con.prepareStatement(SQL_INSERT);) {

			ps.setString(1, producto.getNombre());
			ps.setString(2, producto.getDescripcion());
			ps.setString(3, producto.getUrlImagen());
			ps.setBigDecimal(4, producto.getPrecio());
			ps.setInt(5, producto.getDescuento());
			ps.setString(6, producto.getUnidadMedida());
			ps.setBigDecimal(7, producto.getPrecioUnidadMedida());
			ps.setInt(8, producto.getCantidad());

			int numeroRegistrosInsertados = ps.executeUpdate();

			if (numeroRegistrosInsertados != 1) {
				throw new AccesoDatosException("Se han insertado " + numeroRegistrosInsertados + " registros");
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido insertar el usuario " + producto, e);
		}

	}

	@Override
	public void modificar(Producto producto) {
		
		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement ps = con.prepareStatement(SQL_UPDATE);) {

			ps.setString(1, producto.getNombre());
			ps.setString(2, producto.getDescripcion());
			ps.setString(3, producto.getUrlImagen());
			ps.setBigDecimal(4, producto.getPrecio());
			ps.setInt(5, producto.getDescuento());
			ps.setString(6, producto.getUnidadMedida());
			ps.setBigDecimal(7, producto.getPrecioUnidadMedida());
			ps.setInt(8, producto.getCantidad());
			ps.setLong(9, producto.getId());


			int numeroRegistrosModificados = ps.executeUpdate();

			if (numeroRegistrosModificados != 1) {
				throw new AccesoDatosException("Se han modificado " + numeroRegistrosModificados + " registros");
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido modificar el producto " + producto, e);
		}

	}

	@Override
	public void eliminar(Long id) {
		
		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement ps = con.prepareStatement(SQL_DELETE);) {

			ps.setLong(1, id);

			int numeroRegistrosBorrados = ps.executeUpdate();

			if (numeroRegistrosBorrados != 1) {
				throw new AccesoDatosException("Se han borrado " + numeroRegistrosBorrados + " registros");
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido borrar el producto " + id, e);
		}

	}

}
