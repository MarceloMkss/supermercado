package com.ipartek.formacion.supermercado.modelos;

import java.math.BigDecimal;

public class Producto {
	
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
	
	
	
	//Construtor
	public Producto() {
		super();
		
	}
	
	public Producto(Long id, String nombre, String descripcion, String urlImagen, BigDecimal precio, Integer descuento,
			String unidadMedida, BigDecimal precioUnidadMedida, Integer cantidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.urlImagen = urlImagen;
		this.precio = precio;
		this.descuento = descuento;
		this.unidadMedida = unidadMedida;
		this.precioUnidadMedida = precioUnidadMedida;
		this.cantidad = cantidad;
	}


	// metodo Geters y Seters

	


	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
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
		this.precio = precio;
	}



	public Integer getDescuento() {
		return descuento;
	}



	public void setDescuento(Integer descuento) {
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
		this.precioUnidadMedida = precioUnidadMedida;
	}



	public Integer getCantidad() {
		return cantidad;
	}



	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}


	public BigDecimal getPrecioConDescuento() {
		
		
		if(descuento == null || descuento == 0) {
			return null;
		}
		
		if(descuento == 100) {
			return BigDecimal.ZERO;
		}
		
		//return precio - precio * descuento / 100
		return precio.subtract(precio.multiply(new BigDecimal(descuento).divide(new BigDecimal(100))));
	
	}
	
	// metodo toString
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", urlImagen=" + urlImagen
				+ ", precio=" + precio + ", descuento=" + descuento + ", unidadMedida=" + unidadMedida
				+ ", precioUnidadMedida=" + precioUnidadMedida + ", cantidad=" + cantidad + "]";
	}
	
	
	
	
	
	
	
	

	
	
	


	}