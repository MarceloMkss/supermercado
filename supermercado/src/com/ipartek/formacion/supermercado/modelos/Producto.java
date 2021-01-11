package com.ipartek.formacion.supermercado.modelos;

import java.io.Serializable;
import java.math.BigDecimal;


public class Producto implements Serializable {
	
	/**
	 * nos genera automaticamente
	 */
	private static final long serialVersionUID = -101487878517228965L;
	//Atributos
	private Long id;
	private String nombre;
	private String descripcion;
	private String urlImagen;
	private BigDecimal precio;
	private Integer descuento;
	private String unidadMedida;
	private BigDecimal precioUnidadMedida;
	private Integer cantidad;
	private BigDecimal total;

	private Departamento departamento;
	
	private boolean correcto = true;

	private String errorId;
	private String errorNombre;
	private String errorDescripcion;
	private String errorUrlImagen;
	private String errorPrecio;
	private String errorDescuento;
	private String errorUnidadMedida;
	private String errorPrecioUnidadMedida;
	private String errorCantidad;
	private String errorTotal;

	public Producto(String id, String nombre, String descripcion, String urlImagen, String precio, String descuento,
			String unidadMedida, String precioUnidadMedida, String cantidad,String total) {

//		this(id.trim().length() != 0 ? Long.parseLong(id) : null, nombre, descripcion, urlImagen, new BigDecimal(precio), Integer.parseInt(descuento),
//				unidadMedida, new BigDecimal(precioUnidadMedida), Integer.parseInt(cantidad));
		setId(id);
		setNombre(nombre);
		setDescripcion(descripcion);
		setUrlImagen(urlImagen);
		setPrecio(precio);
		setDescuento(descuento);
		setUnidadMedida(unidadMedida);
		setPrecioUnidadMedida(precioUnidadMedida);
		setCantidad(cantidad);
		setTotal(total);
		
		
	}

	private void setTotal(String total) {
		
		
	}

	private void setCantidad(String cantidad) {
		try {
			setCantidad(Integer.parseInt(cantidad));
		} catch (Exception e) {
			setErrorCantidad("La cantidad debe ser un número");
		}
	}

	private void setPrecioUnidadMedida(String precioUnidadMedida) {
		try {
			setPrecioUnidadMedida(new BigDecimal(precioUnidadMedida));
		} catch (Exception e) {
			setErrorPrecioUnidadMedida("El precio de la unidad de medida debe ser numérico");
		}
	}

	private void setDescuento(String descuento) {
		try {
			setDescuento(Integer.parseInt(descuento));
		} catch (NumberFormatException e) {
			setErrorDescuento("El descuento debe ser un número entero");
		}
	}

	private void setPrecio(String precio) {
		try {
			setPrecio(new BigDecimal(precio));
		} catch (Exception e) {
			setErrorPrecio("El precio no tiene un formato correcto");
		}
	}

	private void setId(String id) {
		try {
			setId(id.trim().length() != 0 ? Long.parseLong(id) : null);
		} catch (NumberFormatException e) {
			setErrorId("El id debe ser numérico");
		}
	}

	public Producto(Long id, String nombre, String descripcion, String urlImagen, BigDecimal precio, Integer descuento,
			String unidadMedida, BigDecimal precioUnidadMedida, Integer cantidad, BigDecimal total) {
		setId(id);
		setNombre(nombre);
		setDescripcion(descripcion);
		setUrlImagen(urlImagen);
		setPrecio(precio);
		setDescuento(descuento);
		setUnidadMedida(unidadMedida);
		setPrecioUnidadMedida(precioUnidadMedida);
		setCantidad(cantidad);
		setTotal(total);
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		if (id != null && id <= 0) {
			setErrorId("No se admiten ids inferiores o iguales a 0");
		}
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre == null || nombre.trim().length() < 3 || !nombre.matches("\\p{Lu}\\p{Ll}{2}[\\p{Ll} ]*")) {
			setErrorNombre("Debe introducir un nombre con solo letras y mayúscula la primera. Mínimo 3 caracteres");
		}
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		// precio < 10 -----> precio.compareTo(new BigDecimal("10")) < 0
		// precio >= 100 ---> precio.compareTo(new BigDecimal("100")) >= 0
		// precio == 5 -----> precio.compareTo(new BigDecimal("5")) == 0
		if (precio == null || precio.compareTo(BigDecimal.ZERO) < 0) {
			setErrorPrecio("Debe rellenarse y ser mayor que 0");
		}

