package com.ipartek.formacion.supermercado.accesodatos;



public interface Dao<P> { // P = tipo de dato
	
	// si ponemos (defalt) cuando vayamos a implementar ese metodo en una clase, ya no saldra el mensaje de error, que nos avisaba que havia que implementar los metodos.

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
