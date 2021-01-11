package com.ipartek.formacion.supermercado.accesodatos;



public interface Dao<P> { // P = tipo de dato

	default Iterable<P> listar(){
		throw new AccesoDatosException("MÉTODO NO IMPLEMENTADO");
	}	

	default P  obtenerPorId(Long id) {
		throw new AccesoDatosException("MÉTODO NO IMPLEMENTADO");
	}

	default void crear(P objeto) {
		throw new AccesoDatosException("MÉTODO NO IMPLEMENTADO");
	}

	default void modificar(P objeto) {
		throw new AccesoDatosException("MÉTODO NO IMPLEMENTADO");
	}

	default void eliminar(Long id) {
		throw new AccesoDatosException("MÉTODO NO IMPLEMENTADO");
	}
	
}