		this.precio = precio;
	}

	public Integer getDescuento() {
		return descuento;
	}

	public void setDescuento(Integer descuento) {
		if (descuento != null && (descuento < 0 || descuento > 100)) {
			setErrorDescuento("El descuento debe estar comprendido entre 0 y 100");
		}
		this.descuento = descuento;
	}

	public String getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	public BigDecimal getPrecioUnidadMedida() {
		return precioUnidadMedida;
	}

	public void setPrecioUnidadMedida(BigDecimal precioUnidadMedida) {
		if(precioUnidadMedida != null && precioUnidadMedida.compareTo(BigDecimal.ZERO) < 0) {
			setErrorPrecioUnidadMedida("No se admite un precio por unidad de medida negativo");
		}
		this.precioUnidadMedida = precioUnidadMedida;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		if(cantidad == null || cantidad < 0) {
			setCantidad("La cantidad debe ser mayor o igual a cero. Es obligatoria");
		}
		this.cantidad = cantidad;
	}

	public BigDecimal getTotal() {
		return total.add(getPrecioConDescuento().multiply(new BigDecimal(cantidad)));
		
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public BigDecimal getPrecioConDescuento() {
		if (descuento == null || descuento == 0) {
			return precio;
		}

		if (descuento == 100) {
			return BigDecimal.ZERO;
		}

		// return precio - (precio * (descuento / 100));
		return precio.subtract(precio.multiply(new BigDecimal(descuento).divide(new BigDecimal(100))));
	}

	public boolean isCorrecto() {
		return correcto;
	}

	public void setCorrecto(boolean correcto) {
		this.correcto = correcto;
	}

	public String getErrorId() {
		return errorId;
	}

	public void setErrorId(String errorId) {
		correcto = false;
		this.errorId = errorId;
	}

	public String getErrorNombre() {
		return errorNombre;
	}

	public void setErrorNombre(String errorNombre) {
		correcto = false;
		this.errorNombre = errorNombre;
	}

	public String getErrorDescripcion() {
		return errorDescripcion;
	}

	public void setErrorDescripcion(String errorDescripcion) {
		correcto = false;
		this.errorDescripcion = errorDescripcion;
	}

	public String getErrorUrlImagen() {
		return errorUrlImagen;
	}

	public void setErrorUrlImagen(String errorUrlImagen) {
		correcto = false;
		this.errorUrlImagen = errorUrlImagen;
	}

	public String getErrorPrecio() {
		return errorPrecio;
	}

	public void setErrorPrecio(String errorPrecio) {
		correcto = false;
		this.errorPrecio = errorPrecio;
	}

	public String getErrorDescuento() {
		return errorDescuento;
	}

	public void setErrorDescuento(String errorDescuento) {
		correcto = false;
		this.errorDescuento = errorDescuento;
	}

	public String getErrorUnidadMedida() {
		return errorUnidadMedida;
	}

	public void setErrorUnidadMedida(String errorUnidadMedida) {
		correcto = false;
		this.errorUnidadMedida = errorUnidadMedida;
	}

	public String getErrorPrecioUnidadMedida() {
		return errorPrecioUnidadMedida;
	}

	public void setErrorPrecioUnidadMedida(String errorPrecioUnidadMedida) {
		correcto = false;
		this.errorPrecioUnidadMedida = errorPrecioUnidadMedida;
	}

	public String getErrorCantidad() {
		return errorCantidad;
	}

	public void setErrorCantidad(String errorCantidad) {
		correcto = false;
		this.errorCantidad = errorCantidad;
	}

	public String getErrorTotal() {
		return errorTotal;
	}

	public void setErrorTotal(String errorTotal) {
		correcto = false;
		this.errorTotal = errorTotal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cantidad == null) ? 0 : cantidad.hashCode());
		result = prime * result + (correcto ? 1231 : 1237);
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((descuento == null) ? 0 : descuento.hashCode());
		result = prime * result + ((errorCantidad == null) ? 0 : errorCantidad.hashCode());
		result = prime * result + ((errorDescripcion == null) ? 0 : errorDescripcion.hashCode());
		result = prime * result + ((errorDescuento == null) ? 0 : errorDescuento.hashCode());
		result = prime * result + ((errorId == null) ? 0 : errorId.hashCode());
		result = prime * result + ((errorNombre == null) ? 0 : errorNombre.hashCode());
		result = prime * result + ((errorPrecio == null) ? 0 : errorPrecio.hashCode());
		result = prime * result + ((errorPrecioUnidadMedida == null) ? 0 : errorPrecioUnidadMedida.hashCode());
		result = prime * result + ((errorTotal == null) ? 0 : errorTotal.hashCode());
		result = prime * result + ((errorUnidadMedida == null) ? 0 : errorUnidadMedida.hashCode());
		result = prime * result + ((errorUrlImagen == null) ? 0 : errorUrlImagen.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((precio == null) ? 0 : precio.hashCode());
		result = prime * result + ((precioUnidadMedida == null) ? 0 : precioUnidadMedida.hashCode());
		result = prime * result + ((total == null) ? 0 : total.hashCode());
		result = prime * result + ((unidadMedida == null) ? 0 : unidadMedida.hashCode());
		result = prime * result + ((urlImagen == null) ? 0 : urlImagen.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (cantidad == null) {
			if (other.cantidad != null)
				return false;
		} else if (!cantidad.equals(other.cantidad))
			return false;
		if (correcto != other.correcto)
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (descuento == null) {
			if (other.descuento != null)
				return false;
		} else if (!descuento.equals(other.descuento))
			return false;
		if (errorCantidad == null) {
			if (other.errorCantidad != null)
				return false;
		} else if (!errorCantidad.equals(other.errorCantidad))
			return false;
		if (errorDescripcion == null) {
			if (other.errorDescripcion != null)
				return false;
		} else if (!errorDescripcion.equals(other.errorDescripcion))
			return false;
		if (errorDescuento == null) {
			if (other.errorDescuento != null)
				return false;
		} else if (!errorDescuento.equals(other.errorDescuento))
			return false;
		if (errorId == null) {
			if (other.errorId != null)
				return false;
		} else if (!errorId.equals(other.errorId))
			return false;
		if (errorNombre == null) {
			if (other.errorNombre != null)
				return false;
		} else if (!errorNombre.equals(other.errorNombre))
			return false;
		if (errorPrecio == null) {
			if (other.errorPrecio != null)
				return false;
		} else if (!errorPrecio.equals(other.errorPrecio))
			return false;
		if (errorPrecioUnidadMedida == null) {
			if (other.errorPrecioUnidadMedida != null)
				return false;
		} else if (!errorPrecioUnidadMedida.equals(other.errorPrecioUnidadMedida))
			return false;
		if (errorTotal == null) {
			if (other.errorTotal != null)
				return false;
		} else if (!errorTotal.equals(other.errorTotal))
			return false;
		if (errorUnidadMedida == null) {
			if (other.errorUnidadMedida != null)
				return false;
		} else if (!errorUnidadMedida.equals(other.errorUnidadMedida))
			return false;
		if (errorUrlImagen == null) {
			if (other.errorUrlImagen != null)
				return false;
		} else if (!errorUrlImagen.equals(other.errorUrlImagen))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (precio == null) {
			if (other.precio != null)
				return false;
		} else if (!precio.equals(other.precio))
			return false;
		if (precioUnidadMedida == null) {
			if (other.precioUnidadMedida != null)
				return false;
		} else if (!precioUnidadMedida.equals(other.precioUnidadMedida))
			return false;
		if (total == null) {
			if (other.total != null)
				return false;
		} else if (!total.equals(other.total))
			return false;
		if (unidadMedida == null) {
			if (other.unidadMedida != null)
				return false;
		} else if (!unidadMedida.equals(other.unidadMedida))
			return false;
		if (urlImagen == null) {
			if (other.urlImagen != null)
				return false;
		} else if (!urlImagen.equals(other.urlImagen))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", urlImagen=" + urlImagen
				+ ", precio=" + precio + ", descuento=" + descuento + ", unidadMedida=" + unidadMedida
				+ ", precioUnidadMedida=" + precioUnidadMedida + ", cantidad=" + cantidad + ", total=" + total
				+ ", correcto=" + correcto + ", errorId=" + errorId + ", errorNombre=" + errorNombre
				+ ", errorDescripcion=" + errorDescripcion + ", errorUrlImagen=" + errorUrlImagen + ", errorPrecio="
				+ errorPrecio + ", errorDescuento=" + errorDescuento + ", errorUnidadMedida=" + errorUnidadMedida
				+ ", errorPrecioUnidadMedida=" + errorPrecioUnidadMedida + ", errorCantidad=" + errorCantidad
				+ ", errorTotal=" + errorTotal + "]";
	}

	

	}